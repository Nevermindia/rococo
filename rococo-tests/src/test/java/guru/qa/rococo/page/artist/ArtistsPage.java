package guru.qa.rococo.page.artist;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;
import guru.qa.rococo.page.component.HeaderPage;
import guru.qa.rococo.page.component.SearchField;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ArtistsPage extends BasePage<ArtistsPage> {
    public static final String URL = CFG.frontUrl() + "artist";
    protected final HeaderPage header = new HeaderPage();
    protected final SearchField searchField = new SearchField();
    private final SelenideElement mainTitle = $("h2.text-3xl");
    private final SelenideElement addArtistBtn = $("main button.btn");
    private final ElementsCollection artists = $$("ul.grid li");

    @Nonnull
    public HeaderPage getHeader() {
        return header;
    }

    @Nonnull
    public SearchField getSearchField() {
        return searchField;
    }


    @Step("Проверить, что страница загрузилась")
    public ArtistsPage checkArtistPageIsLoaded() {
        mainTitle.shouldBe(visible);
        addArtistBtn.shouldBe(visible, enabled);
        return this;
    }

    @Step("Нажать кнопку 'Добавить художника'")
    public AddNewArtistPage clickAddArtistBtn() {
        addArtistBtn.shouldBe(enabled).click();
        return new AddNewArtistPage();
    }

    @Step("Проверить, что художник {name} есть в результатах поиска")
    public ArtistsPage checkArtistExists(String name) {
        getSearchField().search(name);
        artists.find(text(name)).shouldBe(visible);
        return this;
    }
}
