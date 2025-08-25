package guru.qa.rococo.page.artist;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.model.ArtistJson;
import guru.qa.rococo.page.BasePage;
import guru.qa.rococo.page.component.Picture;
import guru.qa.rococo.page.painting.AddNewPaintingPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@ParametersAreNonnullByDefault
public class ArtistPage extends BasePage<ArtistPage> {

    public static final String URL = CFG.frontUrl() + "artist/";

    public static String url(String id) {
        return URL + id;
    }

    private final SelenideElement artistName = $("article header");
    private final SelenideElement artistPhoto = $("figure img");
    private final SelenideElement bio = $("article p");
    private final SelenideElement editBtn = $("button[data-testid='edit-artist']");
    private final SelenideElement addPaintingBtn = $(By.xpath("//button[text()='Добавить картину']"));
    private final ElementsCollection paintings = $$("ul.grid li");

    private final Picture image = new Picture(artistPhoto);

    @Step("Проверить, что страница загрузилась")
    public ArtistPage checkArtistPageLoaded() {
        artistName.should(visible);
        artistPhoto.should(visible);
        editBtn.should(visible);
        return this;
    }

    @Step("Перейти к добавлению картины")
    @Nonnull
    public AddNewPaintingPage addPainting() {
        addPaintingBtn.click();
        return new AddNewPaintingPage();
    }

    @Step("Перейти к редактированию художника")
    @Nonnull
    public EditingArtistForm editArtist() {
        editBtn.click();
        return new EditingArtistForm();
    }

    @Step("Проверить информацию о художнике: {expected}")
    @Nonnull
    public ArtistPage checkArtistInfo(ArtistJson expected) {
        artistName.should(visible).shouldHave(text(expected.getName()));
        bio.should(visible).shouldHave(text(expected.getBiography()));
        return this;
    }

    @Step("Проверить фото художника")
    @Nonnull
    public ArtistPage checkPhoto(BufferedImage expected) throws IOException {
        image.checkPhoto(expected);
        return this;
    }

    @Step("Проверить существование картины")
    @Nonnull
    public ArtistPage checkPaintingExist() {
        paintings.first().$("img").should(attributeMatching("src", "data:image.*"));
        return this;
    }

    @Step("Проверить название картины: {name}")
    @Nonnull
    public ArtistPage checkPaintingName(String name) {
        paintings.first().$("div").should(visible).shouldHave(text(name));
        return this;
    }
}
