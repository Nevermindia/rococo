package guru.qa.rococo.tests.web;

import com.codeborne.selenide.Selenide;
import guru.qa.rococo.jupiter.annotation.User;
import guru.qa.rococo.jupiter.annotation.WebTest;
import guru.qa.rococo.model.UserJson;
import guru.qa.rococo.page.RegisterPage;
import guru.qa.rococo.utils.RandomDataUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.Isolated;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@WebTest
public class RegistrationTest {
    public static final String PASSWORDS_SHOULD_BE_EQUAL_ERROR = "Passwords should be equal";
    public static final String USERNAME_LENGTH_ERROR = "Allowed username length should be from 3 to 50 characters";
    public static final String PASSWORD_LENGTH_ERROR = "Allowed password length should be from 3 to 12 characters";
    private final static String USERNAME_ALREADY_EXIST_ERROR = "Username `%s` already exists";

    @Test
    @DisplayName("WEB: Ошибка при попытке регистрации существующим пользователем")
    @User
    void registerExistingUserErrorTest(UserJson createdUser) {
        String username = createdUser.username();
        String password = createdUser.testData().password();
        Selenide.open(RegisterPage.URL, RegisterPage.class)
                .setUserName(username)
                .setPassword(password)
                .setPasswordSubmit(password)
                .submitRegistration()
                .checkErrorMessage(USERNAME_ALREADY_EXIST_ERROR.formatted(username));
    }

    @Test
    @DisplayName("WEB: Ошибка при регистрации, если пароль и подтверждение пароля не совпадают")
    void passwordAndConfirmPasswordAreNotEqualTest() {
        String username = RandomDataUtils.randomUsername();
        String password = RandomDataUtils.randomPassword();
        String submitPassword = RandomDataUtils.randomPassword();
        Selenide.open(RegisterPage.URL, RegisterPage.class)
                .setUserName(username)
                .setPassword(password)
                .setPasswordSubmit(submitPassword)
                .submitRegistration()
                .checkErrorMessage(PASSWORDS_SHOULD_BE_EQUAL_ERROR);
    }

    @ParameterizedTest
    @DisplayName("WEB: Ошибка при регистрации с некорректной длиной имени пользователя")
    @ValueSource(strings = {
            "he",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy"})
    void incorrectLengthNameTest(String username) {
        String password = RandomDataUtils.randomPassword();
        Selenide.open(RegisterPage.URL, RegisterPage.class)
                .setUserName(username)
                .setPassword(password)
                .setPasswordSubmit(password)
                .submitRegistration()
                .checkErrorMessage(USERNAME_LENGTH_ERROR);
    }

    @ParameterizedTest
    @DisplayName("WEB: Ошибка при регистрации с некорректной длиной пароля")
    @ValueSource(strings = {
            "he",
            "X7fKpmO2c7xZ9"})
    void incorrectLengthPasswordTest(String password) {
        String username = RandomDataUtils.randomUsername();
        Selenide.open(RegisterPage.URL, RegisterPage.class)
                .setUserName(username)
                .setPassword(password)
                .setPasswordSubmit(password)
                .submitRegistration()
                .checkErrorMessage(PASSWORD_LENGTH_ERROR);
    }

    @Test
    @DisplayName("WEB: Успешная регистрация нового пользователя")
    void registerNewUserTest() {
        String username = RandomDataUtils.randomUsername();
        String password = RandomDataUtils.randomPassword();
        Selenide.open(RegisterPage.URL, RegisterPage.class)
                .doRegister(username, password, password)
                .doLogin(username, password)
                .checkMainPageIsLoaded();
    }
}
