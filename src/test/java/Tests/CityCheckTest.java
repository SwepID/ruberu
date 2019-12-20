package Tests;

import Pages.HomePage;
import Settings.WebDriverSettings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class CityCheckTest extends WebDriverSettings {
    @Test(dataProvider = "cities", dataProviderClass = ChangeCityDataProvider.class)
    public void CityCheck(String defaultCityName, String cityName) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.GoToWebsite();
        homePage.CheckCity(defaultCityName);
        homePage.ChangeCity(cityName);
        homePage.CheckCity(cityName);
        driver.quit();
    }

    public static class ChangeCityDataProvider {
        @DataProvider(name = "cities")
        public static Object[][] dataProviderMethod() {
            return new Object[][]{{"Саратов", "Хвалынск"}, {"Саратов", "Москва"}};
        }
    }
}
