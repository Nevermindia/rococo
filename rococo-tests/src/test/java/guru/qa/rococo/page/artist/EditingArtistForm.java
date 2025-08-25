package guru.qa.rococo.page.artist;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import javax.annotation.Nonnull;

import static com.codeborne.selenide.Selenide.$;

public class EditingArtistForm extends BasePage<EditingArtistForm> {

    private final SelenideElement self = $("div.card form");
    private final SelenideElement image = self.$("img");
    private final SelenideElement imageInput = self.$("input[type='file']");
    private final SelenideElement nameInput = self.$("input[name='name']");
    private final SelenideElement bio = self.$("textarea[name='biography']");
    private final SelenideElement closeBtn = self.$(By.xpath("//button[text()='Закрыть']"));
    private final SelenideElement saveBtn = self.$("button[type='submit']");

    @Step("Ввести имя художника: '{0}'")
    @Nonnull
    public EditingArtistForm setName(String name) {
        nameInput.clear();
        nameInput.setValue(name);
        return this;
    }

    @Step("Загрузить фото: '{0}'")
    @Nonnull
    public EditingArtistForm uploadPhoto(String path) {
        imageInput.uploadFromClasspath(path);
        return this;
    }

    @Step("Ввести биографию: '{0}'")
    @Nonnull
    public EditingArtistForm setBio(String text) {
        bio.clear();
        bio.setValue(text);
        return this;
    }

    @Step("Нажать кнопку 'Сохранить'")
    @Nonnull
    public ArtistPage submitForm() {
        saveBtn.click();
        return new ArtistPage();
    }
}
