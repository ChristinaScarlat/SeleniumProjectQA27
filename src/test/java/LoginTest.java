import org.junit.After;
import org.junit.Assert;
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
        WebElement welcomeText = driver.findElement(By.cssSelector(".my-account strong"));
        Assert.assertEquals("Hello, Christina Scarlat!", welcomeText.getText());
        WebElement myAccount = driver.findElement(By.cssSelector("div.main-container.col2-left-layout span"));
        Assert.assertTrue(myAccount.isDisplayed());

    }
    @Test
    public void changeLanguageTest(){
//        select-language
        Select selectLanguageDropdown = new Select(driver.findElement(By.id("select-language")));
        selectLanguageDropdown.selectByVisibleText("French");
        WebElement language = driver.findElement(By.cssSelector("#select-language > option:nth-child(2)"));
        Assert.assertTrue(language.isSelected());

    }

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




    @After
    public void closeDriver(){
        driver.quit();
    }

}
