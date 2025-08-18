package guru.qa.rococo.tests.web;

import com.codeborne.selenide.Selenide;
import guru.qa.rococo.jupiter.annotation.WebTest;
import guru.qa.rococo.page.MainPage;
import guru.qa.rococo.utils.RandomDataUtils;
import org.junit.jupiter.api.Test;

@WebTest
public class LoginTest {
    public static final String INCORRECT_CREDENTIALS_ERROR = "Неверные учетные данные пользователя";

    @Test
    public void successfulLoginTest() {
        String username = RandomDataUtils.randomUsername();
        String password = RandomDataUtils.randomPassword();
        Selenide.open(MainPage.URL, MainPage.class)
                .checkPageIsLoaded()
                .getHeader().openLoginPage()
                .doLogin(username, password);
    }

    @Test
    public void incorrectCredentialsTest() {
        String username = RandomDataUtils.randomUsername();
        String password = RandomDataUtils.randomPassword();
        Selenide.open(MainPage.URL, MainPage.class)
                .checkPageIsLoaded()
                .getHeader().openLoginPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginBtn()
                .checkErrorMessage(INCORRECT_CREDENTIALS_ERROR);
    }
}
