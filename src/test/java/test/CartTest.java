package test;

import org.junit.Assert;
import org.junit.Test;

public class CartTest extends BaseTest {

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
    public void removeItemCartTest() {
        homePage.clickAccountLink();
        homePage.clickLoginLink();
        loginPage.setEmailField(userEmail);
        loginPage.setPasswordField(userPass);
        loginPage.clickLoginButton();
        cartPage.CartButton();
        cartPage.setViewCart();
        wait(2);
        Assert.assertTrue(cartPage.removeFromCartButton("SWING TIME EARRINGS"));
        wait(2);
    }

    @Test
    public void checkoutCartTest() {
        homePage.clickAccountLink();
        homePage.clickLoginLink();
        loginPage.setEmailField(userEmail);
        loginPage.setPasswordField(userPass);
        loginPage.clickLoginButton();
        cartPage.CartButton();
        cartPage.setViewCart();
        wait(3);
        cartPage.getEmptyCartButton();
        Assert.assertEquals("SHOPPING CART IS EMPTY"
                , cartPage.getEmptyCartMessage());
    }

    @Test
    public void addCartAndCheckoutTest() {
        homePage.setSearchField("pillow");
        homePage.clickSearchButton();
        productPage.clickAddToCartButton();
        cartPage.clickProceedToCheckOutButton();
        Assert.assertEquals("CHECKOUT AS A GUEST OR REGISTER", cartPage.getCheckoutMessage());
        wait(4);
        cartPage.checkOutwithRegister();
        cartPage.continueBTNCheckOutRegister();
        wait(2);

    }


}
