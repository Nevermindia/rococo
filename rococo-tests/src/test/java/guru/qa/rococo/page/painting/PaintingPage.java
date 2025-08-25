package guru.qa.rococo.page.painting;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.model.PaintingJson;
import guru.qa.rococo.page.BasePage;
import guru.qa.rococo.page.component.Picture;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaintingPage extends BasePage<PaintingPage> {
    public static final String URL = CFG.frontUrl() + "painting/";

    public static String url(String id) {
        return URL + id;
    }

    private final SelenideElement img = $("article img");
    private final SelenideElement name = $("article header");
    private final SelenideElement museum = $("#museum");
    private final SelenideElement editBtn = $("article button");
    private final SelenideElement description = $(".grid .m-4");

    private final Picture image = new Picture(img);

    public PaintingPage checkPaintingPageIsLoaded() {
        name.should(visible);
        editBtn.should(visible);
        return this;
    }

    @Step("Перейти к редактирования картины")
    @Nonnull
    public EditingPaintingForm editPainting() {
        Selenide.sleep(2000);
        if (!editBtn.isDisplayed()) {
            Selenide.refresh();
        }
        editBtn.click();
        return new EditingPaintingForm();
    }

    @Step("Проверить картину")
    @Nonnull
    public PaintingPage checkPhoto(BufferedImage expected) throws IOException {
        image.checkPhoto(expected);
        return this;
    }

    @Step("Проверить название и описание картины")
    public void checkPaintingInfo(PaintingJson expected) {
        name.should(visible).shouldHave(text(expected.getTitle()));
        description.should(visible).shouldHave(text(expected.getDescription()));
    }
}
