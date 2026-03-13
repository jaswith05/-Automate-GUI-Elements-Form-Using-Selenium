package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();

        System.out.println("TEST FAILED: " + testName);

        BaseTest.takeScreenshot(testName);

    }
}