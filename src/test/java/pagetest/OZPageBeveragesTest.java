package pagetest;

import io.qameta.allure.*;
import listener.ListenerOZ;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import settings.StartSettings;

import static methoddefault.MethodsToDefault.*;
import static page.OzAllMethods.*;

public class OZPageBeveragesTest extends StartSettings {
    @Step
    @Test
    @Description("Searching for coffee using filters")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Finding coffee")
    public void itemsCoffee(){
        moveToElement( "Продукты, деликатесы");
        searchElementPage("Кофе");
        elementCollection(2);
        elementFilterCollection(0);
        clickButton("Применить");
        String s = "Кофе молотый";
        withAssertCollection(s);
    }
}
