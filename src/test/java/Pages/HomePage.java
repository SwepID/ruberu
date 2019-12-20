package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;
    AuthorizationPage authorizationPage;
    private String login = "testBeru2019";
    private String password = "05281230nm";
    private By cityResult = By.cssSelector("span[data-auto='region-form-opener'].zB1fta3NQ5");
    String cityName;
    WebElement element;
    Actions action;
    private WebElement webElement;
    private By cityButton = By.cssSelector("span [data-auto = \"region-form-opener\"]");
    private By cityChange = By.cssSelector("div._1U2ErCeoqP  input[data-tid=\"37e0ab2d\"]");
    private By popUpCity = By.cssSelector("li#react-autowhatever-region--item-0 div._229JDbp_Z8");
    private By cityConfirmButton = By.cssSelector("button[data-tid='71e1c78d']._4qhIn2-ESi.Pjv3h3YbYr.THqSbzx07u");
    private By citeCatalog = By.className("_3RM4_n5whA");
    int i = 0;

    public HomePage(WebDriver d) {
        PageFactory.initElements(d, this);
        driver = d;
        //driver.manage().window().fullscreen();
        //action = new Actions(driver);
    }

    @Step(value = "Переходим на сайт")
    public void GoToWebsite() {
        driver.get("https://beru.ru/");
    }

    @Step(value = "Логинимся")
    public void GoToMyProfile() throws InterruptedException {
        authorizationPage = new AuthorizationPage(driver, login, password);
        authorizationPage.Authorization();

    }

    @Step(value = "Проверяем авторизацию")
    public void CheckCorrectAuthorization() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("pFhTbV17qj")));
        String text = driver.findElement(By.className("pFhTbV17qj")).getText();
        //String text = _driver.findElementByClassName("pFhTbV17qj").getText();
        Assert.assertEquals(text, "Мой профиль");
    }

    @Step(value = "Меняем город")
    public void ChangeCity(String cityName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityButton));
        WebElement city = driver.findElement(cityButton);
        city.click();
        char[] charArray = cityName.toCharArray();
        wait.until(ExpectedConditions.elementToBeClickable(cityChange));
        webElement = driver.findElement(cityChange);
        webElement.click();
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        for (int i = 0; i < cityName.length(); i++) {
            webElement.sendKeys(charArray[i] + "");
            if (driver.findElement(popUpCity).getText().equals(cityName)) {
                wait.until(ExpectedConditions.elementToBeClickable(popUpCity));
                webElement = driver.findElement(popUpCity);
                webElement.click();
                wait.until(ExpectedConditions.elementToBeClickable(cityConfirmButton));
                webElement = driver.findElement(cityConfirmButton);
                webElement.click();
                break;
            }
        }


    }

    @Step(value = "Проверяем смену города")
    public void CheckCity(String cityName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityResult));
        String text = driver.findElement(cityResult).getText();
        Assert.assertEquals(text, cityName);
    }

    @Step(value = "Переходим в каталог")
    public void CatalogClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(citeCatalog));
        webElement = driver.findElement(citeCatalog);
        webElement.click();
        webElement.click();
        webElement.click();
    }

}
