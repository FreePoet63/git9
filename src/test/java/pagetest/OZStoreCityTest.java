package pagetest;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import settings.StartSettings;

import static page.OzAllMethods.*;

public class OZStoreCityTest extends StartSettings {
    @Step
    @Test
    @Description("Search for stores by city")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search for Cities")
    public void searchCityStore() {
        searchElementPage("Магазины OZ");
        searchCities();
    }
}
