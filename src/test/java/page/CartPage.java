package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".success-msg span")
    private WebElement successMessageSpan;
    @FindBy(css = ".qty[name*='cart']")
    private WebElement qtyField;
    @FindBy(css = "div.header-minicart span.label")
    private WebElement cartButton;
    @FindBy(css = "a.cart-link")
    private WebElement viewCart;
    @FindBy(css = "td.a-center.product-cart-remove.last a")
    private WebElement removeBTN;
    @FindBy(id = "empty_cart_button")
    WebElement emptyCartBTN;
    @FindBy(css = "li button.button.btn-proceed-checkout.btn-checkout")
    WebElement proceedToCheckOutButton;
    @FindBy(id = "login:register")
    WebElement registerForCheckOut;
    @FindBy(id = "onepage-guest-register-button")
    WebElement BTNcontinueCheckOutRegister;
    @FindBy(css = ".cart-table.data-table tbody tr")
    private List<WebElement> cartProducts;
    @FindBy(css="div h1")
    private WebElement emptyCartMessage;
    @FindBy(css="#checkout-step-login h3")
    private WebElement chechoutMessage;

    public String getSuccessMessageSpan() {
        return successMessageSpan.getText();
    }

    public String getQtyField() {
        return qtyField.getAttribute("value");
    }
    public void CartButton() {
        cartButton.click();
    }
    public void setViewCart() {
        viewCart.click();
    }
    public void setRemoveBTN() {
        removeBTN.click();
    }
    public void getEmptyCartButton() {
        emptyCartBTN.click();
    }
    public void clickProceedToCheckOutButton() {
        proceedToCheckOutButton.click();
    }

    public void checkOutwithRegister() {
        registerForCheckOut.click();
    }
    public void continueBTNCheckOutRegister() {
        BTNcontinueCheckOutRegister.click();
    }
    //id = "shopping-cart-table "
    public boolean removeFromCartButton(String nameProduct) {
     for (WebElement element : cartProducts) {
            if (element.getText().contains(nameProduct)) {
                element.findElement(By.cssSelector("td.a-center.product-cart-remove.last a")).click();
                return true;
            }
        }
        return false;
    }
    public String getEmptyCartMessage() {
        return emptyCartMessage.getText();
    }
    public String getCheckoutMessage(){
        return chechoutMessage.getText();
    }

}
