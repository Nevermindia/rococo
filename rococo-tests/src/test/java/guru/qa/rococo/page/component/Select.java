package guru.qa.rococo.page.component;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@ParametersAreNonnullByDefault
public class Select {
    private final SelenideElement self;

    public Select(SelenideElement self) {
        this.self = self;
    }

    public void selectItem(String item) {
        List<String> allItemsLoaded = new ArrayList<>();
        String lastItemLoaded = "";


        while (!allItemsLoaded.contains(item)) {
            allItemsLoaded.clear();

            Selenide.sleep(2000);

            List<String> list = self.getOptions()
                    .stream()
                    .map(SelenideElement::getText)
                    .toList();

            String lastItem = list.getLast();
            if (lastItemLoaded.equals(lastItem)) {
                break;
            }
            lastItemLoaded = lastItem;
            allItemsLoaded.addAll(list);
            self.selectOption(allItemsLoaded.getLast());
        }

        self.selectOption(item);
    }
}
