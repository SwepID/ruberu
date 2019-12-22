package Pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
    private By freeShipment = By.cssSelector("div [class = \"_3yDgi6ylNe\"] [class = \"_3e5zCA3HUO\"]");
    private By decreaseButton = By.cssSelector("body.i-font_face_ys-text.i-bem.fonts-loaded:nth-child(2) div._3P0bsUXnav:nth-child(3) div._1Asd4EDRH1 div._2BUQxcqKF7 div.TyYugfiSCL._2FbMnl5WYr div._34n95BJuhn div._1RjY7YIluf._1zYszmgEzn div._2BUQxcqKF7 div.TyYugfiSCL._1mn6bk-Kdd div._34n95BJuhn div._2bK5pi8G8K._1zYszmgEzn div._1_MhGKBSdf._2TFofSkO9m div.KgZT-UYxg1 div._3zfjK4vBmF div._28YngvLzyh div._1_MhGKBSdf._2er7mzKEW5._1dVZ35q5yJ div.KgZT-UYxg1 div._2AC-xwcK8k div._3iuuBXIa23 div._3iuuBXIa23._1GqGzm7LjG:nth-child(2) div._3iuuBXIa23._1fqzkmCCu3:nth-child(2) div._1DYZjT8fnu div._4QROsPzE8m div.VcZj0jcCdD div:nth-child(1) div:nth-child(1) button._4qhIn2-ESi._2sJs248D-A._18c2gUxCdP._24vNl4GJCb:nth-child(1) span._2w0qPDYwej > span.jE8-ezGMzW");
    private By increaseButton = By.cssSelector("body.i-font_face_ys-text.i-bem.fonts-loaded:nth-child(2) div._3P0bsUXnav:nth-child(3) div._1Asd4EDRH1 div._2BUQxcqKF7 div.TyYugfiSCL._2FbMnl5WYr div._34n95BJuhn div._1RjY7YIluf._1zYszmgEzn div._2BUQxcqKF7 div.TyYugfiSCL._1mn6bk-Kdd div._34n95BJuhn div._2bK5pi8G8K._1zYszmgEzn div._1_MhGKBSdf._2TFofSkO9m div.KgZT-UYxg1 div._3zfjK4vBmF div._28YngvLzyh div._1_MhGKBSdf._2er7mzKEW5._1dVZ35q5yJ div.KgZT-UYxg1 div._2AC-xwcK8k div._3iuuBXIa23 div._3iuuBXIa23._1GqGzm7LjG:nth-child(2) div._3iuuBXIa23._1fqzkmCCu3:nth-child(2) div._1DYZjT8fnu div._4QROsPzE8m div.VcZj0jcCdD div:nth-child(1) div:nth-child(1) > button._4qhIn2-ESi._2sJs248D-A._18c2gUxCdP._3hWhO4rvmA:nth-child(3)");
    public CartPage(WebDriver d) {
        PageFactory.initElements(d, this);
        driver = d;
        wait = new WebDriverWait(driver, 10);
    }

    @Step(value = "Проверяем Цену щеток в корзине, учитывая доставку + скидку")
    public void CheckPrice() {
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
    @Step(value =  "Изменить заказ")
    public void ChangeOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(changeOrder));
        webElement = driver.findElement(changeOrder);
        webElement.click();
    }
    @Step(value =  "Продолжить оформление заказа")
    public void ContinueOffer() {
        wait.until(ExpectedConditions.elementToBeClickable(continueOffer));
        webElement = driver.findElement(continueOffer);
        webElement.click();
    }
    @Step(value =  "Оформить заказ")
    public void GoToOffer() {
        wait.until(ExpectedConditions.elementToBeClickable(GoToOffer));
        webElement = driver.findElement(GoToOffer);
        webElement.click();
    }
    @Step(value =  "Проверить значение до бесплатной доставки осталось")
    public void CheckFreeShipment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(freeShipment));
        webElement = driver.findElement(freeShipment);
        String freeShipmnet = webElement.getText();
        String str = "Ещё немножко! До бесплатной доставки осталось";
        Assert.assertTrue(freeShipmnet.contains(str));
    }
    @Step(value =  "Повысить общую стоимость корзины")
    public void IncreasePrice(int Price) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTotalCost));
        webElement = driver.findElement(cartTotalCost);
        String totalPrice = webElement.getText();
        totalPrice = totalPrice.substring(0, totalPrice.length() - 2);
        totalPrice = totalPrice.replaceAll(" ", "");
        double cost = Double.parseDouble(totalPrice);
        int count = (int) Math.ceil(Price/cost);
        wait.until(ExpectedConditions.elementToBeClickable(countOfBrushes));
        webElement = driver.findElement(countOfBrushes);
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        webElement.sendKeys(Integer.toString(count));
        wait.until(ExpectedConditions.elementToBeClickable(increaseButton));
        WebElement buttonIncrease = driver.findElement(increaseButton);
        buttonIncrease.click();
        wait.until(ExpectedConditions.elementToBeClickable(decreaseButton));
        WebElement buttonDecrease = driver.findElement(decreaseButton);
        for (int i=0;i<2;i++){
            wait.until(ExpectedConditions.elementToBeClickable(increaseButton));
            wait.until(ExpectedConditions.elementToBeClickable(decreaseButton));
            buttonIncrease.click();
            buttonDecrease.click();
            wait.until(ExpectedConditions.elementToBeClickable(GoToOffer));
        }
        wait.until(ExpectedConditions.elementToBeClickable(GoToOffer));
        GoToOffer();
    }

}
