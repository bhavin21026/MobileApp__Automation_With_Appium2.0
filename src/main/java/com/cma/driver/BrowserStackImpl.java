package com.cma.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserStackImpl implements IDriver{
	
  

	@Override
	public AndroidDriver<AndroidElement> getDriver(String DeviceName,String OS,Method method) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
        //map.forEach(capabilities::setCapability);//it reads all the key value from map and store it in capabilities
		capabilities.setCapability("browserstack.user", "bhavinsangani_1Wh0Dm");
		capabilities.setCapability("browserstack.key", "xhsc4DswosW7ZjRs4SPF");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "bs://591c22008458f5a659b32889803d8e69e17fb06a" );
        //capabilities.setCapability("automationName", "flutter");
        capabilities.setCapability("device", DeviceName);
        capabilities.setCapability("os_version", OS);
        capabilities.setCapability("project", "Shaip-CMA");
        capabilities.setCapability("build", "Java Android demo POC");
        capabilities.setCapability("name", method.getName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        //capabilities.setCapability("autoGrantPermissions", "true");

        //capabilities.asMap().forEach((k,v)-> System.out.println(k+":"+v));
        return new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"),capabilities);
	}

	
}
