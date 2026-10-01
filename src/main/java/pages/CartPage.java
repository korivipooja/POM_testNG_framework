package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger logger= LogManager.getLogger(CartPage.class);

    private By backProductName= By.className("inventory_item_name");
    private By checkOutButton= By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isBackpackDisplayed(){
        logger.info("Verifying Sauce Labs Backpack is displayed in cart");
        WebElement product= wait.until(ExpectedConditions.visibilityOfElementLocated(backProductName));
        return product.isDisplayed();
    }

    public void clickCheckout(){
        logger.info("Clicking Checkout button");
        WebElement checkout= wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        checkout.click();
        logger.info("Checkout page opened");
    }
}
