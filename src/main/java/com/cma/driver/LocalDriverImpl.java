package com.cma.driver;

import static com.cma.constants.FrameworkConstants.getApkFilePath;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.cma.utils.PropertyUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class LocalDriverImpl implements IDriver{
	
    public AndroidDriver<AndroidElement> getDriver(String device,String os,Method method) throws MalformedURLException
    
    {
    	//String DeviceName= PropertyUtils.getValue(device);
    	
    	 try {
			Driver.startEmulatorCMD(device);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File appDir = new File(getApkFilePath());
		File app = new File(appDir, "workforce-automation.apk");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,30);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //capabilities.setCapability("autoGrantPermissions", "true");

        //capabilities.setCapability("unlockType","pin");
        //capabilities.setCapability("unlockKey","963852");
        return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

	
	
}
