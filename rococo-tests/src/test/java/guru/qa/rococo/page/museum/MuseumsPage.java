package guru.qa.rococo.page.museum;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;
import guru.qa.rococo.page.component.HeaderPage;
import guru.qa.rococo.page.component.SearchField;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@ParametersAreNonnullByDefault
public class MuseumsPage extends BasePage<MuseumsPage> {
    public static final String URL = CFG.frontUrl() + "museum";
    protected final HeaderPage header = new HeaderPage();
    protected final SearchField searchField = new SearchField();
    private final SelenideElement mainTitle = $("h2.text-3xl");
    private final SelenideElement addMuseumBtn = $("main button.btn");
    private final ElementsCollection museums = $$("ul.grid li");


    @Step("Проверить, что страница загрузилась")
    public MuseumsPage checkMuseumsPageIsLoaded() {
        mainTitle.should(visible).shouldHave(text("Музеи"));
        return this;
    }

    @Step("Перейти к добавлению музея")
    @Nonnull
    public AddNewMuseumPage addMuseum() {
        addMuseumBtn.click();
        return new AddNewMuseumPage();
    }

    @Step("Искать музей с названием '{museumName}'")
    @Nonnull
    public MuseumsPage searchMuseum(String museumName) {
        searchField.search(museumName);
        return this;
    }

    @Step("Проверить, что музей '{museumName}' есть в результатах поиска")
    @Nonnull
    public MuseumsPage checkMuseumExists(String museumName) {
        searchMuseum(museumName);
        museums.find(text(museumName)).should(visible);
        return this;
    }

    @Step("Открыть музей с названием '{museumName}'")
    @Nonnull
    public MuseumPage openMuseum(String museumName) {
        searchMuseum(museumName);
        museums.find(text(museumName)).click();
        return new MuseumPage();
    }
}
