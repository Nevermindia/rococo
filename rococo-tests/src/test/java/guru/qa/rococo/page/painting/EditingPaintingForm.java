package guru.qa.rococo.page.painting;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;
import guru.qa.rococo.page.component.Select;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@ParametersAreNonnullByDefault
public class EditingPaintingForm extends BasePage<EditingPaintingForm> {

    private final SelenideElement self = $("div.card form");
    private final SelenideElement image = self.$("img");
    private final SelenideElement imageInput = self.$("input[type='file']");
    private final SelenideElement nameInput = self.$("input[name='title']");
    private final SelenideElement authorInput = self.$("select[name='authorId']");
    private final SelenideElement description = self.$("textarea[name='description']");
    private final SelenideElement museumInput = self.$("select[name='museumId']");
    private final SelenideElement closeBtn = self.$(By.xpath("//button[text()='Закрыть']"));
    private final SelenideElement saveBtn = self.$("button[type='submit']");

    private final Select museumSelect = new Select(museumInput);
    private final Select authorSelect = new Select(authorInput);


    @Step("Ввести название картины: '{0}'")
    @Nonnull
    public EditingPaintingForm setName(String name) {
        nameInput.clear();
        nameInput.setValue(name);
        return this;
    }

    @Step("Загрузить картину: '{0}'")
    @Nonnull
    public EditingPaintingForm uploadImage(String path) {
        imageInput.should(visible).uploadFromClasspath(path);
        Selenide.sleep(2000);
        return this;
    }

    @Step("Ввести описание картины: '{0}'")
    @Nonnull
    public EditingPaintingForm setDescription(String text) {
        description.clear();
        description.setValue(text);
        return this;
    }

    @Step("Выбрать музей: '{0}'")
    @Nonnull
    public EditingPaintingForm selectMuseum(String museum) {
        museumSelect.selectItem(museum);
        return this;
    }

    @Step("Выбрать первого художника")
    @Nonnull
    public EditingPaintingForm selectFirstArtist() {
        authorSelect.selectFirstItem();
        return this;
    }

    @Step("Нажать кнопку 'Сохранить'")
    @Nonnull
    public PaintingPage submitForm() {
        saveBtn.scrollIntoView(false);
        saveBtn.click();
        return new PaintingPage();
    }
}
