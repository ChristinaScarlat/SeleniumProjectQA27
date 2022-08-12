import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
         private WebDriver driver;

        @Before
        public void initDriver(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://testfasttrackit.info/selenium-test");
        }


    @Test
    public void searchButtonTest() {

        // driver.findElement(By.id("search")).click();
        driver.findElement(By.cssSelector(".input-box button")).click();
        driver.findElement(By.id("search")).sendKeys("SWING TIME EARRINGS");
        driver.findElement(By.cssSelector("div button")).click();
        WebElement search = driver.findElement(By.cssSelector("div input"));
        Assert.assertTrue(search.isDisplayed());
    }

    @Test
    public void searchSantaClaus(){
        driver.findElement(By.id("search")).sendKeys("SANTA CLAUS");
        driver.findElement(By.cssSelector("div button")).click();
        WebElement searchMsg = driver.findElement(By.cssSelector("p.note-msg"));
        Assert.assertEquals("Your search returns no results.",searchMsg.getText());

    }


    @After
    public void closeDriver(){
        driver.quit();
    }


}
