package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p.hello strong")
    private WebElement welcomeTextParagraph;

    public String getWelcomeText(){
        return welcomeTextParagraph.getText();
    }

    @FindBy(id= "select-language" )
    private WebElement language;

    public void clicksetLanguage(){ language.click();}

    public void setLanguage(String languageText){  language.sendKeys(languageText);
        language.click();}

    @FindBy(css ="div.main-container.col2-left-layout span" )
    private List<WebElement> myAccount;

    public boolean setMyAccount() {
        for (WebElement acc: myAccount){
            if (acc.isDisplayed()){
                return true;
            }
        }return false;
    }

    @FindBy(id= "select-language" )
    private List<WebElement> myLanguage;
    public boolean setMyLanguage() {
        for (WebElement languageElement: myLanguage){
            if (languageElement.isDisplayed()){
                return true;
            }
        }return false;
    }
}





