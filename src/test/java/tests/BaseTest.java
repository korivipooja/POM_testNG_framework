package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;
import utils.configReader;

import java.io.IOException;

public class BaseTest {

    @BeforeMethod
    public void setUp() throws IOException {
        configReader.loadProperties();
        DriverManager.initializeDriver();
        DriverManager.getDriver()
                .get(configReader.getProperty("url"));

    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
