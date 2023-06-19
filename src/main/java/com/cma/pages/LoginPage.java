package com.cma.pages;
import org.openqa.selenium.support.PageFactory;

import com.cma.driver.DriverManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends ActionClass {

    //Page Factory
    //By locators
    //String locators

    @AndroidFindBy(xpath = "//android.widget.ImageView[@text='Email Address *']")
    @iOSXCUITFindBy(accessibility = "Views")
    private MobileElement txt_userName;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@text='Password *']")
    private AndroidElement txt_password;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Sign In']")
    @iOSXCUITFindBy(accessibility = "Views")
    private AndroidElement btn_login;
    

    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()),this);
    }

    public LoginPage enterUserName(String value){
    	
    	txt_userName.clear();
        click(txt_userName,"UserName");
        sendKeys(txt_userName,"UserName",value);
        return new LoginPage();
    }
    
    public LoginPage enterPassword(String value){
    	
    	txt_password.clear();
        click(txt_password,"Password");
        sendKeys(txt_password,"Password",value);

        return new LoginPage();
    }
    
    public LoginPage clickOnLogin(){
        click(btn_login,"LoginButton");

        return new LoginPage();
    }

    
    public LoginPage doLogin(String userName,String Password)
    {
    	//enterUserName(userName);
    	//enterPassword(Password);
    	clickOnLogin();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new LoginPage();

    	
    	
    }
    
    public boolean isSignInPageOpen() {

		WaitForElementToBeVisible(txt_userName);

		return txt_userName.isDisplayed();
	}



}
