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

public class CartPage {
    private WebElement webElement;
    WebDriver driver;
    WebDriverWait wait;
    private By GoToOffer = By.cssSelector("body.i-font_face_ys-text.i-bem.fonts-loaded:nth-child(2) div._3P0bsUXnav:nth-child(3) div._1Asd4EDRH1 div._2BUQxcqKF7 div.TyYugfiSCL._2FbMnl5WYr div._34n95BJuhn div._1RjY7YIluf._1zYszmgEzn div._2BUQxcqKF7 div.TyYugfiSCL._1mn6bk-Kdd div._34n95BJuhn div._3jL0_TN4Nh._1zYszmgEzn div.wn9mZbgWbv div._1_MhGKBSdf.OHoJyJ31dc._1Bqj5hjqQP._1pL3KFGwYS._1_2AqXgUHf._3uF4NmGgPB._3fkumlQvX-._20JhIdT02p._3fkumlQvX-._14AHp3_8KT._3fkumlQvX-._232cyjAUF1._3fkumlQvX-._1GmZ2hEI7I.XDCjeStZYD div.KgZT-UYxg1._3l-uEDOaBN.tdrs43E7Xn._3HJsMt3YC_._1MLtFZArtE div.bLjj5ddV9I div:nth-child(1) div:nth-child(1) span._3ioN70chUh._3Uc73lzxcf button._4qhIn2-ESi.Pjv3h3YbYr.THqSbzx07u._39B7yXQbvm._2W4X8tX6r0 > span._2w0qPDYwej");
    private By courier = By.cssSelector("div[data-auto = \"DeliveryTypeOptions\"]>div[data-auto= \"DELIVERY\"] label");
    private By continueOffer = By.cssSelector("body.i-font_face_ys-text.i-bem.fonts-loaded:nth-child(2) div._1DfhmTFmNb div.CdFaGF7JTk:nth-child(3) div._2BUQxcqKF7 div._2IRVwkC-6U div.TyYugfiSCL._1mn6bk-Kdd div._34n95BJuhn div.cf-aLz-nHV._1zYszmgEzn div._2GdhUf5zZj div.section._5ukL9mz10n._2xwcHVtjcy div:nth-child(1) div:nth-child(1) div.TYNe7dVy1Z:nth-child(2) button._4qhIn2-ESi.Pjv3h3YbYr.THqSbzx07u._39B7yXQbvm > span._2w0qPDYwej");
    private By value = By.cssSelector("div[data-auto = \"total-items\"]>span[data-auto = \"value\"]");
    private By delivery = By.cssSelector("div[data-auto = \"total-delivery\"]>span[data-auto = \"value\"]");
    private By discount = By.cssSelector("div[data-auto = \"total-discount\"]>span:last-child");
    private By totalCost = By.cssSelector("div[data-auto = \"total-price\"]>span:last-child");
    private By cartTotalCost = By.cssSelector("div [class = \"_1Q9ASvPbPN _2wL0LFKDDY\"] [class = \"_1oBlNqVHPq\"]");
    private By changeOrder = By.cssSelector("div [class = \"_3l-uEDOaBN tdrs43E7Xn _2PRCigFlCd _1MLtFZArtE\"] [class = \"_3ioN70chUh _3Uc73lzxcf\"]");
    private By countOfBrushes = By.cssSelector("div [class = \"LVfMs-qeRX tOTC_Mrer- _38DKtrKp3V nczD08OBdF _14soKew2iU _1THPOeyTwM _2BlEGjPqbW\"] input");

    public CartPage(WebDriver d) {
        PageFactory.initElements(d, this);
        driver = d;
        wait = new WebDriverWait(driver, 10);
    }

    @Step(value = "Проверяем Цену щеток в корзине, учитывая доставку + скидку")
    public void CheckPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(GoToOffer));
        webElement = driver.findElement(GoToOffer);
        webElement.click();
        try {
            ContinueOffer();
        } catch (Exception e) {

        }
        wait.until(ExpectedConditions.elementToBeClickable(courier));
        webElement = driver.findElement(courier);
        webElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(value));
        webElement = driver.findElement(value);
        int price = 0;
        int deliveryPrice = 0;
        int discountPrice = 0;
        int finallyCost = 0;
        String text = webElement.getText();
        text = text.substring(0, text.length() - 2);
        text = text.replaceAll(" ", "");
        price = Integer.parseInt(text);
        webElement = driver.findElement(delivery);
        String text2 = webElement.getText();
        text2 = text2.substring(0, text2.length() - 2);
        text2 = text2.replaceAll(" ", "");
        try {
            deliveryPrice = Integer.parseInt(text2);
        } catch (Exception e) {

        }
        try {
            webElement = driver.findElement(discount);
            String text3 = webElement.getText();
            text3 = text3.substring(0, text3.length() - 2);
            text3 = text3.replaceAll(" ", "");
            text3 = text3.replaceAll("−", "-");

            discountPrice = Integer.parseInt(text3);
        } catch (Exception e) {

        }
        webElement = driver.findElement(totalCost);
        String text4 = webElement.getText();
        text4 = text4.substring(0, text4.length() - 2);
        text4 = text4.replaceAll(" ", "");
        finallyCost = Integer.parseInt(text4);
        Assert.assertEquals(finallyCost, price + discountPrice + deliveryPrice);
    }

    public void ChangeOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(changeOrder));
        webElement = driver.findElement(changeOrder);
        webElement.click();
    }

    private void ContinueOffer() {
        wait.until(ExpectedConditions.elementToBeClickable(continueOffer));
        webElement = driver.findElement(continueOffer);
        webElement.click();
    }

    private void GoToOffer() {
        wait.until(ExpectedConditions.elementToBeClickable(GoToOffer));
        webElement = driver.findElement(GoToOffer);
        webElement.click();
    }

    public void IncreasePrice(int Price) {
        wait.until(ExpectedConditions.elementToBeClickable(countOfBrushes));
        webElement = driver.findElement(countOfBrushes);
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        webElement.sendKeys("9");
        webElement = driver.findElement(cartTotalCost);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        GoToOffer();
        ContinueOffer();
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalCost));
        webElement = driver.findElement(totalCost);

        wait.until(ExpectedConditions.elementToBeClickable(courier));
        webElement = driver.findElement(courier);
        webElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(value));
        webElement = driver.findElement(value);
        int price = 0;
        int deliveryPrice = 0;
        int discountPrice = 0;
        int finallyCost = 0;
        String text = webElement.getText();
        text = text.substring(0, text.length() - 2);
        text = text.replaceAll(" ", "");
        price = Integer.parseInt(text);
        webElement = driver.findElement(delivery);
        String text2 = webElement.getText();
        text2 = text2.substring(0, text2.length() - 2);
        text2 = text2.replaceAll(" ", "");
        try {
            deliveryPrice = Integer.parseInt(text2);
        } catch (Exception e) {

        }
        try {
            webElement = driver.findElement(discount);
            String text3 = webElement.getText();
            text3 = text3.substring(0, text3.length() - 2);
            text3 = text3.replaceAll(" ", "");
            text3 = text3.replaceAll("−", "-");

            discountPrice = Integer.parseInt(text3);
        } catch (Exception e) {

        }
        webElement = driver.findElement(totalCost);
        String text4 = webElement.getText();
        text4 = text4.substring(0, text4.length() - 2);
        text4 = text4.replaceAll(" ", "");
        finallyCost = Integer.parseInt(text4);
        Assert.assertTrue(finallyCost == price + discountPrice + deliveryPrice && finallyCost > Price);

    }

}
