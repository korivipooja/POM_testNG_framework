package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By username= By.id("user-name");
    private  By passowrd=By.id("password");
    private By loginButton=By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver= driver;
    }

    public void enterUsername(String usernameValue){

        driver.findElement(username).sendKeys(usernameValue);
    }
    public void enterPassword(String passwordValue){
        driver.findElement(passowrd).sendKeys(passwordValue);
    }

    public void cliclLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void login(String usernameValue,String passwordValue){

        enterUsername(usernameValue);
        enterPassword(passwordValue);
        cliclLoginButton();
    }



}
