package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest extends BaseTest{

    @Test
    public void addElementCartTest(){
        homePage.clickAccountLink();
        homePage.clickLoginLink();
        loginPage.setEmailField("alexandra.christina@yahoo.com");
        loginPage.setPasswordField("1234567");
        loginPage.clickLoginButton();



        driver.findElement(By.cssSelector("li.level0.nav-6 a.level0")).click();
        driver.findElement(By.cssSelector("li.item.last:nth-last-of-type(2) div.product-info h2.product-name a")).click();
        driver.findElement(By.id("swatch20")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons button")).click();
        WebElement addCart = driver.findElement(By.cssSelector("li.success-msg span"));
        Assert.assertEquals("Modern Murray Ceramic Vase was added to your shopping cart.", addCart.getText());

    }
    @Test
    public void removeItemCartTest(){
        driver.findElement(By.cssSelector("li.level0.nav-6 a.level0")).click();
        driver.findElement(By.cssSelector("li.item.last:nth-last-of-type(2) div.product-info h2.product-name a")).click();
        driver.findElement(By.id("swatch20")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons button")).click();
        driver.findElement(By.cssSelector("td.a-center.product-cart-remove.last a")).click();
        WebElement removeICart = driver.findElement(By.cssSelector(".page-title h1"));
        Assert.assertEquals("SHOPPING CART IS EMPTY", removeICart.getText());

    }
    @Test
    public void checkoutTest(){
        driver.findElement(By.cssSelector("li.level0.nav-6 a.level0")).click();
        driver.findElement(By.cssSelector("li.item.last:nth-last-of-type(2) div.product-info h2.product-name a")).click();
        driver.findElement(By.id("swatch20")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons button")).click();
        driver.findElement(By.cssSelector("div.header-minicart span.label")).click();
        driver.findElement(By.cssSelector("div.minicart-actions a.cart-link")).click();
        driver.findElement(By.cssSelector("li.method-checkout-cart-methods-onepage-bottom button.btn-proceed-checkout.btn-checkout ")).click();
        WebElement checkOutCart = driver.findElement(By.cssSelector("#checkout-step-login h3"));
        Assert.assertEquals("CHECKOUT AS A GUEST OR REGISTER", checkOutCart.getText());
        WebElement checkoutNotRegistered = driver.findElement(By.cssSelector("li.control input"));
        Assert.assertTrue(checkoutNotRegistered.isSelected());
        driver.findElement(By.cssSelector("#onepage-guest-register-button span")).click();
    }


}
