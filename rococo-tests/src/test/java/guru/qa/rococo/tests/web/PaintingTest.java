package guru.qa.rococo.tests.web;

import com.codeborne.selenide.Selenide;
import guru.qa.rococo.jupiter.annotation.*;
import guru.qa.rococo.model.ArtistJson;
import guru.qa.rococo.model.MuseumJson;
import guru.qa.rococo.model.PaintingJson;
import guru.qa.rococo.page.painting.PaintingsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static guru.qa.rococo.utils.DefaultData.PAINTING_IMAGE_PATH;
import static guru.qa.rococo.utils.DefaultData.PAINTING_IMAGE_PATH_NEW;
import static guru.qa.rococo.utils.RandomDataUtils.*;

@Execution(ExecutionMode.SAME_THREAD)
@WebTest
public class PaintingTest {
    private static final String PAINTING_ADDED_MSG = "Добавлена картина: %s";
    private static final String TITLE_LENGTH_CONSTRAINT_MIN = "Название не может быть короче 3 символов";
    private static final String TITLE_LENGTH_CONSTRAINT_MAX = "Название не может быть длиннее 255 символов";
    private static final String DESCRIPTION_LENGTH_CONSTRAINT_MIN = "Описание не может быть короче 10 символов";
    private static final String DESCRIPTION_LENGTH_CONSTRAINT_MAX = "Описание не может быть длиннее 2000 символов";
    private static final String PAINTING_EDITED_MSG = "Обновлена картина: %s";

    @Test
    @DisplayName("WEB: Добавление картины")
    @Museum
    @Artist
    @ApiLogin(user = @User())
    void addNewPaintingTest(MuseumJson museum, ArtistJson artist) {
        final String paintingName = randomPaintingName();
        final String paintingDescription = randomPaintingDescription();

        Selenide.open(PaintingsPage.URL, PaintingsPage.class)
                .checkPaintingPageIsLoaded()
                .addPainting()
                .setName(paintingName)
                .uploadPainting(PAINTING_IMAGE_PATH)
                .selectAuthor(artist.getName())
                .setDescription(paintingDescription)
                .selectFirstMuseum()
                .submitForm(new PaintingsPage())
                .checkToastMessage(PAINTING_ADDED_MSG.formatted(paintingName))
                .refreshPage()
                .checkPaintingExists(paintingName);
    }

    @Test
    @DisplayName("WEB: Редактирование заголовка и описания картины")
    @ApiLogin(user = @User())
    @Museum
    @Artist
    @Painting
    void editPaintingTitleAndDescTest(MuseumJson museum, ArtistJson artist, PaintingJson painting) {
        final String newName = painting.getTitle() + " edited";
        final String newDescription = painting.getDescription() + " edited";

        Selenide.open(PaintingsPage.URL, PaintingsPage.class)
                .searchPainting(painting.getTitle())
                .openPainting(painting.getTitle())
                .editPainting()
                .setName(newName)
                .setDescription(newDescription)
                .selectFirstArtist()
                .submitForm()
                .checkToastMessage(PAINTING_EDITED_MSG.formatted(newName))
                .refreshPage()
                .checkPaintingInfo(
                        new PaintingJson(
                                painting.getId(),
                                painting.getTitle(),
                                painting.getDescription(),
                                painting.getContent(),
                                museum,
                                artist
                        )
                );
    }

    @Test
    @DisplayName("WEB: Ошибка при добавлении картины: слишком короткое название")
    @ApiLogin(user = @User())
    @Museum
    @Artist
    void tooShortPaintingNameTest(MuseumJson museum, ArtistJson artist) {
        String name = randomString(2);

        Selenide.open(PaintingsPage.URL, PaintingsPage.class)
                .addPainting()
                .setName(name)
                .uploadPainting(PAINTING_IMAGE_PATH)
                .selectFirstAuthor()
                .setDescription(randomPaintingDescription())
                .selectFirstMuseum()
                .submitForm(new PaintingsPage())
                .checkTextFieldErrorMessage(TITLE_LENGTH_CONSTRAINT_MIN);
    }

