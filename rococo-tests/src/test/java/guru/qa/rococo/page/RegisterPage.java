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
    private final SelenideElement signInBtn = $(".form__link");
    private final SelenideElement errorMessage = $(".form__error");

    @Step("Set username: '{0}'")
    @Nonnull
    public RegisterPage setUserName(String username) {
        usernameInput.setValue(username);
        return this;
    }

    @Step("Set password: '{0}'")
    @Nonnull
    public RegisterPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Submit password: '{0}'")
    @Nonnull
    public RegisterPage setPasswordSubmit(String password) {
        submitPasswordInput.setValue(password);
        return this;
    }

    @Step("Click sign up button")
    @Nonnull
    public RegisterPage submitRegistration() {
        signUpBtn.click();
        return this;
    }

    @Step("Click Sign in button")
    @Nonnull
    public RegisterPage clickSignInBtn() {
        signInBtn.click();
        return this;
    }

    @Step("Register with username - '{0}', password - '{1}'")
    @Nonnull
    public LoginPage doRegister(String username, String password, String submitPassword) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        submitPasswordInput.setValue(submitPassword);
        signUpBtn.click();
        signInBtn.click();
        return new LoginPage();
    }

    @Step("Check error message with text '{errorText}'")
    @Nonnull
    public RegisterPage checkErrorMessage(String errorText) {
        errorMessage.shouldBe(visible).shouldHave(exactText(errorText));
        return this;
    }
}
