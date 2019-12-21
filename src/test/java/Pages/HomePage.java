package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
    private By myProfileButton = By.className("_3ZGcN3lbEg");
    private By cityButton = By.cssSelector("span [data-auto = \"region-form-opener\"]");
    private By cityChange = By.cssSelector("div._1U2ErCeoqP  input[data-tid=\"37e0ab2d\"]");
    private By popUpCity = By.cssSelector("li#react-autowhatever-region--item-0 div._229JDbp_Z8");
    private By cityConfirmButton = By.cssSelector("button[data-tid='71e1c78d']._4qhIn2-ESi.Pjv3h3YbYr.THqSbzx07u");
    private By citeCatalog = By.className("_3RM4_n5whA");
    private By settingsButton = By.cssSelector("body.i-font_face_ys-text.i-bem.fonts-loaded:nth-child(2) div._3P0bsUXnav:nth-child(1) div._2BUQxcqKF7._1brbPchUJq div.TyYugfiSCL._2FbMnl5WYr div._34n95BJuhn div._1RjY7YIluf._1zYszmgEzn div._2JU13fzXEa div._1SEkJje5GJ:nth-child(3) div._2BUQxcqKF7:nth-child(2) div._2DZ2DFBFda div.Mvy4Zvr556 div._3odNv2Dw2n:nth-child(1) div._2ubPaMe58x._3ZZzYB8tbn.root_arrow_none._1J8-Ybuzc_:nth-child(3) div._3gVpo2i2jf ul.T3jKK6NbAR:nth-child(5) ul:nth-child(1) li:nth-child(3) a._3ioN70chUh._2PstwuMDky._2qK-uj8bL2 div._2kDChpcmLb > div._3BBUsZVSt0._3pvYcLe0Ew");
    private By cityInSettings = By.cssSelector("span [data-auto = \"region\"]");
    int i = 0;

    public HomePage(WebDriver d) {
        PageFactory.initElements(d, this);
        driver = d;
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

    @Step(value = "Проверяем смену города")
    public void CheckCity(String cityName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityResult));
        String text = driver.findElement(cityResult).getText();
        Assert.assertEquals(text, cityName);
    }
    @Step(value = "Проверяем сменился ли город в настройках")
    public void CheckCityFromSettings() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(myProfileButton));
        webElement = driver.findElement(myProfileButton);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(settingsButton));
        webElement = driver.findElement(settingsButton);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(cityInSettings));
        webElement = driver.findElement(cityInSettings);
        String settingsCity = webElement.getText();
        wait.until(ExpectedConditions.elementToBeClickable(cityButton));
        webElement = driver.findElement(cityButton);
        String city = webElement.getText();
        Assert.assertEquals(settingsCity, city);
    }
    @Step(value = "Переходим в каталог")
    public void CatalogClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(citeCatalog));
        webElement = driver.findElement(citeCatalog);
        webElement.click();
    }

}
