package tests;

import org.openqa.selenium.devtools.v137.network.model.DataReceived;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverManager;

public class CartTest extends BaseTest{

    @Test(dataProvider = "checkoutData",dataProviderClass = TestDataProvider.class,groups={"smoke,regression"})

    public void addProductToCartTest(String username,String password,String firstname,String lastname,String zipcode){
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        loginPage.login(username,password);

        ProductsPage productsPage= new ProductsPage(DriverManager.getDriver());
        Assert.assertTrue(productsPage.isProductPageDisplayed(),"Product page is not displayed");
        productsPage.addBackpackToCart();
        productsPage.setClickCart();

        CartPage cartPage= new CartPage(DriverManager.getDriver());
        Assert.assertTrue(cartPage.isBackpackDisplayed(),"Backpack is not displayed in cart");
        cartPage.clickCheckout();

        //Checkout

        CheckoutPage checkoutPage= new CheckoutPage(DriverManager.getDriver());
        Assert.assertTrue(checkoutPage.isCheckoutPageTitle(),"In checkout page");
        checkoutPage.fillCheckoutForm(firstname,lastname,zipcode);
        checkoutPage.clickContinue();
        checkoutPage.clickFinishButton();
        Assert.assertTrue(checkoutPage.isOrderCompleted(),"Order not completed");





    }
}
