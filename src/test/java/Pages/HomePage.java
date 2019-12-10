package Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.List;

public class HomePage {
    ChromeDriver driver;
    AuthorizationPage authorizationPage;
    private String login = "testBeru2019";
    private String password = "05281230nm";
    private By cityResult = By.cssSelector("span[data-auto='region-form-opener']._2XJ6yiRp5w");
    String cityName;
    WebElement element;
    Actions action;
    private WebElement webElement;
    private By cityButton = By.className("_2LxmV3b641");
    private By cityChange = By.cssSelector("div._1U2ErCeoqP  input[data-tid=\"37e0ab2d\"]");
    private By popUpCity = By.cssSelector("li#react-autowhatever-region--item-0 div._229JDbp_Z8");
    private By cityConfirmButton = By.cssSelector("button[data-tid='71e1c78d']._4qhIn2-ESi.Pjv3h3YbYr.THqSbzx07u");
    private By citeCatalog = By.className("_3RM4_n5whA");
    //private  By citeCatalog = By.cssSelector("body.i-font_face_ys-text.i-bem.fonts-loaded:nth-child(2) div._3P0bsUXnav:nth-child(3) div._2BUQxcqKF7._1brbPchUJq div.TyYugfiSCL._2FbMnl5WYr div._34n95BJuhn div._1RjY7YIluf._1zYszmgEzn div._2JU13fzXEa div._1SEkJje5GJ:nth-child(4) div._2BUQxcqKF7:nth-child(2) div._2DZ2DFBFda div._1QpP2zubQ8 div._301_b-LBxR span:nth-child(1) button._2Y-iyAqjAL._4qhIn2-ESi.qAmx3n7Iqk._18c2gUxCdP span._2w0qPDYwej span:nth-child(1) > span._3RM4_n5whA");
    int i = 0;
    public HomePage(ChromeDriver d)
    {
        driver = d;
        driver.manage().window().fullscreen();
        action = new Actions(driver);
    }
    public void GoToWebsite()
    {
        driver.get("https://beru.ru/");
    }
    public void GoToMyProfile() throws InterruptedException
    {
        authorizationPage = new AuthorizationPage(driver, login, password);
        authorizationPage.Authorization();

    }
    public void CheckCorrectAuthorization()
    {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("pFhTbV17qj")));
        String text = driver.findElementByClassName("pFhTbV17qj").getText();
        Assert.assertTrue(text.equals("Мой профиль"));
    }
    public void CheckLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("pFhTbV17qj")));
        element = driver.findElementByClassName("pFhTbV17qj");
        element.click();
    }
    public void ChangeCity(String cityName)
    {

        WebElement city = driver.findElement(cityButton);
        city.click();
        char[] charArray = cityName.toCharArray();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityChange));
        webElement = driver.findElement(cityChange);
        webElement.click();
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) driver1 -> {

            driver1.findElement(cityChange).sendKeys(charArray[i] + "");
            i++;
            return driver1.findElement(popUpCity).getText().split("\n")[0].equals(cityName);
        });

        wait.until(ExpectedConditions.elementToBeClickable(popUpCity));
        webElement = driver.findElement(popUpCity);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(cityConfirmButton));
        webElement = driver.findElement(cityConfirmButton);
        webElement.click();

    }
    public void CheckCity(String cityName)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityResult));
        String text = driver.findElement(cityResult).getText();
        Assert.assertTrue(text.equals(cityName));
    }
    public void  CatalogClick(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(citeCatalog));
        webElement = driver.findElement(citeCatalog);
        webElement.click();
        webElement.click();
        webElement.click();
    }

}
