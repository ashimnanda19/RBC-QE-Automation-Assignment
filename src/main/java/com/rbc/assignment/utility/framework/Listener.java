package com.rbc.assignment.utility.framework;
import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;		


public class Listener extends BaseTestScript implements  ITestListener  	 {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("************************   Started Method" + result.getName()+ "  ***********************************");
	}

	public void onTestSuccess(ITestResult result) {
		seTakeScreeshot();
		Log.info("Test Case method "+result.getName()+" Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		seTakeScreeshot();
		Log.info("Test Case method "+result.getName()+" Failed");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		Log.info("Test Case method "+result.getName()+" Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {

		Log.info("************************   Started" + context.getName()+ "  ***********************************");

		
	}

	public void onFinish(ITestContext context) {
		
		Log.info("************************   END" + context.getName()+ "  ***********************************");
		
	}

}
