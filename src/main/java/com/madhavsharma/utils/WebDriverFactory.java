package com.madhavsharma.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverFactory {

    public static WebDriver createDriver() {
        return new ChromeDriver();
    }

}
