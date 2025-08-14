package guru.qa.rococo.tests.web;

import com.codeborne.selenide.Selenide;
import guru.qa.rococo.page.RegisterPage;
import guru.qa.rococo.utils.RandomDataUtils;
import org.junit.jupiter.api.Test;

public class RegistrationTest {

    @Test
    public void shouldRegisterNewUser() {
        String username = RandomDataUtils.randomUsername();
        String password = RandomDataUtils.randomPassword();
        Selenide.open(RegisterPage.URL, RegisterPage.class)
                .doRegister(username, password, password)
                .doLogin(username, password)
                .checkMainPageIsOpened();
    }
}
