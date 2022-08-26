package test;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest extends BaseTest{

    @Test
    public void changeLanguageTest(){
//        select-language
        accountPage.clicksetLanguage();
        accountPage.setLanguage("French");
        wait(2);
        Assert.assertTrue(accountPage.setMyLanguage());

    }

}
