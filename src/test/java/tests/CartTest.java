package tests;

import org.openqa.selenium.devtools.v137.network.model.DataReceived;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverManager;

public class CartTest extends BaseTest{
    @Test(dataProvider="loginData",dataProviderClass= TestDataProvider.class)

    public void addProductToCartTest(String username,String password){
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        loginPage.login(username,password);

        ProductsPage productsPage= new ProductsPage(DriverManager.getDriver());
        Assert.assertTrue(productsPage.isProductPageDisplayed(),"Product page is not displayed");
        productsPage.addBackpackToCart();
        productsPage.setClickCart();

        CartPage cartPage= new CartPage(DriverManager.getDriver());
        Assert.assertTrue(cartPage.isBackpackDisplayed(),"Backpack is not displayed in cart");





    }
}
