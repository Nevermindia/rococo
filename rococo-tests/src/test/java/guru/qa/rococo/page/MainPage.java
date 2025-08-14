package guru.qa.rococo.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

@ParametersAreNonnullByDefault
public class MainPage extends BasePage<MainPage> {

    //private final Header header = new Header();

    private final ElementsCollection headerElements = $$(".MuiTypography-h5");

//    @Nonnull
//    public Header getHeader() {
//        return header;
//    }

    @Step("Check Main page is opened")
    @Nonnull
    public MainPage checkMainPageIsOpened() {
        headerElements.find(text("Ваши любимые картины и художники всегда рядом")).shouldBe(visible);
        return this;
    }


}
