package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    private By username = By.id("user-name");
    private By passowrd = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String usernameValue) {
        logger.info("Entering username");

        driver.findElement(username).sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        logger.info("Entering password");
        driver.findElement(passowrd).sendKeys(passwordValue);
    }

    public void cliclLoginButton() {
        logger.info("Clicking login button");
        driver.findElement(loginButton).click();
    }

    public void login(String usernameValue, String passwordValue) {
        logger.info("Starting login");
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        cliclLoginButton();
    }


}
