package guru.qa.rococo.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@ParametersAreNonnullByDefault
public class ProfilePage extends BasePage<ProfilePage> {
    private final SelenideElement self = $("div[data-testid='modal-component']");
    private final SelenideElement logoutBtn = self.$("button.variant-ghost");
    private final SelenideElement title = self.$("header");
    private final SelenideElement avatar = self.$("svg.avatar-initials");
    private final SelenideElement photoInput = self.$("input[type='file']");
    private final SelenideElement nameInput = self.$("input[name='firstname']");
    private final SelenideElement lastnameInput = self.$("input[name='surname']");
    private final SelenideElement closeBtn = self.$("button.variant-ringed");
    private final SelenideElement saveBtn = self.$("button[type='submit']");

    @Step("Проверить, что страница загрузилась")
    public ProfilePage checkProfilePageIsLoaded() {
        logoutBtn.shouldBe(visible);
        title.shouldBe(visible).shouldHave(text("Профиль"));
        avatar.shouldBe(visible);
        photoInput.shouldBe(visible);
        nameInput.shouldBe(visible);
        lastnameInput.shouldBe(visible);
        closeBtn.shouldBe(visible);
        saveBtn.shouldBe(visible);
        return this;
    }

    @Step("Нажать кнопку 'Выйти'")
    public MainPage clickLogoutBtn() {
        logoutBtn.click();
        return new MainPage();
    }
}
