package guru.qa.rococo.page.component;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$;

public class SearchField {
    private final SelenideElement self = $("main div.justify-center");
    private final SelenideElement searchInput = self.$("input[type='search']");
    private final SelenideElement searchBtn = self.$("button");

    @Nonnull
    @Step("Искать значение: '{query}'")
    public SearchField search(String query) {
        clearIfNotEmpty();
        searchInput.setValue(query).pressEnter();
        return this;
    }

    @Nonnull
    @Step("Очистить поле поиска")
    public SearchField clearIfNotEmpty() {
        if (self.is(not(empty))) {
            searchInput.click();
            searchInput.clear();
            self.should(empty);
        }
        return this;
    }
}
