package guru.qa.rococo.tests.web;

import com.codeborne.selenide.Selenide;
import guru.qa.rococo.data.repository.GeoRepositoryHibernate;
import guru.qa.rococo.jupiter.annotation.*;
import guru.qa.rococo.model.CountryJson;
import guru.qa.rococo.model.GeoJson;
import guru.qa.rococo.model.MuseumJson;
import guru.qa.rococo.page.museum.MuseumPage;
import guru.qa.rococo.page.museum.MuseumsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static guru.qa.rococo.model.Countries.FRANCE;
import static guru.qa.rococo.model.Countries.RUSSIA;
import static guru.qa.rococo.utils.DefaultData.*;
import static guru.qa.rococo.utils.RandomDataUtils.randomMuseumTitle;
import static guru.qa.rococo.utils.RandomDataUtils.randomString;

@WebTest
public class MuseumTest {

    private static final String MUSEUM_ADDED_MSG = "Добавлен музей: %s";
    private static final String TITLE_LENGTH_CONSTRAINT_MIN = "Название не может быть короче 3 символов";
    private static final String TITLE_LENGTH_CONSTRAINT_MAX = "Название не может быть длиннее 255 символов";
    private static final String CITY_LENGTH_CONSTRAINT_MIN = "Город не может быть короче 3 символов";
    private static final String CITY_LENGTH_CONSTRAINT_MAX = "Город не может быть длиннее 255 символов";
    private static final String DESCRIPTION_LENGTH_CONSTRAINT_MIN = "Описание не может быть короче 10 символов";
    private static final String DESCRIPTION_LENGTH_CONSTRAINT_MAX = "Описание не может быть длиннее 2000 символов";
    private static final String MUSEUM_EDITED_MSG = "Обновлен музей: %s";

    @Test
    @DisplayName("WEB: Добавление музея")
    @ApiLogin(user = @User())
    void addNewMuseumTest() {
        final String name = randomMuseumTitle();

        Selenide.open(MuseumsPage.URL, MuseumsPage.class)
                .addMuseum()
                .setName(name)
                .selectCountry("Россия")
                .setCity("Санкт-Петербург")
                .uploadPhoto(MUSEUM_IMAGE_PATH)
                .setDescription(MUSEUM_DESCRIPTION)
                .submitForm()
                .checkToastMessage(MUSEUM_ADDED_MSG.formatted(name))
                .refreshPage()
                .checkMuseumExists(name);
    }

    @Test
    @DisplayName("WEB: Ошибка добавления музея: слишком короткое название музея")
    @ApiLogin(user = @User())
    void tooShortMuseumNameLengthTest() {
        String name = randomString(2);

        Selenide.open(MuseumsPage.URL, MuseumsPage.class)
                .addMuseum()
                .setName(name)
                .selectCountry("Россия")
                .setCity("Санкт-Петербург")
                .uploadPhoto(MUSEUM_IMAGE_PATH)
                .setDescription(MUSEUM_DESCRIPTION)
                .submitForm()
                .checkTextFieldErrorMessage(TITLE_LENGTH_CONSTRAINT_MIN);
    }

    @Test
    @DisplayName("WEB: Ошибка добавления музея: слишком длинное название музея")
    @ApiLogin(user = @User())
    void tooLongMuseumNameLengthTest() {
        String name = randomString(256);

        Selenide.open(MuseumsPage.URL, MuseumsPage.class)
                .addMuseum()
                .setName(name)
                .selectCountry("Россия")
                .setCity("Санкт-Петербург")
                .uploadPhoto(MUSEUM_IMAGE_PATH)
                .setDescription(MUSEUM_DESCRIPTION)
                .submitForm()
                .checkTextFieldErrorMessage(TITLE_LENGTH_CONSTRAINT_MAX);
    }

    @Test
    @DisplayName("WEB: Ошибка добавления музея: слишком короткое название города")
    @ApiLogin(user = @User())
    void tooShortCityNameLengthTest() {
        String name = randomString(2);

        Selenide.open(MuseumsPage.URL, MuseumsPage.class)
                .addMuseum()
                .setName(randomMuseumTitle())
                .selectCountry("Россия")
                .setCity(name)
                .uploadPhoto(MUSEUM_IMAGE_PATH)
                .setDescription(MUSEUM_DESCRIPTION)
                .submitForm()
                .checkTextFieldErrorMessage(CITY_LENGTH_CONSTRAINT_MIN);
    }

