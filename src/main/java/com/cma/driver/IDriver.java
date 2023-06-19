package com.cma.driver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public interface IDriver {
    //interfaces gives you skeleton.    
    public WebDriver getDriver(String deviceName,String osName,Method method) throws MalformedURLException;

}
