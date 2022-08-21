package page;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "qty")
    private WebElement qtyField;

    @FindBy(css = ".btn-cart[onclick]")
    private WebElement addToCartButton;

    public void setQtyField(int quantity) {
        qtyField.clear();
        qtyField.sendKeys(quantity + "");
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    @FindBy(css = "li.level0.nav-6 a.level0")
    private WebElement fildVip;
    @FindBy(css = "li.item.last:nth-last-of-type(2) div.product-info h2.product-name a")
    private WebElement productVase;
    @FindBy(id = "swatch20")
    private WebElement productcolor;

    public void selectProductVase(){fildVip.click();
    productVase.click();
    productcolor.click();}



//    WebElement addCart = driver.findElement(By.cssSelector("li.success-msg span"));
//        Assert.assertEquals("Modern Murray Ceramic Vase was added to your shopping cart.", addCart.getText());






}
