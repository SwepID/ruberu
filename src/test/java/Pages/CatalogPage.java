package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CatalogPage {

    private WebElement webElement;
    WebDriver driver;
    private By section = By.className("_3YXmW04bmk");
    private By electricToothbrushes = By.cssSelector("a[href^='/catalog/elektricheskie-zubnye-shchetki']");
    private By electricToothbrushesLowPrice = By.cssSelector("div[data-auto = \"filter-range-glprice\"] span[data-auto = \"filter-range-min\"] input");
    private By electricToothbrushesHighPrice = By.cssSelector("div[data-auto = \"filter-range-glprice\"] span[data-auto = \"filter-range-max\"] input");
    private By showMore = By.cssSelector("body.i-font_face_ys-text.i-bem.fonts-loaded:nth-child(2) div._3P0bsUXnav:nth-child(5) div._2BUQxcqKF7 div.TyYugfiSCL._1mn6bk-Kdd div._34n95BJuhn div._3GNaczqaFf._1zYszmgEzn div._1_MhGKBSdf.mclNz6d_XS div.KgZT-UYxg1 div._2w4txqzWbX div:nth-child(1) button._4qhIn2-ESi.qAmx3n7Iqk._18c2gUxCdP._39B7yXQbvm > span._2w0qPDYwej");
    private By beforeLastToothBrush = By.cssSelector("div[data-tid = \"596c5524\"] >div:last-child >div >div>div> div:nth-last-child(2)>div>div>div>div>div>div button");
    private By Cart = By.className("_1LEwf9X1Gy");
    private By products = By.cssSelector("div [class = \"_3rWYRsam78\"] [data-tid = \"8c326881\"] [data-auto = \"price\"]");
    private List<WebElement> instances;
    public CatalogPage(WebDriver d) {
        PageFactory.initElements(d, this);
        driver = d;
        //driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
    }

    @Step(value = "Выбираем секцию Новый год")
    public void SectionClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='_22iWsDVCEi']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(section));
        wait.until(ExpectedConditions.elementToBeClickable(section));
        webElement = driver.findElement(section);
        webElement.click();
    }

    @Step(value = "Выбираем раздел электрических зубных щеток")
    public void ElectricToothbrushesClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(electricToothbrushes));
        webElement = driver.findElement(electricToothbrushes);
        webElement.click();
    }

    @Step(value = "Устанавливаем диапазон цен для щеток")
    public void ChoseToothbrushPrice(String lowPrice, String highPrice) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushesLowPrice));
        wait.until(ExpectedConditions.visibilityOfElementLocated(electricToothbrushesLowPrice));
        webElement = driver.findElement(electricToothbrushesLowPrice);
        webElement.click();
        webElement.sendKeys(lowPrice);
        wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushesHighPrice));
        wait.until(ExpectedConditions.visibilityOfElementLocated(electricToothbrushesHighPrice));
        webElement = driver.findElement(electricToothbrushesHighPrice);
        webElement.click();
        webElement.sendKeys(highPrice);
        wait.until(ExpectedConditions.visibilityOfElementLocated(products));
    }

    @Step(value = "Выбираем предпоследнюю электрическую зубную щетку")
    public void PutToothBrush() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            webElement = driver.findElement(showMore);
            webElement.click();
        } catch (Exception e) {

        }
        wait.until(ExpectedConditions.elementToBeClickable(beforeLastToothBrush));
        webElement = driver.findElement(beforeLastToothBrush);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(Cart));
        webElement = driver.findElement(Cart);
        webElement.click();
    }
    @Step(value = "Перейти в корзину")
    public void GoToCartPage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(Cart));
        webElement = driver.findElement(Cart);
        webElement.click();
    }
    @Step(value =  "Проверяем корректность диапазона цен")
    public void CheckCorrectPrice(int minPrice, int maxPrice) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(beforeLastToothBrush));
        instances = driver.findElements(products);
        try {
            for (WebElement elem : instances) {
                String priceToothBrush = elem.getText();
                priceToothBrush = priceToothBrush.substring(0, priceToothBrush.length() - 2);
                priceToothBrush = priceToothBrush.replaceAll(" ", "");
                int price = Integer.parseInt(priceToothBrush);
                Assert.assertEquals(price>=minPrice, price<= maxPrice);
            }
        }
        catch (Exception ex) {

        }
    }
}
