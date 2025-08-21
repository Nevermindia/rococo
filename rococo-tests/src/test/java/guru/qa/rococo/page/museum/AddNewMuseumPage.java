package guru.qa.rococo.page.museum;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class AddNewMuseumPage extends BasePage<AddNewMuseumPage> {
    private final SelenideElement self = $("form.modal-form");
    private final SelenideElement nameInput = self.$("input[name='title']");
    private final SelenideElement selectCountry = self.$("select[name='countryId']");
    private final SelenideElement cityInput = self.$("input[name='city']");
    private final SelenideElement photoInput = self.$("input[name='photo']");
    private final SelenideElement descriptionInput = self.$("textarea[name='description']");
    private final SelenideElement closeBtn = self.$("button.variant-ringed");
    private final SelenideElement submitBtn = self.$("button.variant-filled-primary");
}
