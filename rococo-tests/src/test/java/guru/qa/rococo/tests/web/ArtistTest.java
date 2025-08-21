package guru.qa.rococo.tests.web;

import com.codeborne.selenide.Selenide;
import guru.qa.rococo.jupiter.annotation.*;
import guru.qa.rococo.model.ArtistJson;
import guru.qa.rococo.model.MuseumJson;
import guru.qa.rococo.model.PaintingJson;
import guru.qa.rococo.page.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@WebTest
public class ArtistTest {

    @Test
    @DisplayName("WEB: User should be able to edit Artist name and bio")
    @ApiLogin(user = @User())
    @Museum
    @Artist
    @Painting
    void shouldBeAbleToEditArtistNameAndBio(MuseumJson museum, ArtistJson artist, PaintingJson painting) {

        Selenide.open(MainPage.URL, MainPage.class)
                .checkMainPageIsLoaded();
    }
}
