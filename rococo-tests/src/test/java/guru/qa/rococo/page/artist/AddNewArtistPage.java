package guru.qa.rococo.page.artist;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.page.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class AddNewArtistPage extends BasePage<AddNewArtistPage> {
    private final SelenideElement self = $("form.modal-form");
    private final SelenideElement title = self.$("header.text-2xl");
    private final SelenideElement nameInput = self.$("input[name='name']");
    private final SelenideElement photoInput = self.$("input[name='photo']");
    private final SelenideElement biographyInput = self.$("textarea[name='biography']");
    private final SelenideElement closeBtn = self.$("button.variant-ringed");
    private final SelenideElement submitBtn = self.$("button.variant-filled-primary");
}