    @Test
    @DisplayName("WEB: Ошибка добавления музея: слишком длинное название города")
    @ApiLogin(user = @User())
    void tooLongCityNameLengthTest() {
        String name = randomString(256);

        Selenide.open(MuseumsPage.URL, MuseumsPage.class)
                .addMuseum()
                .setName(randomMuseumTitle())
                .selectCountry(RUSSIA.getName())
                .setCity(name)
                .uploadPhoto(MUSEUM_IMAGE_PATH)
                .setDescription(MUSEUM_DESCRIPTION)
                .submitForm()
                .checkTextFieldErrorMessage(CITY_LENGTH_CONSTRAINT_MAX);
    }

    @Test
    @DisplayName("WEB: Ошибка добавления музея: слишком короткое описание")
    @ApiLogin(user = @User())
    void tooShortDescriptionTest() {
        String name = randomString(9);

        Selenide.open(MuseumsPage.URL, MuseumsPage.class)
                .addMuseum()
                .setName(randomMuseumTitle())
                .selectCountry("Россия")
                .setCity("Омск")
                .uploadPhoto(MUSEUM_IMAGE_PATH)
                .setDescription(name)
                .submitForm()
                .checkTextFieldErrorMessage(DESCRIPTION_LENGTH_CONSTRAINT_MIN);
    }

    @Test
    @DisplayName("WEB: Ошибка добавления музея: слишком длинное описание")
    @ApiLogin(user = @User())
    void tooLongDescriptionTest() {
        String name = randomString(2001);

        Selenide.open(MuseumsPage.URL, MuseumsPage.class)
                .addMuseum()
                .setName(randomMuseumTitle())
                .selectCountry("Россия")
                .setCity("Омск")
                .uploadPhoto(MUSEUM_IMAGE_PATH)
                .setDescription(name)
                .submitForm()
                .checkTextFieldErrorMessage(DESCRIPTION_LENGTH_CONSTRAINT_MAX);
    }

    @Test
    @DisplayName("WEB: Редактирование названия и описания музея")
    @ApiLogin(user = @User())
    @Museum
    void editMuseumTitleAndDescTest(MuseumJson museum) {
        String museumId = museum.getId().toString();
        String newName = museum.getTitle() + " edited";
        String newDescription = museum.getDescription() + " edited";

        Selenide.open(MuseumPage.url(museumId), MuseumPage.class)
                .editMuseum()
                .setName(newName)
                .setDescription(newDescription)
                .submitForm()
                .checkToastMessage(MUSEUM_EDITED_MSG.formatted(newName))
                .refreshPage()
                .checkMuseumInfo(
                        new MuseumJson(
                                museum.getId(),
                                newName,
                                newDescription,
                                museum.getPhoto(),
                                museum.getGeo()
                        )
                );
    }

    @Test
    @DisplayName("WEB: Редактирование страны и города расположения музея")
    @ApiLogin(user = @User())
    @Museum
    void editMuseumGeoLocationTest(MuseumJson museum) throws UnsupportedEncodingException {
        String museumId = museum.getId().toString();
        String newCity = "Париж";
        String newCountry = FRANCE.getName();
        GeoRepositoryHibernate geoRepositoryHibernate = new GeoRepositoryHibernate();
        CountryJson newCountryJson = CountryJson.fromEntity(geoRepositoryHibernate.getCountryByName(newCountry));

        Selenide.open(MuseumPage.url(museumId), MuseumPage.class)
                .editMuseum()
                .setCity(newCity)
                .selectCountry(FRANCE.getName())
                .submitForm()
                .checkToastMessage(MUSEUM_EDITED_MSG.formatted(museum.getTitle()))
                .refreshPage()
                .checkMuseumInfo(
                        new MuseumJson(
                                museum.getId(),
                                museum.getTitle(),
                                museum.getDescription(),
                                museum.getPhoto(),
                                new GeoJson(
                                        newCity,
                                        newCountryJson
                                )
                        )
                );
    }

    @ScreenShotTest(value = "museum_expected.png")
    @DisplayName("WEB: Редактирование изображения музея")
    @ApiLogin(user = @User())
    @Museum
    void editMuseumPictureTest(BufferedImage image, MuseumJson museum) throws IOException {
        final String museumId = museum.getId().toString();

        Selenide.open(MuseumPage.url(museumId), MuseumPage.class)
                .editMuseum()
                .uploadPhoto(MUSEUM_IMAGE_PATH_NEW)
                .submitForm()
                .checkToastMessage(MUSEUM_EDITED_MSG.formatted(museum.getTitle()))
                .refreshPage()
                .checkPhoto(image);
    }
}
