package page;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import selectors.AtlasWEbPage;
import selectors.CollectionPage;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static settings.StartSettings.onPage;

public class OzAllMethods {
    @Step
    public static void searchElementPage(String strg) {
        onPage(AtlasWEbPage.class).linkText(strg).click();
    }

    @Step
    public static void clickButton(String text) {
        onPage(AtlasWEbPage.class).button(text).click();
    }

    @Step
    public static void elementCollection(int i) {
        onPage(CollectionPage.class).itemTypeFilter().get(i).click();
    }

    @Step
    public static void elementFilterCollection(int i) {
        onPage(CollectionPage.class).viewItems().get(i).click();
    }

    @Step
    public static void searchCities() {
        WebElement ele = onPage(AtlasWEbPage.class).citiesText();
        $(ele).shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        $$(onPage(CollectionPage.class).sitiesList()).shouldHave(exactTexts("Минск", "Брест", "Витебск",
                "Гомель", "Гродно", "Могилев", "Бобруйск", "Пинск", "Полоцк", "Орша", "Молодечно",
                "Барановичи", "Солигорск", "Борисов", "Лида", "", "", "", "", "", "", "", "", "", "", "","" , "", "", ""));
    }
}
