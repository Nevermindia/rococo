package guru.qa.rococo.tests.web;

import com.codeborne.selenide.Selenide;
import guru.qa.rococo.jupiter.annotation.*;
import guru.qa.rococo.model.ArtistJson;
import guru.qa.rococo.model.MuseumJson;
import guru.qa.rococo.page.artist.ArtistPage;
import guru.qa.rococo.page.artist.ArtistsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static guru.qa.rococo.utils.DefaultData.*;
import static guru.qa.rococo.utils.RandomDataUtils.*;

@WebTest
public class ArtistTest {
    private static final String ARTIST_ADDED_MSG = "Добавлен художник: %s";
    private static final String PAINTING_ADDED_MSG = "Добавлена картина: %s";
    private static final String NAME_LENGTH_CONSTRAINT_MIN = "Имя не может быть короче 3 символов";
    private static final String NAME_LENGTH_CONSTRAINT_MAX = "Имя не может быть длиннее 255 символов";
    private static final String BIOGRAPHY_LENGTH_CONSTRAINT_MIN = "Биография не может быть короче 10 символов";
    private static final String BIOGRAPHY_LENGTH_CONSTRAINT_MAX = "Биография не может быть длиннее 2000 символов";
    private static final String ARTIST_EDITED_MSG = "Обновлен художник: %s";


    @Test
    @DisplayName("WEB: Добавление художника")
    @ApiLogin(user = @User())
    void addNewArtistTest() {
        String name = randomArtistName();
        Selenide.open(ArtistsPage.URL, ArtistsPage.class)
                .checkArtistPageIsLoaded()
                .clickAddArtistBtn()
                .addNewArtist(name, ARTIST_IMAGE_PATH, ARTIST_BIO)
                .checkToastMessage(ARTIST_ADDED_MSG.formatted(name))
                .checkArtistExists(name);
    }

    @Test
    @DisplayName("WEB: Ошибка добавления художника: слишком короткое имя")
    @ApiLogin(user = @User())
    void tooShortArtistNameTest() {
        String name = randomString(2);
        Selenide.open(ArtistsPage.URL, ArtistsPage.class)
                .checkArtistPageIsLoaded()
                .clickAddArtistBtn()
                .addNewArtist(name, ARTIST_IMAGE_PATH, ARTIST_BIO)
                .checkTextFieldErrorMessage(NAME_LENGTH_CONSTRAINT_MIN);
    }

    @Test
    @DisplayName("WEB: Ошибка добавления художника: слишком длинное имя")
    @ApiLogin(user = @User())
    void tooLongArtistNameTest() {
        String name = randomString(256);
        Selenide.open(ArtistsPage.URL, ArtistsPage.class)
                .checkArtistPageIsLoaded()
                .clickAddArtistBtn()
                .addNewArtist(name, ARTIST_IMAGE_PATH, ARTIST_BIO)
                .checkTextFieldErrorMessage(NAME_LENGTH_CONSTRAINT_MAX);
    }

    @Test
    @DisplayName("WEB: Ошибка добавления художника: слишком короткая биография")
    @ApiLogin(user = @User())
    void tooShortArtistBioTest() {
        String name = randomArtistName();
        String bio = randomString(2);
        Selenide.open(ArtistsPage.URL, ArtistsPage.class)
                .checkArtistPageIsLoaded()
                .clickAddArtistBtn()
                .addNewArtist(name, ARTIST_IMAGE_PATH, bio)
                .checkTextFieldErrorMessage(BIOGRAPHY_LENGTH_CONSTRAINT_MIN);
    }

    @Test
    @DisplayName("WEB: Ошибка добавления художника: слишком длинная биография")
    @ApiLogin(user = @User())
    void tooLongArtistBioTest() {
        String name = randomArtistName();
        String bio = randomString(2001);
        Selenide.open(ArtistsPage.URL, ArtistsPage.class)
                .checkArtistPageIsLoaded()
                .clickAddArtistBtn()
                .addNewArtist(name, ARTIST_IMAGE_PATH, bio)
                .checkTextFieldErrorMessage(BIOGRAPHY_LENGTH_CONSTRAINT_MAX);
    }

    @Test
    @DisplayName("WEB: Редактирование данных художника")
    @ApiLogin(user = @User())
    @Artist
    void editArtistInfoTest(ArtistJson artist) {
        final String newName = artist.getName() + " edited";
        final String newBio = artist.getBiography() + " edited";
        final String artistId = artist.getId().toString();
        Selenide.open(ArtistPage.url(artistId), ArtistPage.class)
                .editArtist()
                .setName(newName)
                .setBio(newBio)
                .submitForm()
                .checkToastMessage(ARTIST_EDITED_MSG.formatted(newName))
                .refreshPage()
                .checkArtistInfo(new ArtistJson(
                                artist.getId(),
                                newName,
                                newBio,
                                artist.getPhoto()
                        )
                );
    }


    @ScreenShotTest(value = "screenshots/artist_expected.png")
    @DisplayName("WEB: Редактирование фото художника")
    @ApiLogin(user = @User())
    @Artist
    void editArtistPhotoTest(ArtistJson artist, BufferedImage expectedAvatar) throws IOException {
        final String artistId = artist.getId().toString();
        Selenide.open(ArtistPage.url(artistId), ArtistPage.class)
                .checkArtistPageLoaded()
                .editArtist()
                .uploadPhoto(ARTIST_IMAGE_PATH_NEW)
                .submitForm()
                .checkToastMessage(ARTIST_EDITED_MSG.formatted(artist.getName()))
                .refreshPage()
                .checkPhoto(expectedAvatar);
    }

    @Test
    @DisplayName("WEB: Добавление картины")
    @ApiLogin(user = @User())
    @Artist()
    @Museum()
    void addNewPaintingOnArtistPage(ArtistJson artist, MuseumJson museum) {
        final String artistId = artist.getId().toString();
        final String paintingName = randomPaintingName();
        final String paintingDescription = randomPaintingDescription();

        Selenide.open(ArtistPage.url(artistId), ArtistPage.class)
                .addPainting()
                .setName(paintingName)
                .uploadPainting(PAINTING_IMAGE_PATH)
                .setDescription(paintingDescription)
                .selectMuseum(museum.getTitle())
                .submitForm(new ArtistPage())
                .checkToastMessage(PAINTING_ADDED_MSG.formatted(paintingName))
                .refreshPage()
                .checkPaintingExist()
                .checkPaintingName(paintingName);
    }
}
