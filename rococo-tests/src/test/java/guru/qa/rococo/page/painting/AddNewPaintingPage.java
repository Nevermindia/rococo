package guru.qa.rococo.page.painting;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class AddNewPaintingPage extends BasePage<AddNewPaintingPage> {
    private final SelenideElement self = $("form.modal-form");
    private final SelenideElement nameInput = self.$("input[name='title']");
    private final SelenideElement photoInput = self.$("input[name='content']");
    private final SelenideElement authorSelect = self.$("select[name='authorId']");
    private final SelenideElement descriptionInput = self.$("textarea[name='description']");
    private final SelenideElement museumSelect = self.$("select[name='museumId']");
    private final SelenideElement closeBtn = self.$("button.variant-ringed");
    private final SelenideElement submitBtn = self.$("button.variant-filled-primary");
}
