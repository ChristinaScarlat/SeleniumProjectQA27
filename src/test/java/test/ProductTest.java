package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductTest extends BaseTest{

    @Test
    public void hoverOverCategoryTest(){
        Actions action = new Actions(driver);
        WebElement womenCategory = driver.findElement(By.cssSelector("li.level0.nav-1.first.parent > a"));
        action.moveToElement(womenCategory).perform();
        WebElement viewAll = driver.findElement(By.cssSelector("li.level1.view-all > a"));
        viewAll.click();
    }


    @Test
    public void selectPosition(){
        driver.findElement(By.cssSelector("li.level0.nav-5.parent a.level0.has-children")).click();
        driver.findElement(By.cssSelector(".sort-by select ")).click();
    }

}
