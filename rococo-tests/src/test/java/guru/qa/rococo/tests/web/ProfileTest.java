package guru.qa.rococo.tests.web;

import com.codeborne.selenide.Selenide;
import guru.qa.rococo.jupiter.annotation.ApiLogin;
import guru.qa.rococo.jupiter.annotation.ScreenShotTest;
import guru.qa.rococo.jupiter.annotation.User;
import guru.qa.rococo.jupiter.annotation.WebTest;
import guru.qa.rococo.page.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static guru.qa.rococo.utils.DefaultData.PROFILE_IMAGE_PATH;
import static guru.qa.rococo.utils.RandomDataUtils.randomName;

@WebTest
public class ProfileTest {
    private static final String PROFILE_MSG = "Профиль обновлен";

    @Test
    @DisplayName("WEB: Изменение имени и фамилии пользователя")
    @ApiLogin(user = @User())
    void updateProfileWithFirstAndLastNamesTest() {
        final String firstName = randomName();
        final String lastName = randomName();

        Selenide.open(MainPage.URL, MainPage.class)
                .getHeader()
                .openProfilePage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .save()
                .checkToastMessage(PROFILE_MSG)
                .refreshPage()
                .getHeader()
                .openProfilePage()
                .checkFirstName(firstName)
                .checkLastName(lastName);
    }


    @ScreenShotTest(expected = "avatar_expected.png")
    @DisplayName("WEB: Загрузка фото профиля")
    @ApiLogin(user = @User)
    void updateProfileWithAnImage(BufferedImage expectedAvatar) throws IOException {

        Selenide.open(MainPage.URL, MainPage.class)
                .getHeader()
                .openProfilePage()
                .uploadPhoto(PROFILE_IMAGE_PATH)
                .save()
                .checkToastMessage(PROFILE_MSG)
                .refreshPage()
                .getHeader()
                .openProfilePage()
                .checkPhoto(expectedAvatar);
    }
}
