package Tests;

import Pages.HomePage;
import Settings.WebDriverSettings;
import org.testng.annotations.Test;

public class AuthorizationTest extends WebDriverSettings {
    @Test
    public void Authorization() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.GoToWebsite();
        homePage.GoToMyProfile();
        homePage.CheckCorrectAuthorization();
    }
}
