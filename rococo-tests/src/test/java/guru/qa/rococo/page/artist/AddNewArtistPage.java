package guru.qa.rococo.page.artist;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AddNewArtistPage extends BasePage<AddNewArtistPage> {
    private final SelenideElement self = $("form.modal-form");
    private final SelenideElement title = self.$("header.text-2xl");
    private final SelenideElement nameInput = self.$("input[name='name']");
    private final SelenideElement photoInput = self.$("input[name='photo']");
    private final SelenideElement biographyInput = self.$("textarea[name='biography']");
    private final SelenideElement closeBtn = self.$("button.variant-ringed");
    private final SelenideElement submitBtn = self.$("button.variant-filled-primary");

    @Step("Ввести имя художника")
    public AddNewArtistPage setArtistName(String name) {
        nameInput.shouldBe(enabled).setValue(name);
        return this;
    }

    @Step("Загрузить фото художника")
    public AddNewArtistPage uploadArtistPhoto(String path) {
        photoInput.uploadFromClasspath(path);
        return this;
    }

    @Step("Ввести биографию художника")
    public AddNewArtistPage setArtistBio(String bio) {
        biographyInput.shouldBe(enabled).setValue(bio);
        return this;
    }

    @Step("Нажать кнопку 'Добавить'")
    public AddNewArtistPage clickSubmitBtn() {
        submitBtn.shouldBe(enabled).click();
        return this;
    }

    @Step("Добавить художника")
    public ArtistsPage addNewArtist(String name, String photoPath, String bio) {
        setArtistName(name);
        uploadArtistPhoto(photoPath);
        setArtistBio(bio);
        clickSubmitBtn();
        return new ArtistsPage();
    }
}
