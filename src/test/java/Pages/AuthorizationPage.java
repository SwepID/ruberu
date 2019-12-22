package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage {
    WebDriver driver;
    String login;
    String password;
    WebElement element;
    WebElement enterToProfile;
    WebElement loginField;
    WebElement passwordField;
    WebElement enterButton;
    WebElement enterButtonFromLoginToPassword;
    WebDriverWait wait;
    WebElement enterButtonForPassword;
    By buttonSubmit = By.cssSelector("div [class = \"passp-button passp-sign-in-button\"] [type = \"submit\"]");
    By loginXpath = By.xpath("//*[@id=\"passp-field-login\"]");
    By passwordXpath = By.xpath("//*[@id=\"passp-field-passwd\"]");
    By enterClass = By.className("_3ZGcN3lbEg");
    public AuthorizationPage(WebDriver d, String login, String password) {
        PageFactory.initElements(d, this);
        driver = d;
        this.login = login;
        this.password = password;
    }

    @Step(value = "Авторизуемся")
    public void Authorization() {
        enterButton = driver.findElement(enterClass);
        enterButton.click();
        loginField = driver.findElement(loginXpath);
        loginField.clear();
        loginField.sendKeys(login);
        enterButtonFromLoginToPassword = driver.findElement(buttonSubmit);
        enterButtonFromLoginToPassword.click();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(passwordXpath));
        passwordField = driver.findElement(passwordXpath);
        passwordField.clear();
        passwordField.sendKeys(password);
        enterButtonForPassword = driver.findElement(buttonSubmit);
        enterButtonForPassword.click();
    }

}
