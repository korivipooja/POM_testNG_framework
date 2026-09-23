package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverManager;
import utils.Screenshot;
import utils.configReader;


public class LoginTest extends BaseTest{

    @Test(dataProvider = "loginData",dataProviderClass = TestDataProvider.class)
    public void loginTest(String username, String password){
        System.out.println("username:"+username);
        System.out.println("password:"+password);
       LoginPage loginPage= new LoginPage(DriverManager.getDriver());
       loginPage.login(username,password);
       Screenshot.takeScreenshot("Login"+username);
//        loginPage.login(configReader.getProperty("username"));
//        Screenshot.takeScreenshot("Entered user name");

    }

}
