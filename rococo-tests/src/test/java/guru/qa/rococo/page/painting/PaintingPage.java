package guru.qa.rococo.page.painting;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;
import guru.qa.rococo.page.MainPage;
import guru.qa.rococo.page.component.HeaderPage;
import guru.qa.rococo.page.component.SearchField;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class PaintingPage extends BasePage<MainPage> {
    protected final HeaderPage header = new HeaderPage();
    protected final SearchField searchField = new SearchField();
    private final SelenideElement mainTitle = $("h2.text-3xl");
    private final SelenideElement addArtistBtn = $("main button.btn");



    @Step("Проверить, что страница загрузилась")
    public PaintingPage checkArtistPageIsLoaded() {
        return this;
    }
}
