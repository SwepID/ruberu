package Tests;

import Pages.CartPage;
import Pages.CatalogPage;
import Pages.HomePage;
import Settings.WebDriverSettings;
import org.testng.annotations.Test;

public class BuyToothBrushTest extends WebDriverSettings {
    int minPrice = 999;
    int maxPrice = 1999;
    int increasedPrice = 2999;
    @Test
    public void ToothBrushTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.GoToWebsite();
        //homePage.GoToMyProfile();
        homePage.CatalogClick();
        catalogPage.SectionClick();
        catalogPage.ElectricToothbrushesClick();
        catalogPage.ChoseToothbrushPrice(Integer.toString(minPrice), Integer.toString(maxPrice));
        catalogPage.CheckCorrectPrice(minPrice, maxPrice);
        catalogPage.PutToothBrush();
        catalogPage.GoToCartPage();
        cartPage.CheckFreeShipment();
        cartPage.GoToOffer();
        cartPage.CheckPrice();
        cartPage.ChangeOrder();
        cartPage.IncreasePrice(increasedPrice);
        cartPage.CheckPrice();
    }
}
