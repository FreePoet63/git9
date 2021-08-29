package pagetest;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import settings.StartSettings;

import static methoddefault.MethodsToDefault.*;
import static page.OzAllMethods.*;

public class OZPageWomensProductsTest extends StartSettings {
    @Step
    @Test
    @Description("Selecting shampoo from the list of products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search for shampoo")
    public void searchShampooProductTest()  {
        moveToElement( "Косметика, парфюмерия");
        searchElementPage("Шампуни");
        searchElementPage("Kapous");
        searchElementPage("Жидкий");
        searchElementPage("Для всех типов");
        searchElementPage("Восстановление");
        clickButton("Применить");
        withAssertCollection( "Kapous");
    }
}
