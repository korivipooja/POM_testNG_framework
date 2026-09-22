package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverManager;
import utils.Screenshot;
import utils.configReader;

import javax.swing.*;


public class LoginTest extends BaseTest{
    @Test
    public void validLoginTest(){
        LoginPage loginPage= new LoginPage(DriverManager.getDriver());
        loginPage.login(configReader.getProperty("username"));
        Screenshot.takeScreenshot("Entered user name");
    }

}
