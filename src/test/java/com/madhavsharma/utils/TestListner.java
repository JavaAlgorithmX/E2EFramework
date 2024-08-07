package com.madhavsharma.utils;

import com.madhavsharma.tests.Base;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListner extends Base implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Inside listner");
        System.out.println(result.getTestName());
        System.out.println(result.getName());
        takeScreenshot("screenshots/"+result.getName()+".png");
    }
}
