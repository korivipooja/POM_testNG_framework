package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By backProductName= By.className("inventory_item_name");
    private By checkOutButton= By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isBackpackDisplayed(){
        WebElement product= wait.until(ExpectedConditions.visibilityOfElementLocated(backProductName));
        return product.isDisplayed();
    }

    public void clickCheckout(){
        WebElement checkout= wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        checkout.click();
    }
}
