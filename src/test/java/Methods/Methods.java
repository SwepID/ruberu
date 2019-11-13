package Methods;

import jdk.jfr.Timespan;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Methods
{
    private ChromeDriver driver;
    //WebElement element = driver.findElementByClassName("_3ZGcN3lbEg");
    @Test
    public void GoToWebsite(ChromeDriver driver)
    {
        this.driver = driver;
        this.driver.manage().window().fullscreen();
        this.driver.get("https://beru.ru");
    }
    public void GoToMyProfile(ChromeDriver driver) throws InterruptedException {
        this.driver = driver;
        WebElement element = driver.findElementByClassName("_3ZGcN3lbEg");
        element.click();
        WebElement login = driver.findElementByXPath("//*[@id=\"passp-field-login\"]");
        login.clear();
        login.sendKeys("testBeru2019");
        WebElement enter = driver.findElementByXPath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]");
        enter.click();

        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passp-field-passwd\"]")));
        WebElement password = driver.findElementByXPath("//*[@id=\"passp-field-passwd\"]");
        password.clear();
        password.sendKeys("05281230nm");
        enter = driver.findElementByXPath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div[1]/form/div[2]/button[1]");
        enter.click();
    }
    public void CheckAuthorization(ChromeDriver driver)
    {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("pFhTbV17qj")));
        String text = driver.findElementByClassName("pFhTbV17qj").getText();
        if (text.equals("Мой профиль"))
        {
            driver.quit();
        }
    }
    public void CityCheck(ChromeDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("_3ZGcN3lbEg")));
        WebElement element = driver.findElementByClassName("_3ZGcN3lbEg");
        element.click();
        WebDriverWait wait2 = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[2]/div/div/ul[2]/ul/li[3]/a")));
        WebElement element2 = driver.findElementByXPath("/html/body/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[2]/div/div/ul[2]/ul/li[3]/a");
        element2.click();
    }

}