    @Test
    @DisplayName("WEB: Ошибка при добавлении картины: слишком короткое название")
    @ApiLogin(user = @User())
    @Museum
    @Artist
    void tooLongPaintingNameTest(MuseumJson museum, ArtistJson artist) {
        String name = randomString(256);

        Selenide.open(PaintingsPage.URL, PaintingsPage.class)
                .addPainting()
                .setName(name)
                .uploadPainting(PAINTING_IMAGE_PATH)
                .selectAuthor(artist.getName())
                .setDescription(randomPaintingDescription())
                .selectMuseum(museum.getTitle())
                .submitForm(new PaintingsPage())
                .checkTextFieldErrorMessage(TITLE_LENGTH_CONSTRAINT_MAX);
    }

    @Test
    @DisplayName("WEB: Ошибка при добавлении картины: слишком короткое описание")
    @ApiLogin(user = @User())
    @Museum
    @Artist
    void tooShortPaintingDescriptionTest(MuseumJson museum, ArtistJson artist) {
        String description = randomString(9);

        Selenide.open(PaintingsPage.URL, PaintingsPage.class)
                .addPainting()
                .setName(randomPaintingName())
                .uploadPainting(PAINTING_IMAGE_PATH)
                .selectFirstAuthor()
                .setDescription(description)
                .selectFirstMuseum()
                .submitForm(new PaintingsPage())
                .checkTextFieldErrorMessage(DESCRIPTION_LENGTH_CONSTRAINT_MIN);
    }

    @Test
    @DisplayName("WEB: Ошибка при добавлении картины: слишком длинное описание")
    @ApiLogin(user = @User())
    @Museum
    @Artist
    void tooLongPaintingDescriptionTest(MuseumJson museum, ArtistJson artist) {
        String description = randomString(2001);

        Selenide.open(PaintingsPage.URL, PaintingsPage.class)
                .addPainting()
                .setName(randomPaintingName())
                .uploadPainting(PAINTING_IMAGE_PATH)
                .selectFirstAuthor()
                .setDescription(description)
                .selectFirstMuseum()
                .submitForm(new PaintingsPage())
                .checkTextFieldErrorMessage(DESCRIPTION_LENGTH_CONSTRAINT_MAX);
    }

    @Test
    @DisplayName("WEB: Редактирование музея")
    @ApiLogin(user = @User())
    @Museum
    @Artist
    @Painting
    void editPaintingMuseumTest(MuseumJson museum, ArtistJson artist, PaintingJson painting) {

        Selenide.open(PaintingsPage.URL, PaintingsPage.class)
                .searchPainting(painting.getTitle())
                .openPainting(painting.getTitle())
                .editPainting()
                .selectMuseum(museum.getTitle())
                .submitForm()
                .refreshPage()
                .checkPaintingInfo(
                        new PaintingJson(
                                painting.getId(),
                                painting.getTitle(),
                                painting.getDescription(),
                                painting.getContent(),
                                museum,
                                artist
                        )
                );
    }

    @ScreenShotTest(value = "screenshots/painting_expected.png")
    @DisplayName("WEB: Редактирование картины")
    @ApiLogin(user = @User())
    @Museum
    @Artist
    @Painting
    void editPaintingPicture(BufferedImage expectedAvatar, PaintingJson painting) throws IOException {
        String path = "img/painting/nighthawks.jpg";

        Selenide.open(PaintingsPage.URL, PaintingsPage.class)
                .searchPainting(painting.getTitle())
                .openPainting(painting.getTitle())
                .editPainting()
                .selectFirstArtist()
                .uploadImage(PAINTING_IMAGE_PATH_NEW)
                .submitForm()
                .checkToastMessage(String.format(PAINTING_EDITED_MSG, painting.getTitle()))
                .refreshPage()
                .checkPhoto(expectedAvatar);
    }
}
