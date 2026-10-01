package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger logger= LogManager.getLogger(ProductsPage.class);

    private By productTitle= By.className("title");
    private By addToCart=By.id("add-to-cart-sauce-labs-backpack");
    private By clickIcon=By.id("shopping_cart_container");
    private By cartBadge= By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isProductPageDisplayed(){
        logger.info("Verifying Products page is displayed");
        WebElement title= wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        return title.isDisplayed();

    }

    public void addBackpackToCart(){
        logger.info("Attempting to add Sauce Labs Backpack to cart");
        WebElement addButton= wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addButton.click();
        logger.info("Sauce Labs Backpack added to cart");
    }

    public void setClickCart(){
        logger.info("Verifying product was added to cart");
        WebElement badge= wait.until(ExpectedConditions.elementToBeClickable(cartBadge));
        badge.click();

    }
}
