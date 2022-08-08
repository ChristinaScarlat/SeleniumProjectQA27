import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }

    @Test
    public void validLoginTest(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title = 'Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("alexandra.christina@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("1234567");
        driver.findElement(By.id("send2")).click();

    }
    @Test
    public void changeLanguageTest(){
//        select-language
        Select selectLanguageDropdown = new Select(driver.findElement(By.id("select-language")));
        selectLanguageDropdown.selectByVisibleText("German");

    }

    @Test
    public void hoverOverCategoryTest(){
        Actions action = new Actions(driver);
        WebElement womenCategory = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > a"));
        action.moveToElement(womenCategory).perform();
        WebElement viewAll = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > ul > li.level1.view-all > a"));
        viewAll.click();


    }


    @Test
    public void searchButtonTest(){

       // driver.findElement(By.id("search")).click();
        driver.findElement(By.cssSelector(".input-box button")).click();

    }
    @Test
    public void addElementCartTest(){
        driver.findElement(By.cssSelector("li.level0.nav-6 a.level0")).click();
        driver.findElement(By.cssSelector("li.item.last:nth-last-of-type(2) div.product-info h2.product-name a")).click();
        driver.findElement(By.id("swatch20")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons button")).click();

    }
    @Test
    public void removeItemCartTest(){
        driver.findElement(By.cssSelector("li.level0.nav-6 a.level0")).click();
        driver.findElement(By.cssSelector("li.item.last:nth-last-of-type(2) div.product-info h2.product-name a")).click();
        driver.findElement(By.id("swatch20")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons button")).click();
        driver.findElement(By.cssSelector("td.a-center.product-cart-remove.last a")).click();
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
    }

    @Test
    public void selectPosition(){
        driver.findElement(By.cssSelector("li.level0.nav-5.parent a.level0.has-children")).click();
        driver.findElement(By.cssSelector(".sort-by select ")).click();
    }




    @After
    public void closeDriver(){
        driver.quit();
    }

}
