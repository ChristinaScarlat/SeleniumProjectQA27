package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.*;

public abstract class BaseTest {
    public String userEmail = "alexandra.christina@yahoo.com";
    public String userPass = "1234567";
    public String userFirstName = "Christina";
    public String userLastName = "Scarlat";
    public String userName = "Christina Scarlat";
    // driver
    public WebDriver driver;


    // page objects
    public HomePage homePage;
    public LoginPage loginPage;
    public AccountPage accountPage;
    public SearchResultsPage searchResultsPage;
    public ProductPage productPage;
    public CartPage cartPage;
    public RegisterPage registerPage;



    @Before
    public void initDriver() {
        // init driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //init page objects
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        registerPage = new RegisterPage(driver);


        // navigate to homepage
        driver.get("http://testfasttrackit.info/selenium-test");
    }


    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @After
    public void closeDriver() {
        driver.quit();
    }
}
