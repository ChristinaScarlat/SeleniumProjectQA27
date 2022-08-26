package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest extends BaseTest{



    @Test
    public void searchForItemTest() {
        homePage.setSearchField("necklace");
        homePage.clickSearchButton();
        Assert.assertTrue("Product not found!",
                searchResultsPage.isProductInList("SILVER DESERT NECKLACE"));
    }

    @Test
    public void searchForItem2Test() {
        homePage.setSearchField("shirt");
        homePage.clickSearchButton();
        Assert.assertTrue("Product not found!",
                searchResultsPage.isProductInList("FRENCH CUFF COTTON TWILL OXFORD"));
    }
    @Test
    public void searchButtonTest() {

        homePage.setSearchField("SWING TIME EARRINGS");
        homePage.clickSearchButton();
        Assert.assertTrue("Product not found!",
                searchResultsPage.isProductInListAndSelect("SWING TIME EARRINGS"));
        wait(3);

    }

    @Test
    public void searchSantaClaus(){
        homePage.setSearchField("SANTA CLAUS");
        homePage.clickSearchButton();wait(3);
        Assert.assertEquals("Your search returns no results.", true, searchResultsPage.notProductInList("SANTA CLAUS"));


    }


}
