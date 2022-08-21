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
    public void addElementCartTest() {
        homePage.clickAccountLink();
        homePage.clickLoginLink();
        loginPage.setEmailField("alexandra.christina@yahoo.com");
        loginPage.setPasswordField("1234567");
        loginPage.clickLoginButton();

        productPage.selectProductVase();
        int productQty = 2;
        productPage.setQtyField(productQty);
        productPage.clickAddToCartButton();
        wait(3);
        Assert.assertEquals("modern murray ceramic vase was added to your shopping cart."
                , cartPage.getSuccessMessageSpan().toLowerCase());



    }
    @Test
    public void addToCartTest() {
            String productName = "Silver Desert necklace";
            int productQty = 2;

            homePage.setSearchField("necklace");
            homePage.clickSearchButton();
            Assert.assertTrue(searchResultsPage.isProductInListAndSelect(productName));
            productPage.setQtyField(productQty);
            productPage.clickAddToCartButton();
            Assert.assertEquals(productName.toLowerCase() + " was added to your shopping cart."
                    , cartPage.getSuccessMessageSpan().toLowerCase());
            Assert.assertEquals(productQty + "", cartPage.getQtyField());

        }

        @Test
        public void loginAndAddToCartTest() {
            String productName = "Silver Desert necklace";
            int productQty = 1;

            homePage.clickAccountLink();
            homePage.clickLoginLink();
            loginPage.setEmailField(userEmail);
            loginPage.setPasswordField(userPass);
            loginPage.clickLoginButton();
            homePage.setSearchField("necklace");
            homePage.clickSearchButton();
            Assert.assertTrue(searchResultsPage.isProductInListAndSelect(productName));
            productPage.setQtyField(productQty);
            productPage.clickAddToCartButton();
            Assert.assertEquals(productName.toLowerCase() + " was added to your shopping cart."
                    , cartPage.getSuccessMessageSpan().toLowerCase());
            Assert.assertEquals(productQty + "", cartPage.getQtyField());

        }



    @Test
    public void removeItemCartTest(){
        homePage.clickAccountLink();
        homePage.clickLoginLink();
        loginPage.setEmailField(userEmail);
        loginPage.setPasswordField(userPass);
        loginPage.clickLoginButton();
        cartPage.CartButton();
        cartPage.setViewCart();
                wait(2);
        cartPage.removeFromCartButton("DUMBO BOYFRIEND JEAN");
        //cartPage.setRemoveBTN();
        wait(2);}

        @Test
        public void checkoutCartTest(){
            homePage.clickAccountLink();
            homePage.clickLoginLink();
            loginPage.setEmailField(userEmail);
            loginPage.setPasswordField(userPass);
            loginPage.clickLoginButton();
            cartPage.CartButton();
            cartPage.setViewCart();
            wait(1);
            cartPage.getEmptyCartButton();

//        WebElement removeICart = driver.findElement(By.cssSelector(".page-title h1"));
//        Assert.assertEquals("SHOPPING CART IS EMPTY", removeICart.getText());

    }
    @Test
    public void addCartAndCheckoutTest(){
        homePage.setSearchField("pillow");
        homePage.clickSearchButton();
        productPage.clickAddToCartButton();
        cartPage.clickProceedToCheckOutButton();
        cartPage.checkOutwithRegister();
        cartPage.continueBTNCheckOutRegister();

//        driver.findElement(By.cssSelector("li.level0.nav-6 a.level0")).click();
//        driver.findElement(By.cssSelector("li.item.last:nth-last-of-type(2) div.product-info h2.product-name a")).click();
//        driver.findElement(By.id("swatch20")).click();
//        driver.findElement(By.cssSelector("div.add-to-cart-buttons button")).click();
//        driver.findElement(By.cssSelector("div.header-minicart span.label")).click();
//        driver.findElement(By.cssSelector("div.minicart-actions a.cart-link")).click();
//        driver.findElement(By.cssSelector("li.method-checkout-cart-methods-one-page-bottom button.btn-proceed-checkout.btn-checkout ")).click();
//        WebElement checkOutCart = driver.findElement(By.cssSelector("#checkout-step-login h3"));
//        Assert.assertEquals("CHECKOUT AS A GUEST OR REGISTER", checkOutCart.getText());
//        WebElement checkoutNotRegistered = driver.findElement(By.cssSelector("li.control input"));
//        Assert.assertTrue(checkoutNotRegistered.isSelected());
//        driver.findElement(By.cssSelector("#onepage-guest-register-button span")).click();
    }


}
