package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By username= By.id("user-name");

    public LoginPage(WebDriver driver){
        this.driver= driver;
    }

    public void enterUsername(String usernameValue){
        driver.findElement(username).sendKeys(usernameValue);
    }

    public void login(String usernameValue){
        enterUsername(usernameValue);
    }
}
