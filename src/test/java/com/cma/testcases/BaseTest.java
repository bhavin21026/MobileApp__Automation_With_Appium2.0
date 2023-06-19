package com.cma.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.cma.driver.Driver;
import com.cma.utils.PropertyUtils;

public class BaseTest extends TestCommons {

	String modevalue = PropertyUtils.getValue("mode");

	@BeforeMethod(alwaysRun = true)

	public void setUpTest() throws IOException, InterruptedException {

		if (modevalue.equalsIgnoreCase("LOCAL")) {
			Driver.killAllNodes();
			Driver.startServer();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownTest() {

		Driver.quitDriver();
		/* (modevalue.equalsIgnoreCase("LOCAL")) {
			Driver.stopServer();
		}*/
	}

}
