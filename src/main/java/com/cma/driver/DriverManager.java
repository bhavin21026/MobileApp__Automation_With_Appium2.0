package com.cma.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public final class DriverManager {

    private DriverManager(){}

    private static ThreadLocal<AndroidDriver<AndroidElement>> threadLocalDriver = new ThreadLocal<AndroidDriver<AndroidElement>>();

    public static AndroidDriver<AndroidElement> getDriver(){
        return threadLocalDriver.get();
    }
    public static void setDriver(AndroidDriver<AndroidElement> driver){
        threadLocalDriver.set(driver);
    }

    public static void unload(){
        threadLocalDriver.remove();
    }

}
