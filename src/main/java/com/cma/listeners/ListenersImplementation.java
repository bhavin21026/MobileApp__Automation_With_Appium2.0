package com.cma.listeners;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.cma.constants.FrameworkConstants;
import com.cma.driver.DriverManager;
import com.cma.reportng.ExtentFactoryShaip;
import com.cma.reportng.ExtentReportngShaip;


public class ListenersImplementation implements ITestListener,ISuiteListener {
	
	
	

	

	public void onTestStart(ITestResult result) {
		
		System.out.println("In listner starts");

	}

	public void onTestSuccess(ITestResult result) {

		ExtentFactoryShaip.addTestDetails(result);
		ExtentFactoryShaip.getTest().log(Status.PASS, MarkupHelper
				.createLabel("Test Case: " + result.getMethod().getMethodName() + " is Passed.", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {

		ExtentFactoryShaip.addTestDetails(result);
		ExtentFactoryShaip.getTest().log(Status.FAIL, MarkupHelper
				.createLabel("Test Case: " + result.getMethod().getMethodName() + " is Failed.", ExtentColor.RED));
	
		ExtentFactoryShaip.getTest().addScreenCaptureFromBase64String(captureScreenshot(result), "Test case failure screenshot");
		///ExtentFactoryShaip.getTest().addScreenCaptureFromPath(screenshotPath,
				//"Test case failure screenshot");	
		System.out.println("Screenshot captured");
		ExtentFactoryShaip.getTest().log(Status.FAIL, result.getThrowable());
		

	}

	private String captureScreenshot(ITestResult result) {
		// TODO Auto-generated method stub

		File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = null;
		try {
			fileContent = FileUtils.readFileToByteArray(src);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		    String Base64StringofScreenshot = "data:image/png;base64,"+Base64.getEncoder().encodeToString(fileContent);

		String testcaseName = result.getMethod().getMethodName();

		String screenshotPath =FrameworkConstants.getScreenShotPath()+testcaseName+".jpeg";

		File dest = new File(screenshotPath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Base64StringofScreenshot;
	}

	public void onTestSkipped(ITestResult result) {

		ExtentFactoryShaip.getTest().log(Status.SKIP,
				"Test Case: " + result.getMethod().getMethodName() + " is skipped.");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		// close extent

		

		ExtentReportngShaip.flushReports();
	}
	
	
	
	
	

}
