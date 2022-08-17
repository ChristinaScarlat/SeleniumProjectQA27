package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WishListTest extends BaseTest {

    @Test
    public void validWishListTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title = 'Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("alexandra.christina@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("1234567");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("li.level0.nav-5.parent")).click();
        driver.findElement(By.cssSelector("a.link-wishlist")).click();
        WebElement wishlistmsg = driver.findElement(By.cssSelector(".my-wishlist span"));
        Assert.assertEquals("Slim fit Dobby Oxford Shirt has been added to your wishlist. Click here to continue shopping.",wishlistmsg.getText() );

    }


    @Test
    public void addToWishList(){
        Actions action = new Actions(driver);
        WebElement womenDress = driver.findElement(By.cssSelector("li.level0.nav-1.first.parent"));
        action.moveToElement(womenDress).perform();
        WebElement dresses = driver.findElement(By.cssSelector("li.level1.nav-1-4.last a"));
        dresses.click();
        driver.findElement(By.cssSelector("li.item.last:nth-child(3)")).click();
        driver.findElement(By.cssSelector("a.link-wishlist")).click();
        WebElement wishlmsg = driver.findElement(By.cssSelector(".page-title h1"));
        Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT",wishlmsg.getText() );
        driver.findElement(By.id("email")).sendKeys("alexandra.christina@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("1234567");
        driver.findElement(By.id("send2")).click();
        }


}
