package guru.qa.rococo.page;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.component.Picture;
import guru.qa.rococo.page.museum.MuseumPage;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@ParametersAreNonnullByDefault
public class ProfilePage extends BasePage<ProfilePage> {
    private final SelenideElement self = $("div[data-testid='modal-component']");
    private final SelenideElement logoutBtn = self.$("button.variant-ghost");
    private final SelenideElement title = self.$("header");
    private final SelenideElement avatar = self.$("img.avatar-image");
    private final SelenideElement photoInput = self.$("input[type='file']");
    private final SelenideElement nameInput = self.$("input[name='firstname']");
    private final SelenideElement lastnameInput = self.$("input[name='surname']");
    private final SelenideElement closeBtn = self.$("button.variant-ringed");
    private final SelenideElement saveBtn = self.$("button[type='submit']");
    private final Picture image = new Picture(avatar);

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

    @Step("Ввести имя: '{0}'")
    @Nonnull
    public ProfilePage setFirstName(String name) {
        nameInput.clear();
        nameInput.setValue(name);
        return this;
    }

    @Step("Ввести фамилию: '{0}'")
    @Nonnull
    public ProfilePage setLastName(String name) {
        lastnameInput.clear();
        lastnameInput.setValue(name);
        return this;
    }

    @Step("Проверить имя: '{0}'")
    @Nonnull
    public ProfilePage checkFirstName(String name) {
        nameInput.shouldHave(value(name));
        return this;
    }

    @Step("Проверить фамилию: '{0}'")
    @Nonnull
    public ProfilePage checkLastName(String name) {
        lastnameInput.shouldHave(value(name));
        return this;
    }

    @Step("Загрузить фото: '{0}'")
    @Nonnull
    public ProfilePage uploadPhoto(String path) {
        photoInput.uploadFromClasspath(path);
        return this;
    }

    @Step("Нажать кнопку 'Сохранить'")
    @Nonnull
    public MainPage save() {
        saveBtn.click();
        return new MainPage();
    }

    @Step("Проверить фото")
    @Nonnull
    public ProfilePage checkPhoto(BufferedImage expected) throws IOException {
        image.checkPhoto(expected);
        return this;
    }
}
