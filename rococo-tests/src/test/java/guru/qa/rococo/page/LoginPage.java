package guru.qa.rococo.page;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@ParametersAreNonnullByDefault
public class LoginPage extends BasePage<LoginPage> {
    public static final String URL = CFG.authUrl() + "login";

    private final SelenideElement usernameInput = $("input[name='username']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement submitBtn = $("button[type='submit']");
    private final SelenideElement createAccountBtn = $("a[href='/register']");
    private final SelenideElement errorMessage = $("p.form__error");

    @Step("Проверить, что страница загрузилась")
    public LoginPage checkLoginPageIsLoaded() {
        usernameInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        submitBtn.shouldBe(visible);
        createAccountBtn.shouldBe(visible);
        return null;
    }

    @Step("Авторизоваться пользователем с: именем - {0}, паролем - {1}")
    @Nonnull
    public MainPage doLogin(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        submitBtn.click();
        return new MainPage();
    }

    @Step("Перейти к регистрации")
    @Nonnull
    public RegisterPage goToRegistration() {
        createAccountBtn.click();
        return new RegisterPage();
    }

    @Step("Ввести имя {username}")
    @Nonnull
    public LoginPage setUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    @Step("Ввести пароль {password}")
    @Nonnull
    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Нажать на кнопку Войти")
    @Nonnull
    public LoginPage clickLoginBtn() {
        submitBtn.click();
        return this;
    }

    @Step("Проверить ошибку с текстом '{errorText}'")
    @Nonnull
    public LoginPage checkErrorMessage(String errorText) {
        errorMessage.shouldBe(visible).shouldHave(exactText(errorText));
        return this;
    }
}
