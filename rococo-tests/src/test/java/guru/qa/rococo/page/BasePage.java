package guru.qa.rococo.page;

import guru.qa.rococo.config.Config;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class BasePage<T extends BasePage<?>>{
    protected static final Config CFG = Config.getInstance();

//    private final SelenideElement alert = $(".MuiSnackbar-root");
//
//    @Step("Check alert message with text '{errorText}'")
//    @SuppressWarnings("unchecked")
//    @Nonnull
//    public T checkAlertMessage(String expectedText) {
//        alert.should(Condition.visible).should(Condition.text(expectedText));
//        return (T) this;
//    }
}
