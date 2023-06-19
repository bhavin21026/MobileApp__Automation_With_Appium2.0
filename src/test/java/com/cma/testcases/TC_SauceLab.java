package com.cma.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cma.driver.Driver;
import com.cma.pages.LoginPage;
import com.cma.pages.ProjectsPage;
import com.cma.pages.TaskPage;

public class TC_SauceLab extends BaseTest {
	
	
	
	
	
	@Test(priority=1,dataProvider = "dataprovider1",enabled=true)
	public void SauceLab_POC(Object obj1,Method method) throws InterruptedException, IOException
	
	{
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		Driver.initDriver(testData.get("device"), testData.get("os_version"),method);

		new LoginPage()
		.doLogin("automation.shaip+collectb@shaip.com", "Test@123");
		new ProjectsPage()
		.clickOnAgree();
		/*.searchToProject();
		new TaskPage()
		.clickOnAddTaskButton();*/
		//.uploadAudioFile();
		
		
	   
		
	}
	
	
	
	@DataProvider(name = "dataprovider1")
	public Object[][] getTestData1() throws IOException {

		return getData("iteration1");
	}
	
}
