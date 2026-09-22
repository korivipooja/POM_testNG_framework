package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Screenshot {
    public static void takeScreenshot(String filename){
        TakesScreenshot screenshot= (TakesScreenshot) DriverManager.getDriver();
        File source= screenshot.getScreenshotAs(OutputType.FILE);
        File destination= new File("screenshot/" + filename + ".png");
        source.renameTo(destination);

    }
}
