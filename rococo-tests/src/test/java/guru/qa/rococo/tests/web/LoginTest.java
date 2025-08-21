package guru.qa.rococo.tests.web;

import com.codeborne.selenide.Selenide;
import guru.qa.rococo.jupiter.annotation.User;
import guru.qa.rococo.jupiter.annotation.WebTest;
import guru.qa.rococo.model.UserJson;
import guru.qa.rococo.page.MainPage;
import guru.qa.rococo.utils.RandomDataUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@WebTest
public class LoginTest {
    public static final String INCORRECT_CREDENTIALS_ERROR = "Неверные учетные данные пользователя";
    public static final String SESSION_IS_OVER = "Сессия завершена";

    @DisplayName("WEB: Успешная авторизация")
    @User
    @Test
    public void successfulLoginTest(UserJson user) {
        Selenide.open(MainPage.URL, MainPage.class)
                .checkMainPageIsLoaded()
                .getHeader().openLoginPage()
                .doLogin(user.username(), user.testData().password())
                .checkMainPageIsLoaded()
                .getHeader().checkAvatarIsVisible();
    }

    @DisplayName("WEB: Ошибка при авторизации неверными учетными данными")
    @Test
    public void incorrectCredentialsTest() {
        String username = RandomDataUtils.randomUsername();
        String password = RandomDataUtils.randomPassword();
        Selenide.open(MainPage.URL, MainPage.class)
                .checkMainPageIsLoaded()
                .getHeader().openLoginPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginBtn()
                .checkErrorMessage(INCORRECT_CREDENTIALS_ERROR);
    }

    @DisplayName("WEB: Успешный логаут")
    @User
    @Test
    public void successfulLogoutTest(UserJson user) {
        Selenide.open(MainPage.URL, MainPage.class)
                .checkMainPageIsLoaded()
                .getHeader().openLoginPage()
                .doLogin(user.username(), user.testData().password())
                .checkMainPageIsLoaded()
                .getHeader().openProfilePage()
                .checkProfilePageIsLoaded().clickLogoutBtn()
                .checkToastMessage(SESSION_IS_OVER)
                .getHeader().checkLoginBtnIsVisible();
    }

}
