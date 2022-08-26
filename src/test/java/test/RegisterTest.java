package test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest extends BaseTest {

  @Test
    public void validRegisterTest(){
      homePage.clickAccountLink();
      registerPage.setRegisterSelect();
      registerPage.setFirstnameField(userFirstName);
      registerPage.setLastnameField(userLastName);
      registerPage.setEmailField(userEmail);
      registerPage.setPasswordField(userPass);
      registerPage.setConfirmationField(userPass);
      registerPage.setRegisterButton();
      wait(3);
     // Assert.assertEquals("The account with this email address doesn't existent.", registerPage.setErrorRegisterMessage());
      Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.", registerPage.setErrorRegisterMessage());



        }
}



