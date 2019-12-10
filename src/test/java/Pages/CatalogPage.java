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
import java.util.concurrent.TimeUnit;

public class CatalogPage {

    private WebElement webElement;
    WebDriver driver;
    private By section = By.className("_3YXmW04bmk");
    private By electricToothbrushes = By.cssSelector("a[href^='/catalog/elektricheskie-zubnye-shchetki']");
    //private By electricToothbrushesLowPrice = By.id("textfield4482059963");
    //private By electricToothbrushesHighPrice = By.id("textfield9507591892");
    private By electricToothbrushesLowPrice = By.cssSelector("div[data-auto = \"filter-range-glprice\"] span[data-auto = \"filter-range-min\"] input");
    private By electricToothbrushesHighPrice = By.cssSelector("div[data-auto = \"filter-range-glprice\"] span[data-auto = \"filter-range-max\"] input");
    private By showMore = By.cssSelector("body.i-font_face_ys-text.i-bem.fonts-loaded:nth-child(2) div._3P0bsUXnav:nth-child(5) div._2BUQxcqKF7 div.TyYugfiSCL._1mn6bk-Kdd div._34n95BJuhn div._3GNaczqaFf._1zYszmgEzn div._1_MhGKBSdf.mclNz6d_XS div.KgZT-UYxg1 div._2w4txqzWbX div:nth-child(1) button._4qhIn2-ESi.qAmx3n7Iqk._18c2gUxCdP._39B7yXQbvm > span._2w0qPDYwej");
    private By beforeLastToothBrush = By.cssSelector("div[data-tid = \"596c5524\"] >div:last-child >div >div>div> div:nth-last-child(2)>div>div>div>div>div>div button");
    private By Cart = By.className("_1LEwf9X1Gy");
    public CatalogPage(ChromeDriver d)
    {
        driver = d;
        driver.manage().window().fullscreen();
        //driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
    }
    public void SectionClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='_22iWsDVCEi']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(section));
        wait.until(ExpectedConditions.elementToBeClickable(section));
        webElement = driver.findElement(section);
        webElement.click();
    }
    public void ElectricToothbrushesClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushes));
        wait.until(ExpectedConditions.visibilityOfElementLocated(electricToothbrushes));
        webElement = driver.findElement(electricToothbrushes);
        webElement.click();
    }
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
    }
    public void PutToothBrush()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try
        {
            webElement = driver.findElement(showMore);
            webElement.click();
        }
        catch (Exception e)
        {

        }
        wait.until(ExpectedConditions.elementToBeClickable(beforeLastToothBrush));
        webElement = driver.findElement(beforeLastToothBrush);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(Cart));
        webElement = driver.findElement(Cart);
        webElement.click();
    }
}
