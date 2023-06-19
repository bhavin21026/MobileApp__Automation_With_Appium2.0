package com.cma.driver;
import static com.cma.driver.DriverManager.getDriver;
import static com.cma.driver.DriverManager.unload;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.cma.constants.FrameworkConstants;
import com.cma.pages.TaskPage;
import com.cma.utils.Fileutils;
import com.cma.utils.PropertyUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public final class Driver {

    private Driver(){}

    public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	
	public static void initDriver(String device, String os,Method method) throws MalformedURLException {
        if(isNull(getDriver())) {
            String modevalue = PropertyUtils.getValue("mode");
            driver = DriverFactory.get(Modes.valueOf(modevalue.toUpperCase()),device,os,method);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            DriverManager.setDriver(driver);
            try {
				TaskPage.pushFilesToEmulator();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
   
	public static AppiumDriverLocalService startServer() {
		//
		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
			System.out.println("Server start");
		}
		return service;

	}
    
    public static void stopServer() {
		//
		boolean flag = checkIfServerIsRunnning(4723);
		
		if (flag) {

			service.stop();
		}

	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static void startEmulator() throws IOException, InterruptedException {

		Runtime.getRuntime().exec(FrameworkConstants.getServerBatFilePath());
		Thread.sleep(6000);
	}
	
	public static void startEmulatorCMD(String deviceEmulator) throws IOException, InterruptedException {
		
		String command="cd C:\\Users\\BHavin Sangani\\AppData\\Local\\Android\\Sdk\\emulator\n"
				+ "emulator -avd "+ deviceEmulator;
		
		Fileutils.createFile();
		Fileutils.writeFile(command);
		Runtime.getRuntime().exec(FrameworkConstants.getRunEmulatorPath());
		Thread.sleep(6000);
	}
    
    

    public static void quitDriver(){
        if(nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }

    }
    
    public static void killAllNodes() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(2000);
		
	}
    


}
