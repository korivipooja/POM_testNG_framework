package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
        private static ExtentReports extent;
        private static ExtentTest test;

        public static void startReport() {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("target/ExtentReport.html");

            spark.config().setReportName("Selenium Automation Report");
            spark.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "OS",
                    System.getProperty("os.name")
            );

            extent.setSystemInfo(
                    "Java Version",
                    System.getProperty("java.version")
            );
        }

        public static void createTest(String testName) {

            test = extent.createTest(testName);
        }

        public static ExtentTest getTest() {

            return test;
        }

        public static void flushReport() {

            extent.flush();
        }
    }


