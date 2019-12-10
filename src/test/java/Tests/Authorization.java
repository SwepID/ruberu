package Tests;
import Pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authorization {
    @Test
    public void Authorization() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.GoToWebsite();
        homePage.GoToMyProfile();
        homePage.CheckCorrectAuthorization();
        driver.quit();
    }
}
