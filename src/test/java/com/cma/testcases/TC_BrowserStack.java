package com.cma.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cma.driver.Driver;
import com.cma.driver.DriverManager;
import com.cma.pages.LoginPage;
import com.cma.pages.ProjectsPage;
import com.cma.pages.RegistrationPage;
import com.cma.pages.TaskPage;

import io.appium.java_client.android.AndroidElement;

import com.cma.annotations.FrameworkAnnotation;
import com.cma.enums.CategoryType;
import com.cma.enums.PortalType;
import com.cma.enums.story;

public class TC_BrowserStack extends BaseTest {

	JavascriptExecutor jse;

	@Test(priority = 1, dataProvider = "dataprovider2", enabled = false,groups = {"Smoke","SIT"})
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})

	public void Registration_POC(Object obj1, Method method) throws InterruptedException, IOException

	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		Driver.initDriver(testData.get("device"), testData.get("os_version"), method);

		setupExtentReport("CP: Verify user Registration on device ("+testData.get("device")+")'", method.getName(),"Bhavin Sangani");
		boolean mailSent = new RegistrationPage().doRegistration("Test", "Auto").isMailSent();
		jse = (JavascriptExecutor) DriverManager.getDriver();
		if (mailSent) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"SignUp Successfull!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"SignUp Failed\"}}");
		}
	}

	@Test(priority = 2, dataProvider = "dataprovider2", enabled = true,groups = {"Smoke","SIT"})
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})
	public void LoginSuccessfull_POC(Object obj1, Method method) throws InterruptedException, IOException

	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		Driver.initDriver(testData.get("device"), testData.get("os_version"), method);
		setupExtentReport("CP: Verify user Positive login on device ("+testData.get("device")+")", method.getName(),"Bhavin Sangani");

		new LoginPage().doLogin("automation.shaip+collectb@shaip.com", "Test@123");

		Boolean isDisplayed = new ProjectsPage().isAgreementDisplayed();
		jse = (JavascriptExecutor) DriverManager.getDriver();
		if (isDisplayed) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Login Successfull!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Login Failed\"}}");
		}

	}

	@Test(priority = 3, dataProvider = "dataprovider2", enabled = false,groups = {"Smoke","SIT"})
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})
	public void VerifyAgrrement(Object obj1, Method method) throws InterruptedException, IOException

	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		Driver.initDriver(testData.get("device"), testData.get("os_version"), method);
		setupExtentReport("CP: Verify user Agree button functionality ("+testData.get("device")+")", method.getName(),"Bhavin Sangani");

		new LoginPage().doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage().clickOnAgree();

		List<AndroidElement> tasks = DriverManager.getDriver()
				.findElements(By.xpath("//android.widget.ImageView[@content-desc='Tasks']"));
		int count = tasks.size();
		jse = (JavascriptExecutor) DriverManager.getDriver();
		if (count > 0) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Agree Button Clicked  Successfull!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Agree Button Clicked Failed\"}}");
		}

	}

	@Test(priority = 4, dataProvider = "dataprovider2", enabled = false,groups = {"Smoke","SIT"})
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})
	public void VerifyDisAgrrement(Object obj1, Method method) throws InterruptedException, IOException

	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		Driver.initDriver(testData.get("device"), testData.get("os_version"), method);
		setupExtentReport("CP: Verify user DisAgree button functionality ("+testData.get("device")+")", method.getName(),"Bhavin Sangani");

		new LoginPage().doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage().clickOnDisAgree();
		boolean signUpLinkVisible = new RegistrationPage().isSignUpLinkVisible();
		jse = (JavascriptExecutor) DriverManager.getDriver();
		if (signUpLinkVisible) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"DisAgree Button Clicked  Successfull!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"DisAgree Button Clicked Failed\"}}");
		}

	}

	@Test(priority = 5, dataProvider = "dataprovider2", enabled = false,groups = {"Smoke","SIT"})
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})
	public void VerifySearchProject(Object obj1, Method method) throws InterruptedException, IOException

	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		Driver.initDriver(testData.get("device"), testData.get("os_version"), method);
		setupExtentReport("CP: Verify user Search Project functionality ("+testData.get("device")+")", method.getName(),"Bhavin Sangani");

		new LoginPage().doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage().clickOnAgree().searchToProject();
		boolean taskButtonDisplayed = new TaskPage().isAddTaskButtonDisplayed();
		jse = (JavascriptExecutor) DriverManager.getDriver();
		if (taskButtonDisplayed) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Project Search  Successfull!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Project Search Failed\"}}");
		}

	}

	@Test(priority = 6, dataProvider = "dataprovider2", enabled = false,groups = {"Smoke","SIT"})
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})
	public void VerifyGetTaskFunctionality(Object obj1, Method method) throws InterruptedException, IOException

	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		Driver.initDriver(testData.get("device"), testData.get("os_version"), method);
		setupExtentReport("CP: Verify user Get Task functionality ("+testData.get("device")+")", method.getName(),"Bhavin Sangani");

		new LoginPage().doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage().clickOnAgree().searchToProject();
		new TaskPage().clickOnAddTaskButton();
		List<AndroidElement> button = DriverManager.getDriver()
				.findElements(By.xpath("//android.view.View[@content-desc='addtask']"));
		int count = button.size();
		jse = (JavascriptExecutor) DriverManager.getDriver();
		if (count == 0) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Get Task  Successfull!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Get Task Failed\"}}");
		}

	}

	@Test(priority = 7, dataProvider = "dataprovider2", enabled = false,groups = {"Smoke","SIT"})
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})
	public void VerifyUploadFileFunctionality(Object obj1, Method method) throws InterruptedException, IOException

	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		Driver.initDriver(testData.get("device"), testData.get("os_version"), method);
		setupExtentReport("CP: Verify user Upload Files functionality ("+testData.get("device")+")", method.getName(),"Bhavin Sangani");

		new LoginPage().doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage().clickOnAgree().searchToProject();
		boolean audioContainerVisible = new TaskPage().clickOnAddTaskButton().justUploadAudioFile()
				.isAudioContainerVisible();
		jse = (JavascriptExecutor) DriverManager.getDriver();
		if (audioContainerVisible) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Audio Upload Successfull!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Audio Upload  Failed\"}}");
		}
	}

	@Test(priority = 8, dataProvider = "dataprovider2", enabled = false,groups = {"Smoke","SIT"})
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})
	public void LoginFailed_POC(Object obj1, Method method) throws InterruptedException, IOException

	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		Driver.initDriver(testData.get("device"), testData.get("os_version"), method);
		setupExtentReport("CP: Verify user Negative Login functionality ("+testData.get("device")+")", method.getName(),"Bhavin Sangani");

		boolean signInPageOpen = new LoginPage().doLogin("automation.shaip11+collectb@shaip.com", "Test@123")
				.isSignInPageOpen();
		jse = (JavascriptExecutor) DriverManager.getDriver();
		if (signInPageOpen) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Negative signIN Scenario Successfull!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Negative signIN Scenario Failed\"}}");
		}
	}

	@Test(priority = 9, dataProvider = "dataprovider2", enabled = false,groups = {"Smoke","SIT"})
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})
	public void VerifySaveButtonFunctionality(Object obj1, Method method) throws InterruptedException, IOException

	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		Driver.initDriver(testData.get("device"), testData.get("os_version"), method);
		setupExtentReport("CP: Verify Pause Task functionality ("+testData.get("device")+")", method.getName(),"Bhavin Sangani");

		new LoginPage().doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage().clickOnAgree().searchToProject();
		new TaskPage().clickOnAddTaskButton().PauseTask();
		boolean taskButtonDisplayed = new TaskPage().isAddTaskButtonDisplayed();
		jse = (JavascriptExecutor) DriverManager.getDriver();
		if (taskButtonDisplayed) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Project Search  Successfull!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Project Search Failed\"}}");
		}
	}

	@DataProvider(name = "dataprovider2")
	public Object[][] getTestData2() throws IOException {

		return getData("iteration3.1");
	}

}
