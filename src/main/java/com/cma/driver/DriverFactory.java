package com.cma.driver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import com.cma.exception.FrameworkException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public final class DriverFactory {

    private DriverFactory(){}


    public static AndroidDriver<AndroidElement> get(Modes mode,String device,String os,Method method) throws MalformedURLException {
    	AndroidDriver<AndroidElement> driver = null;

        if(mode.equals(Modes.LOCAL)){
             driver = new LocalDriverImpl().getDriver(device, os,method);
        }
        else if(mode.equals(Modes.BS)){
        	 driver = new BrowserStackImpl().getDriver(device, os,method);
        }
        else if(mode.equals(Modes.SAUCELABS)){
       	 driver = new SauceLabImpl().getDriver(device, os,method);
       }else if(mode.equals(Modes.LAMBDA)){
         	 driver = new LamdaImpl().getDriver(device, os,method);
         }
        else{
            throw new FrameworkException("No cloud provider with the name you mentioned is configured");
        }

        return driver;
    }
}
