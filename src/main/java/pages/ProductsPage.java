package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By productTitle= By.id("item_4_title_link");
    private By addToCart=By.id("add-to-cart-sauce-labs-backpack");
    private By clickIcon=By.id("shopping_cart_container");
    private By cartBadge= By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isProductPageDisplayed(){
        WebElement title= wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        return title.isDisplayed();
    }

    public void addBackpackToCart(){
        WebElement addButton= wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addButton.click();
    }

    public void setClickCart(){
        WebElement badge= wait.until(ExpectedConditions.elementToBeClickable(cartBadge));
        badge.click();
    }
}
