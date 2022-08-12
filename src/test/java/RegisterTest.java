import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }

        @Test
        public void validRegisterTest(){

            driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
            driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
            driver.findElement(By.id("firstname")).sendKeys("Christina");
            driver.findElement(By.id("lastname")).sendKeys("Scarlat");
            driver.findElement(By.id("email_address")).sendKeys("alexandra.christina@yahoo.com");
            driver.findElement(By.id("password")).sendKeys("1234567");
            driver.findElement(By.id("confirmation")).sendKeys("1234567");
            driver.findElement(By.cssSelector("#is_subscribed")).click();
            driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
            WebElement register = driver.findElement(By.cssSelector("li.error-msg span"));
            Assert.assertNotEquals("The account with this email address doesn't existent.",register.getText());
            Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.",register.getText());




        }


//    @After
//    public void closeDriver(){
//        driver.quit();
//    }
    }

