package guru.qa.rococo.page.painting;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;
import guru.qa.rococo.page.artist.ArtistPage;
import guru.qa.rococo.page.component.Select;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;

import static com.codeborne.selenide.Selenide.$;

public class AddNewPaintingPage extends BasePage<AddNewPaintingPage> {
    private final SelenideElement self = $("form.modal-form");
    private final SelenideElement nameInput = self.$("input[name='title']");
    private final SelenideElement imageInput = self.$("input[name='content']");
    private final SelenideElement authorInput = self.$("select[name='authorId']");
    private final SelenideElement description = self.$("textarea[name='description']");
    private final SelenideElement museumInput = self.$("select[name='museumId']");
    private final SelenideElement closeBtn = self.$("button.variant-ringed");
    private final SelenideElement submitBtn = self.$("button.variant-filled-primary");

    private final Select authorSelect = new Select(authorInput);
    private final Select museumSelect = new Select(museumInput);

    @Step("Ввести имя картины: '{0}'")
    @Nonnull
    public AddNewPaintingPage setName(String name) {
        nameInput.clear();
        nameInput.setValue(name);
        return this;
    }

    @Step("Загрузить картинку: '{0}'")
    @Nonnull
    public AddNewPaintingPage uploadPainting(String path) {
        imageInput.uploadFromClasspath(path);
        return this;
    }

    @Step("Выбрать автора: '{0}'")
    @Nonnull
    public AddNewPaintingPage selectAuthor(String author) {
        authorSelect.selectItem(author);
        return this;
    }

    @Step("Ввести описание картины: '{0}'")
    @Nonnull
    public AddNewPaintingPage setDescription(String text) {
        description.clear();
        description.setValue(text);
        return this;
    }

    @Step("Выбрать музей: '{museumName}'")
    @Nonnull
    public AddNewPaintingPage selectMuseum(String museumName) {
        museumSelect.selectItem(museumName);
        return this;
    }

    @Step("Нажать кнопку 'Добавить'")
    @Nonnull
    public <T extends BasePage<?>> T submitForm(T page) {
        submitBtn.click();
        return page;
    }
}
