package guru.qa.rococo.page;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.config.Config;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@ParametersAreNonnullByDefault
public class HeaderPage  {

    private final SelenideElement self = $("div[data-testid='app-bar']");
    private final SelenideElement rococoTitle = self.$("h1.text-6xl");
    private final SelenideElement paintingTitle = self.$("a[href='/painting']");
    private final SelenideElement artistsTitle = self.$("a[href='/artist']");
    private final SelenideElement museumsTitle = self.$("a[href='/museum']");
    private final SelenideElement switchModeBtn = self.$("div[role='switch']");
    private final SelenideElement loginBtn = self.$("button.variant-filled-primary");

    @Step("Проверить, что страница загрузилась")
    public HeaderPage checkHeaderIsLoaded() {
        rococoTitle.shouldBe(visible);
        paintingTitle.shouldBe(visible);
        artistsTitle.shouldBe(visible);
        museumsTitle.shouldBe(visible);
        switchModeBtn.shouldBe(visible);
        return this;
    }

    @Step("Открыть страницу логина")
    public LoginPage openLoginPage() {
        loginBtn.click();
        return new LoginPage();
    }
//
//    public ArtistsPage openArtistsPage() {
//        artistsTitle.click();
//        return null;
//    }
//
//    public MuseumsPage openMuseumsPage() {
//        museumsTitle.click();
//        return null;
//    }
}
