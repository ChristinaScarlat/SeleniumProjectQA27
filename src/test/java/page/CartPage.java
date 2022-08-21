package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".success-msg span")
    private WebElement successMessageSpan;

    @FindBy(css = ".qty[name*='cart']")
    private WebElement qtyField;

    public String getSuccessMessageSpan(){
        return successMessageSpan.getText();
    }

    public String getQtyField(){
        return qtyField.getAttribute("value");
    }

   @FindBy(css="div.header-minicart span.label")
   private WebElement cartButton;
    public void CartButton(){cartButton.click();}
    @FindBy(css="a.cart-link")
    private WebElement viewCart;
    public void setViewCart(){viewCart.click();}

    @FindBy(css="td.a-center.product-cart-remove.last a")
    private WebElement removeBTN;
    public void setRemoveBTN(){

        removeBTN.click();}

    @FindBy(id="empty_cart_button")
    WebElement emptyCartBTN;

    public void getEmptyCartButton(){
        emptyCartBTN.click();
    }

    @FindBy(css="li button.button.btn-proceed-checkout.btn-checkout")
    WebElement proceedToCheckOutButton;

    public void clickProceedToCheckOutButton(){
        proceedToCheckOutButton.click();
    }
    @FindBy(id="login:register")
    WebElement registerForCheckOut;
    public void checkOutwithRegister(){
        registerForCheckOut.click();
    }
    @FindBy(id="onepage-guest-register-button")
    WebElement BTNcontinueCheckOutRegister;
    public void continueBTNCheckOutRegister(){
        BTNcontinueCheckOutRegister.click();
    }



    //id = "shopping-cart-table "
   @FindBy(className = "cart-table data-table")
    private List<WebElement> cartProducts;

    public void removeFromCartButton(String nameProduct){

        for (WebElement element : cartProducts){
            if(element.getText().contains(nameProduct))
           // element.sendKeys(nameProduct);
            removeBTN.click();}

    }
// driver.findElement(By.cssSelector("td.a-center.product-cart-remove.last a")).click();
//    WebElement removeICart = driver.findElement(By.cssSelector(".page-title h1"));
//        Assert.assertEquals("SHOPPING CART IS EMPTY", removeICart.getText());





}
