package Tests;

import Methods.Methods;
import Pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class CityCheck {
    @Test
    public void CityCheck() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        //Methods cityCheck = new Methods();
        //cityCheck.GoToWebsite(driver);
        //cityCheck.GoToMyProfile(driver);
        //cityCheck.CityCheck(driver);
        HomePage homePage = new HomePage(driver);
        homePage.GoToWebsite();
        homePage.ChangeCity("Хвалынск");
        homePage.CheckCity("Хвалынск");
        driver.quit();
    }
}
