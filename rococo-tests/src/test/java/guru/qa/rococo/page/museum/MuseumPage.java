package guru.qa.rococo.page.museum;

import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.model.MuseumJson;
import guru.qa.rococo.page.BasePage;
import guru.qa.rococo.page.component.Picture;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@ParametersAreNonnullByDefault
public class MuseumPage extends BasePage<MuseumPage> {

    public static final String URL = CFG.frontUrl() + "museum/";

    public static String url(String id) {
        return URL + id;
    }

    private final SelenideElement img = $("article img");
    private final SelenideElement name = $("article header");
    private final SelenideElement location = $("article div.text-center");
    private final SelenideElement editBtn = $("article button");

    private final Picture image = new Picture(img);

    @Step("Проверить, что страница загрузилась")
    public MuseumPage checkMuseumPageIsLoaded() {
        img.should(visible);
        name.should(visible);
        editBtn.should(visible);
        return this;
    }

    @Step("Перейти к редактированию музея")
    @Nonnull
    public EditingMuseumForm editMuseum() {
        editBtn.click();
        return new EditingMuseumForm();
    }


    @Step("Проверить информацию о музее")
    @Nonnull
    public MuseumPage checkMuseumInfo(MuseumJson expected) {
        name.shouldBe(visible).shouldHave(text(expected.getTitle()));
        location.shouldBe(visible).shouldHave(text(expected.getGeo().getCity()));

        return this;
    }

    @Step("Проверить фото музея")
    @Nonnull
    public MuseumPage checkPhoto(BufferedImage expected) throws IOException {
        image.checkPhoto(expected);
        return this;
    }
}
