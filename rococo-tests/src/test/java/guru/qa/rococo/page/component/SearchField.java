package guru.qa.rococo.page.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchField {
    private final SelenideElement self = $("main div.justify-center");
    private final SelenideElement searchInput = self.$("input[type='search']");
    private final SelenideElement searchBtn = self.$("button");
}
