package guru.qa.rococo.page.painting;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;
import guru.qa.rococo.page.MainPage;
import guru.qa.rococo.page.component.HeaderPage;
import guru.qa.rococo.page.component.SearchField;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaintingsPage extends BasePage<PaintingsPage> {
    public static final String URL = CFG.frontUrl() + "painting";
    protected final HeaderPage header = new HeaderPage();
    protected final SearchField searchField = new SearchField();
    private final SelenideElement mainTitle = $("h2.text-3xl");
    private final SelenideElement addPaintingBtn = $("main button.btn");
    private final ElementsCollection paintings = $$("ul.grid div.text-center");
    private final String imageByText = "img[alt='%s']";


    @Step("Проверить, что страница загрузилась")
    public PaintingsPage checkPaintingPageIsLoaded() {
        mainTitle.should(visible).shouldHave(text("Картины"));
        return this;
    }

    @Step("Перейти к добавлению картины")
    @Nonnull
    public AddNewPaintingPage addPainting() {
        addPaintingBtn.click();
        return new AddNewPaintingPage();
    }

    @Step("Искать картину по названию: '{0}'")
    @Nonnull
    public PaintingsPage searchPainting(String paintingName) {
        searchField.search(paintingName);
        return this;
    }

    @Step("Открыть картину с названием: '{0}'")
    @Nonnull
    public PaintingPage openPainting(String paintingName) {
        $(imageByText.formatted(paintingName)).click();
        return new PaintingPage();
    }

    @Step("Проверить, что картина {paintingName} есть в результатах поиска")
    @Nonnull
    public PaintingsPage checkPaintingExists(String paintingName) {
        searchPainting(paintingName);
        paintings.find(text(paintingName)).should(visible);
        return this;
    }
}
