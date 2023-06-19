package com.cma.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SauceLabImpl implements IDriver{
	
	public static final String USERNAME = "oauth-bhavin.s-cf4a7";
    public static final String ACCESS_KEY = "87dcba39-ebc8-47af-9463-cb3ee6253bcb";
    public static final String URL = "https://"+USERNAME+":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    public static final String appName = "workforce-automation.apk";
    
	@Override
	public AndroidDriver<AndroidElement> getDriver(String DeviceName,String OS,Method method) throws MalformedURLException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appium:deviceName", DeviceName);
        capabilities.setCapability("appium:platformVersion", OS);
        capabilities.setCapability("app", "storage:filename=" +appName);
        capabilities.setCapability("newCommandTimeout", 2000);
        capabilities.setCapability("name", method.getName());
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "1.20.2");
       

        return new AndroidDriver<>(new URL(URL), capabilities);
	    
	}

	
}
