package com.cma.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.cma.constants.FrameworkConstants;
import com.cma.driver.DriverManager;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Fileutils {
	
	
	

	    public static void scrollDown(){
	    	
	    	 Dimension dimension = DriverManager.getDriver().manage().window().getSize();
	         int scrollStart = (int) (dimension.getHeight() * 0.5);
	         int scrollEnd = (int) (dimension.getHeight() * 0.2);

	         new TouchAction((PerformsTouchActions) DriverManager.getDriver())
	                 .press(PointOption.point(0, scrollStart))
	                 .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	                 .moveTo(PointOption.point(0, scrollEnd))
	                 .release().perform();
	    }

	    public static void scrollNClick(By listItems, String Text){
	        boolean flag = false;

	        while(true){
	            for(WebElement el: DriverManager.getDriver().findElements(listItems)){
	                if(el.getAttribute("text").equals(Text)){
	                    el.click();
	                    flag=true;
	                    break;
	                }
	            }
	            if(flag)
	                break;
	            else
	                scrollDown();
	        }
	    }

	    public static void scrollNClick(WebElement el){
	        int retry = 0;
	        while(retry <= 5){
	            try{
	                el.click();
	                break;
	            }catch (org.openqa.selenium.NoSuchElementException e){
	                scrollDown();
	                retry++;
	            }
	        }
	    }

	    public static void scrollIntoView(String Text){
	        //https://developer.android.com/reference/androidx/test/uiautomator/UiSelector


	        String mySelector = "new UiSelector().text(\"" + Text + "\").instance(0)";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + mySelector + ");";
	        ((AndroidDriver<?>) DriverManager.getDriver()).findElementByAndroidUIAutomator(command);

	        /*((AndroidDriver<MobileElement>) AppDriver.getDriver()).findElementByAndroidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Text + "\").instance(0))").click();
	                */
	    }
	
	
	public static void createFile() {
	    try {
	      File myObj = new File(FrameworkConstants.getResourcesPath()+"//runEmulator.bat");
	      
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }

	
	public static void writeFile(String commands) {
	    try {
	      FileWriter myWriter = new FileWriter(FrameworkConstants.getResourcesPath()+"//runEmulator.bat");
	      myWriter.write(commands);
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }

}
