package com.cma.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class LamdaImpl implements IDriver{
	
	public static final String USERNAME = "bhavin.s";
    public static final String ACCESS_KEY = "Ah2jcEH7JyY0GkxTDjoJfrVaHBNrUK784MbBcnwlYKex405hKg";
    public static final String HUB = "@hub.lambdatest.com/wd/hub";
    public static final String appName = "workforce-automation.apk";
    
   

    
	@Override
	public AndroidDriver<AndroidElement> getDriver(String DeviceName,String OS,Method method) throws MalformedURLException {
		
		
		
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Configure your capabilities here
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", DeviceName);
        capabilities.setCapability("platformVersion",OS);
        //capabilities.setCapability("isRealMobile", false);
        capabilities.setCapability("build", "TestNG With Java");
        capabilities.setCapability("name", "workforce-automation.apk");
        capabilities.setCapability("app", "lt://APP100202491649766093190193"); //Enter your app URL from previous step here
        capabilities.setCapability("deviceOrientation", "PORTRAIT");
        capabilities.setCapability("console", true);
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("devicelog", true);

    

        return new AndroidDriver<AndroidElement>(new URL("https://" + USERNAME + ":" + ACCESS_KEY + HUB), capabilities);
	    
	}

	
}
