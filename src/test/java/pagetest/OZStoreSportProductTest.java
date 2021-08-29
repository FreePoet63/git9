package pagetest;

import io.qameta.allure.*;
import listener.ListenerOZ;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import settings.StartSettings;

import static methoddefault.MethodsToDefault.*;
import static page.OzAllMethods.*;

public class OZStoreSportProductTest extends StartSettings {
    @Step
    @Test
    @Description("Choosing balls in the OZ.BY store")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Finding dalls")
    public void itemsSport() {
        moveToElement( "Туризм, отдых, спорт");
        searchElementPage("Мячи");
        searchElementPage("Футбольный");
        searchElementPage("Склеивание");
        clickButton("Применить");
        withAssertCollection("Мяч футбольный");
    }
}
