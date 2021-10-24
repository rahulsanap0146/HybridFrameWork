package com.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utility.ScreenshotUtility;

public class ListenerEx extends BaseClass implements ITestListener {

	public static Logger log = Logger.getLogger(ListenerEx.class);
    public static ScreenshotUtility su= new ScreenshotUtility();
	
    
    public void onTestStart(ITestResult result) {
		test= report.createTest(result.getName());
		log.info("Test Case is ready to Execution");

	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test Case is Success " + result.getName());
		test.log(Status.PASS, "Test Case passed successfully");
	}

	public void onTestFailure(ITestResult result) {
		log.info("Test Case is Failed " + result.getName());
		log.info(result.getThrowable());
		test.log(Status.FAIL,"TestCase Failed ");
		test.log(Status.FAIL,result.getThrowable());
		String path= su.takeScreenShot(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {

		log.info("Test Case is Skipped " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		log.info("Test Suite is Ready To Start Execution");

	}

	public void onFinish(ITestContext context) {
		log.info("Test Suite is finished with Execution ");
		report.flush();
	}

}
