package Tests;

import Pages.CartPage;
import Pages.CatalogPage;
import Pages.HomePage;
import Settings.WebDriverSettings;
import org.testng.annotations.Test;

public class BuyToothBrushTest extends WebDriverSettings {
    @Test
    public void ToothBrushTest() throws InterruptedException {
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
        cartPage.ChangeOrder();
        cartPage.IncreasePrice(2999);
        //driver.quit();
    }
}
