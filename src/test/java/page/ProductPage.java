package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(css = "li.level0.nav-6 a.level0")
    private WebElement fildVip;
    @FindBy(css = "li.item.last:nth-last-of-type(2) div.product-info h2.product-name a")
    private WebElement productVase;
    @FindBy(id = "swatch20")
    private WebElement productcolor;
    @FindBy(css="li.level0.nav-1.first.parent > a")
    private WebElement womenCategory;
    @FindBy (css="li.level1.view-all > a")
    private WebElement viewAllElements;
    @FindBy(css="li.level0.nav-5.parent a.level0.has-children")
    private WebElement elementSelect;
    @FindBy(css=".sort-by select ")
    private WebElement sortBySelect;

    //wishlist
    @FindBy(css="li.level0.nav-5.parent")
    private WebElement newElementSelect;
    @FindBy(css="a.link-wishlist")
    private WebElement newElementWishListBTN;
    @FindBy(css=".my-wishlist span")
    private WebElement wishListMsg;

    @FindBy(css="li.level0.nav-1.first.parent")
    private WebElement womenDress;
    @FindBy(css="li.level1.nav-1-4.last a")
    private WebElement dresses;
    @FindBy(css="li.item.last:nth-child(3)")
    private WebElement elementDress;
    @FindBy(css="a.link-wishlist")
    private WebElement clickWishListBTNforElementDress;
    @FindBy(css=".page-title h1")
    private WebElement wishListAddMsg;


    public void setQtyField(int quantity) {
        qtyField.clear();
        qtyField.sendKeys(quantity + "");
    }
    public void clickAddToCartButton() {
        addToCartButton.click();
    }
    public void selectProductVase() {
        fildVip.click();
        productVase.click();
        productcolor.click();
    }
    public void selectfromDropDownSortByPosition(){
        elementSelect.click();
        sortBySelect.click();
    }

    public void setNewElementSelect(){
        newElementSelect.click();
    }
    public void setNewElementWishListBTN(){
        newElementWishListBTN.click();
    }
    public String setWishListMsg(){
       return wishListMsg.getText();
    }

    public void hoverOverCategoryTest(){
        Actions action = new Actions(driver);
        action.moveToElement(womenCategory).perform();
        viewAllElements.click();
    }
    public void addElementToWishList() {
        Actions action = new Actions(driver);
        action.moveToElement(womenDress).perform();
        dresses.click();
        elementDress.click();
        clickWishListBTNforElementDress.click();
    }
    public String setAddToWishListMsg(){
        return wishListAddMsg.getText();
    }

}
