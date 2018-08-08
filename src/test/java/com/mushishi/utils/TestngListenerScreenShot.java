package com.mushishi.utils;


import com.mushishi.selenium.baseDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;;

public class TestngListenerScreenShot extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult iTestResult) {

        super.onTestFailure(iTestResult);
        takeScreenShot(iTestResult);
    }
    private void takeScreenShot(ITestResult iTestResult){
       baseDriver b = (baseDriver) iTestResult.getInstance();
       System.out.println("执行失败的监听！！！！！");
       b.takeScreenShot();

    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        super.onStart(iTestContext);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        super.onTestFailedButWithinSuccessPercentage(iTestResult);
    }
}
