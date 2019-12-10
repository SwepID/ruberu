package Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
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

public class ToothBrushPage {
    private WebElement webElement;

    private By electricToothbrushesLowPrice = By.id("textfield659863234");
    private By electricToothbrushesHighPrice = By.id("textfield8055248256");
    private By showMore = By.cssSelector("body.i-font_face_ys-text.i-bem.fonts-loaded:nth-child(2) div._3P0bsUXnav:nth-child(5) div._2BUQxcqKF7 div.TyYugfiSCL._1mn6bk-Kdd div._34n95BJuhn div._3GNaczqaFf._1zYszmgEzn div._1_MhGKBSdf.mclNz6d_XS div.KgZT-UYxg1 div._2w4txqzWbX div:nth-child(1) button._4qhIn2-ESi.qAmx3n7Iqk._18c2gUxCdP._39B7yXQbvm > span._2w0qPDYwej");
    ChromeDriver driver;

    public ToothBrushPage(ChromeDriver d)
    {
        driver = d;
        driver.manage().window().fullscreen();
    }
    public void ChoseToothbrushPrice(String lowPrice, String highPrice){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushesLowPrice));
        webElement = driver.findElement(electricToothbrushesLowPrice);
        webElement.click();
        webElement.sendKeys(lowPrice);
        wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushesHighPrice));
        webElement = driver.findElement(electricToothbrushesHighPrice);
        webElement.click();
        webElement.sendKeys(highPrice);
    }

}
