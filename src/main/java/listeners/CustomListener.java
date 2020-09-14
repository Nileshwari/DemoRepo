package main.java.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import test.java.BasePageTest;

public class CustomListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		BasePageTest.takeScreenshot(result.getMethod().getMethodName());
	}
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
	}
	  
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
 
}
