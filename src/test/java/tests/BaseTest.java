package tests;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.DriverManager;
import utils.ExtentReportManager;
import utils.Screenshot;
import utils.configReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    @BeforeSuite
    public void startReport(){
        ExtentReportManager.startReport();
    }

    @BeforeMethod
    public void setUp(Method method) throws IOException {

        configReader.loadProperties();
        DriverManager.initializeDriver();
        DriverManager.getDriver()
                .get(configReader.getProperty("url"));
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(driver -> driver.getTitle() !=null && !driver.getTitle().isEmpty());
        ExtentReportManager.createTest(method.getName());

    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            ExtentReportManager.getTest().pass("Test passed successfully");
        }
        else if(result.getStatus()== ITestResult.FAILURE){
            ExtentReportManager.getTest().fail(result.getThrowable());
           String screenshotpath= Screenshot.takeScreenshot(result.getName()+"FAILED");
            if(screenshotpath!=null){
                ExtentReportManager.getTest().fail("Failure Scrrenshot", MediaEntityBuilder
                        .createScreenCaptureFromPath(screenshotpath).build());
            }
        }
        else if(result.getStatus()==ITestResult.SKIP){
            ExtentReportManager.getTest().skip("Test skipped");
        }
        DriverManager.quitDriver();
    }

    @AfterSuite
    public void endReport(){
        //This saves the final html report
        ExtentReportManager.flushReport();
    }
}
