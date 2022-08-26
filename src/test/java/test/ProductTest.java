package test;

import org.junit.Test;

public class ProductTest extends BaseTest{

    @Test
    public void chooseCategoryTest(){
        productPage.hoverOverCategoryTest();
    }

    @Test
    public void selectPosition(){
        productPage.selectfromDropDownSortByPosition();
    }

}
