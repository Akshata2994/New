package Listeners;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener  {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	    System.out.println("*********Test Started*********" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********Test Successful*********" + result.getName());
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********Test Failed*********" + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********Test Skipped*********" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********Test Failed but within pass percentage*********" + result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********Test Failed with Timeout*********" + result.getName());
	}	

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("*********Test Started after Object created*********" + context.getName());
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("*********Test Finished*********" + context.getName());
	}

}
