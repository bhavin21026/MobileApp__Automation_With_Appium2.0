package com.cma.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cma.driver.Driver;
import com.cma.driver.DriverManager;
import com.cma.pages.LoginPage;
import com.cma.pages.ProjectsPage;
import com.cma.pages.RegistrationPage;
import com.cma.pages.TaskPage;

public class TC_LocalTest extends BaseTest {
	
	
	
	@Test(groups = {"Smoke","SIT"},enabled=true,priority=1)
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})

	public void LoginSuccessfull1_POC(Method method) throws InterruptedException, IOException

	{
		Driver.initDriver("bhavinEmulator", "9.0", method);

		setupExtentReport("CP: Verify user is able to 'Login'", method.getName(),"Bhavin Sangani");

		new LoginPage().doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		
		Boolean isDisplayed = new ProjectsPage().isAgreementDisplayed();
		//JavascriptExecutor jse = (JavascriptExecutor)DriverManager.getDriver();
		
		assertTrue(true);

		/*if (isDisplayed) {
			
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Login Successfull!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Login Failed\"}}");
		}*/

	}
	
	@Test(groups = {"Functional","SIT"},enabled=true,priority=2)
	@com.cma.annotations.FrameworkAnnotation(category= {com.cma.enums.CategoryType.SIT,com.cma.enums.CategoryType.SMOKE},storyId= {com.cma.enums.story.Login_Logout_CP_SC2_27_28},portal= {com.cma.enums.PortalType.CP})

	public void LoginSuccessfull2_POC(Method method) throws InterruptedException, IOException

	{
		Driver.initDriver("bhavinEmulator", "11.0", method);

		setupExtentReport("CP: Verify user is able to 'Login again'", method.getName(),"Bhavin Sangani");

		new LoginPage().doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		
		Boolean isDisplayed = new ProjectsPage().isAgreementDisplayed();
		//JavascriptExecutor jse = (JavascriptExecutor)DriverManager.getDriver();
		
		assertTrue(false);

		/*if (isDisplayed) {
			
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Login Failed!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"passed\", \"reason\": \"Login Successfull\"}}");
		}*/

	}
	
	
	
	
	
	
	
	@Test(priority=1,dataProvider = "dataprovider2",enabled=false)
	public void Registration_POC(Object obj1,Method method) throws InterruptedException, IOException
	
	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		Driver.initDriver(testData.get("device"), testData.get("os_version"),method);

		new RegistrationPage()
		.doRegistration("Test", "Auto");
		
	   
		
	}
	
	@Test(priority=2,dataProvider = "dataprovider2",enabled=false)
	public void LoginSuccessfull_POC(Object obj1,Method method) throws InterruptedException, IOException
	
	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		Driver.initDriver(testData.get("device"), testData.get("os_version"),method);

		new LoginPage()
		.doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		
	   
		
	}
	
	@Test(priority=3,dataProvider = "dataprovider2",enabled=false)
	public void VerifyAgrrement(Object obj1,Method method) throws InterruptedException, IOException
	
	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		Driver.initDriver(testData.get("device"), testData.get("os_version"),method);
	
		new LoginPage()
		.doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage()
		.clickOnAgree();
		
	}
	
	
	@Test(priority=4,dataProvider = "dataprovider2",enabled=false)
	public void VerifyDisAgrrement(Object obj1,Method method) throws InterruptedException, IOException
	
	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		Driver.initDriver(testData.get("device"), testData.get("os_version"),method);
	
		new LoginPage()
		.doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage()
		.clickOnDisAgree();
		
	}
	
	@Test(priority=5,dataProvider = "dataprovider2",enabled=false)
	public void VerifySearchProject(Object obj1,Method method) throws InterruptedException, IOException
	
	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		Driver.initDriver(testData.get("device"), testData.get("os_version"),method);
	
		new LoginPage()
		.doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage()
		.clickOnAgree()
		.searchToProject();
		
	}
	
	
	
	@Test(priority=6,dataProvider = "dataprovider2",enabled=false)
	public void VerifyGetTaskFunctionality(Object obj1,Method method) throws InterruptedException, IOException
	
	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		Driver.initDriver(testData.get("device"), testData.get("os_version"),method);

		new LoginPage()
		.doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage()
		.clickOnAgree()
		.searchToProject();
		new TaskPage()
		.clickOnAddTaskButton();
;		
		
	   
		
	}
	
	
	@Test(priority=7,dataProvider = "dataprovider2",enabled=false)
	public void VerifyUploadFileFunctionality(Object obj1,Method method) throws InterruptedException, IOException
	
	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		Driver.initDriver(testData.get("device"), testData.get("os_version"),method);

		new LoginPage()
		.doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage()
		.clickOnAgree()
		.searchToProject();
		new TaskPage()
		.clickOnAddTaskButton()
		.justUploadAudioFile();
		
		
	   
		
	}
	
	
	@Test(priority=2,dataProvider = "dataprovider2",enabled=false)
	public void LoginFailed_POC(Object obj1,Method method) throws InterruptedException, IOException
	
	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		Driver.initDriver(testData.get("device"), testData.get("os_version"),method);

		new LoginPage()
		.doLogin("automation.shaip11+collectb@shaip.com", "Test@123");
		
	   
		
	}
	
	@Test(priority=8,dataProvider = "dataprovider2",enabled=false)
	public void VerifySaveButtonFunctionality(Object obj1,Method method) throws InterruptedException, IOException
	
	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		Driver.initDriver(testData.get("device"), testData.get("os_version"),method);

		new LoginPage()
		.doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage()
		.clickOnAgree()
		.searchToProject();
		new TaskPage()
		.clickOnAddTaskButton()
		.SaveTask();
		
		
	   
		
	}
	
	@DataProvider(name = "dataprovider2")
	public Object[][] getTestData2() throws IOException {

		return getData("iteration4");
	}
	
}
