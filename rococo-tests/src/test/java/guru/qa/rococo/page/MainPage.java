package guru.qa.rococo.page;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.component.HeaderPage;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@ParametersAreNonnullByDefault
public class MainPage extends BasePage<MainPage> {
    public static final String URL = CFG.frontUrl();
    protected final HeaderPage header = new HeaderPage();
    private final SelenideElement mainTitle = $("p.text-center");
    private final SelenideElement paintings = $("img[alt='Ссылка на картины']");
    private final SelenideElement artists = $("img[alt='Ссылка на художников']");
    private final SelenideElement museums = $("img[alt='Ссылка на музеи']");

    @Nonnull
    public HeaderPage getHeader() {
        return header;
    }

    @Step("Проверить, что страница загрузилась")
    public MainPage checkMainPageIsLoaded() {
        header.checkHeaderIsLoaded();
        mainTitle.shouldBe(visible);
        paintings.shouldBe(visible);
        artists.shouldBe(visible);
        museums.shouldBe(visible);
        return this;
    }
}
