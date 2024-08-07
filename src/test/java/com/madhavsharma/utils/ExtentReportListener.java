package com.madhavsharma.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.madhavsharma.tests.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extentReports;
    private static ExtentTest test;
    private static WebDriver driver;

    @Override
    public void onStart(ITestContext context) {
        // Create timestamp
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        // Additional report configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/SparkReport_"+timestamp+".html");
        extentReports = new ExtentReports();
        spark.config().setReportName("Test Automation Report");
        spark.config().setDocumentTitle("Test Execution Report");
        extentReports.attachReporter(spark);
        // Add system-wide or custom information
//        extentReports.setSystemInfo("Tester", System.getProperty("testerName", "Unknown Tester"));
        extentReports.setSystemInfo("Tester", "Madhav Sharma");
        extentReports.setSystemInfo("Environment","SIT");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("OS", "Windows");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test failed");
        test.fail(result.getThrowable());
        test.addScreenCaptureFromBase64String(getScreenshot());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    // Method to capture screenshots
    private String getScreenshot() {
        if (driver instanceof TakesScreenshot) {
            String screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//            try {
//                FileUtils.copyFile(screenshotFile, new File(filePath));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            return screenshotAs;
        }
        return null;
    }
    // Method to set WebDriver instance (to be called in your tests setup)
    public static void setDriver(WebDriver driver) {
        ExtentReportListener.driver = driver;
    }
}
