package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger logger= LogManager.getLogger(CheckoutPage.class);

    private By checkoutPageTitle = By.className("title");
    private By firstname = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    private By clickFinish= By.id("finish");

    private By orderConfirmation= By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isCheckoutPageTitle() {
        WebElement checkOutPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPageTitle));
        return checkOutPageTitle.isDisplayed();

    }

    public void fillCheckoutForm(String fname, String lname, String zipcode){
        logger.info("Entering customer details");
       wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys(fname);
       wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lname);
       wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).sendKeys(zipcode);
        logger.info("Customer details entered successfully");


    }

    public void clickContinue(){
        logger.info("Clicking Continue button");
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void clickFinishButton(){
        logger.info("Clicking Finish button");

        wait.until(ExpectedConditions.elementToBeClickable((clickFinish))).click();
        logger.info("Finish button clicked");
    }
    public boolean isOrderCompleted(){
        logger.info("Verifying order completion");
        WebElement confirmation= wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmation));
        return confirmation.isDisplayed();
    }

}
