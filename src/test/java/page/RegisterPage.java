package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private WebDriver driver;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css="#header-account > div > ul > li:nth-child(5) > a")
    private WebElement registerSelect;
    @FindBy(id="firstname")
    private WebElement firstnameField;
    @FindBy(id="lastname")
    private WebElement lastnameField;
    @FindBy(id="email_address")
    private WebElement emailField;
    @FindBy(id="password")
    private WebElement passwordField;
    @FindBy(id="confirmation")
    private WebElement confirmationField;
    @FindBy(css="#is_subscribed")
    private WebElement subscribeBox;
    @FindBy(css="#form-validate > div.buttons-set > button")
    private WebElement registerButton;
    @FindBy(css="li.error-msg span")
    private WebElement errorRegisterMessage;



    public void setRegisterSelect() {
        registerSelect.click();
    }
    public void setFirstnameField(String userFirstName) {
        firstnameField.sendKeys(userFirstName);
    }
    public void setLastnameField(String userLastName) {
        lastnameField.sendKeys(userLastName);
    }
    public void setEmailField(String userEmail) {
        emailField.sendKeys(userEmail);
    }
    public void setPasswordField(String userPass) {
        passwordField.sendKeys(userPass);
    }
    public void setConfirmationField(String userPass) {
        confirmationField.sendKeys(userPass);
    }
    public void setRegisterButton() {
        registerButton.click();
    }
    public String setErrorRegisterMessage() {
        return errorRegisterMessage.getText();
    }

}
