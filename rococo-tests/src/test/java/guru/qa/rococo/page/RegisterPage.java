package guru.qa.rococo.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@ParametersAreNonnullByDefault
public class RegisterPage extends BasePage<RegisterPage> {
    public static final String URL = CFG.authUrl() + "register";

    private final SelenideElement usernameInput = $("input[name='username']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement submitPasswordInput = $("input[name='passwordSubmit']");
    private final SelenideElement signUpBtn = $("button[type='submit']");
    private final SelenideElement signInBtn = $("a[data-testid='loginButton']");
    private final SelenideElement errorMessage = $(".form__error");

    @Override
    public RegisterPage checkPageIsLoaded() {
        usernameInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        signUpBtn.shouldBe(visible);
        signInBtn.shouldBe(visible);
        return null;
    }


    @Step("Ввести имя: '{username}'")
    @Nonnull
    public RegisterPage setUserName(String username) {
        usernameInput.setValue(username);
        return this;
    }

    @Step("Ввести пароль: '{password}'")
    @Nonnull
    public RegisterPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Подтвердить пароль: '{password}'")
    @Nonnull
    public RegisterPage setPasswordSubmit(String password) {
        submitPasswordInput.setValue(password);
        return this;
    }

    @Step("Нажать кнопку 'Зарегистрироваться'")
    @Nonnull
    public RegisterPage submitRegistration() {
        signUpBtn.click();
        return this;
    }

    @Step("Нажать кнопку 'Войти'")
    @Nonnull
    public RegisterPage clickSignInBtn() {
        signInBtn.click();
        return this;
    }

    @Step("Зарегистрироваться с именем - '{username}', паролем - '{password}'")
    @Nonnull
    public LoginPage doRegister(String username, String password, String submitPassword) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        submitPasswordInput.setValue(submitPassword);
        signUpBtn.click();
        signInBtn.click();
        return new LoginPage();
    }

    @Step("Проверить ошибку с текстом '{errorText}'")
    @Nonnull
    public RegisterPage checkErrorMessage(String errorText) {
        errorMessage.shouldBe(visible).shouldHave(exactText(errorText));
        return this;
    }
}
