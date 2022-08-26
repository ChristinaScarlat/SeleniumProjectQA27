package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p.hello strong")
    private WebElement welcomeTextParagraph;

    public String getWelcomeText() {
        return welcomeTextParagraph.getText();
    }



    @FindBy(id = "select-language")
    private WebElement language;
    @FindBy(css = "div.main-container.col2-left-layout span")
    private List<WebElement> myAccount;
    @FindBy(id = "select-language")
    private List<WebElement> myLanguage;


    public void clicksetLanguage() {
        language.click();
    }

    public void setLanguage(String languageText) {
        language.sendKeys(languageText);
        language.click();
    }

    public boolean setMyAccount() {
        for (WebElement acc : myAccount) {
            if (acc.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public boolean setMyLanguage() {
        for (WebElement languageElement : myLanguage) {
            if (languageElement.isDisplayed()) {
                return true;
            }
        }
        return false;
    }
}





