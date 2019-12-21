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

    public AuthorizationPage(WebDriver d, String login, String password) {
        PageFactory.initElements(d, this);
        driver = d;
        this.login = login;
        this.password = password;
    }

    @Step(value = "Авторизуемся")
    public void Authorization() {
        enterButton = driver.findElement(By.className("_3ZGcN3lbEg"));
        //enterButton = driver.findElementByClassName("_3ZGcN3lbEg");
        enterButton.click();
        loginField = driver.findElement(By.xpath("//*[@id=\"passp-field-login\"]"));
        //loginField = driver.findElementByXPath("//*[@id=\"passp-field-login\"]");
        loginField.clear();
        loginField.sendKeys(login);
        enterButtonFromLoginToPassword = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]"));
        //enterButtonFromLoginToPassword = driver.findElementByXPath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]");
        enterButtonFromLoginToPassword.click();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passp-field-passwd\"]")));
        passwordField = driver.findElement(By.xpath("//*[@id=\"passp-field-passwd\"]"));
        passwordField.clear();
        passwordField.sendKeys(password);
        enterButtonForPassword = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div[1]/form/div[2]/button[1]"));
        //enterButtonForPassword = driver.findElementByXPath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div[1]/form/div[2]/button[1]");
        enterButtonForPassword.click();
    }

}
