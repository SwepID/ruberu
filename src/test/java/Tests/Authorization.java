package Tests;

import Methods.Methods;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authorization {
    @Test
    public void Authorization() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        Methods authorization = new Methods();
        authorization.GoToWebsite(driver);
        authorization.GoToMyProfile(driver);
        authorization.CheckAuthorization(driver);
    }
}
