package guru.qa.rococo.page.museum;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;
import guru.qa.rococo.page.component.Select;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Selenide.$;

@ParametersAreNonnullByDefault
public class EditingMuseumForm extends BasePage<EditingMuseumForm> {

    private final SelenideElement self = $("div.card form");
    private final SelenideElement image = self.$("img");
    private final SelenideElement imageInput = self.$("input[type='file']");
    private final SelenideElement nameInput = self.$("input[name='title']");
    private final SelenideElement countrySelect = self.$("select[name='countryId']");
    private final SelenideElement cityInput = self.$("input[name='city']");
    private final SelenideElement description = self.$("textarea[name='description']");
    private final SelenideElement closeBtn = self.$(By.xpath("//button[text()='Закрыть']"));
    private final SelenideElement saveBtn = self.$("button[type='submit']");

    private final Select select = new Select(countrySelect);

    @Step("Ввести имя: '{name}'")
    @Nonnull
    public EditingMuseumForm setName(String name) {
        nameInput.clear();
        nameInput.setValue(name);
        return this;
    }

    @Step("Загрузить фото: '{path}'")
    @Nonnull
    public EditingMuseumForm uploadPhoto(String path) {
        imageInput.uploadFromClasspath(path);
        return this;
    }

    @Step("Выбрать страну: '{countryName}'")
    @Nonnull
    public EditingMuseumForm selectCountry(String countryName) {
        select.selectItem(countryName);
        return this;
    }

    @Step("Ввести город: '{cityName}'")
    @Nonnull
    public EditingMuseumForm setCity(String cityName) {
        cityInput.clear();
        cityInput.setValue(cityName);
        return this;
    }

    @Step("Ввести описание: '{text}'")
    @Nonnull
    public EditingMuseumForm setDescription(String text) {
        description.clear();
        description.setValue(text);
        return this;
    }

    @Step("Нажать кнопку 'Добавить'")
    @Nonnull
    public MuseumPage submitForm() {
        saveBtn.click();
        return new MuseumPage();
    }
}
