package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Screenshot {
    public static String takeScreenshot(String filename){
        TakesScreenshot screenshot= (TakesScreenshot) DriverManager.getDriver();
        File source= screenshot.getScreenshotAs(OutputType.FILE);
        Path destination= Path.of("screenshot/" + filename + ".png");
       // source.renameTo(destination);
        try {
            Files.createDirectories(destination.getParent());
            Files.copy(source.toPath(), destination);

            System.out.println("Screenshot saved" + destination.toAbsolutePath());
            return destination.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
