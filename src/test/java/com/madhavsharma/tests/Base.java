package com.madhavsharma.tests;

import com.madhavsharma.utils.ExtentReportListener;
import com.madhavsharma.utils.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Base {
    protected static WebDriver driver;
    @BeforeSuite
    public void setUp(){
        System.out.println("before suite");
        driver = WebDriverFactory.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        ExtentReportListener.setDriver(driver);
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    protected void takeScreenshot(String filePath) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
