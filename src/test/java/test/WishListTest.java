package test;

import org.junit.Assert;
import org.junit.Test;

public class WishListTest extends BaseTest {
    @Test
    public void validWishListTest() {
        homePage.clickAccountLink();
        homePage.clickLoginLink();
        loginPage.setEmailField(userEmail);
        loginPage.setPasswordField(userPass);
        loginPage.clickLoginButton();
        productPage.setNewElementSelect();
        productPage.setNewElementWishListBTN();
        Assert.assertEquals("Slim fit Dobby Oxford Shirt has been added to your wishlist. Click here to continue shopping.",productPage.setWishListMsg());
    }


    @Test
    public void addToWishList(){
        productPage.addElementToWishList();
        Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT", productPage.setAddToWishListMsg());
        loginPage.setEmailField(userEmail);
        loginPage.setPasswordField(userPass);
        loginPage.clickLoginButton();
    }


}
