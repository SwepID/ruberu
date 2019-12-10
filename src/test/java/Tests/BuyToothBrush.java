package Tests;
import Pages.CartPage;
import Pages.CatalogPage;
import Pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
public class BuyToothBrush {
    @Test
    public void ToothBrushTest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.GoToWebsite();
        homePage.GoToMyProfile();
        homePage.CatalogClick();
        catalogPage.SectionClick();
        catalogPage.ElectricToothbrushesClick();
        catalogPage.ChoseToothbrushPrice("999", "1999");
        catalogPage.PutToothBrush();
        cartPage.CheckPrice();
        //driver.quit();
    }
}
