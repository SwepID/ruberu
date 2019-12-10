package Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage {
    ChromeDriver driver;
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
    public AuthorizationPage(ChromeDriver d, String login, String password)
    {
        driver = d;
        this.login = login;
        this.password = password;
    }
    @Step(value = "Авторизуемся")
    public void Authorization()
    {
        enterButton = driver.findElementByClassName("_3ZGcN3lbEg"); // иконка входа
        enterButton.click(); // кликаем чтобы войти
        loginField = driver.findElementByXPath("//*[@id=\"passp-field-login\"]"); // поле логина
        loginField.clear(); // очищаем поле логина
        loginField.sendKeys(login); // вводим наш логин
        enterButtonFromLoginToPassword = driver.findElementByXPath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]"); // кнопка войти
        enterButtonFromLoginToPassword.click(); // нажимаем кнопку войти
        WebDriverWait wait = new WebDriverWait(driver, 1); // ожидание
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passp-field-passwd\"]"))); // ожидаем появления поля пароля
        passwordField = driver.findElementByXPath("//*[@id=\"passp-field-passwd\"]"); // поле пароля
        passwordField.clear(); // очищаем поле пароля
        passwordField.sendKeys(password); // вводим пароль
        enterButtonForPassword = driver.findElementByXPath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div[1]/form/div[2]/button[1]"); // кнопка войти
        enterButtonForPassword.click(); // нажимаем кнопку войти
    }

}
