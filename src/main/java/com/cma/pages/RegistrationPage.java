package com.cma.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.PageFactory;

import com.cma.driver.DriverManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RegistrationPage extends ActionClass {

	// Page Factory
	// By locators
	// String locators

	public RegistrationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@text='First Name *']")
	@iOSXCUITFindBy(accessibility = "Views")
	private MobileElement txt_firstName;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@text='Last Name *']")
	private AndroidElement txt_lastName;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@text='Password *']")
	private AndroidElement txt_password;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@text='Confirm Password *']")
	private AndroidElement txt_confirmPassword;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@text='Email Address *']")
	private AndroidElement txt_emailAddress;

	@AndroidFindBy(className = "android.widget.CheckBox")
	private AndroidElement chk_checkBox;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Submit']")
	@iOSXCUITFindBy(accessibility = "Views")
	private AndroidElement btn_submit;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View")
	private AndroidElement drp_country;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Sign Up']")
	private AndroidElement lnk_signUp;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Afghanistan\"]")
	private AndroidElement tpl_countryvalue;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='We have sent a verification email to']")
	@iOSXCUITFindBy(accessibility = "Views")
	private AndroidElement div_verificationEmail;

	public RegistrationPage doRegistration(String fn, String ln) {

		WaitForElementToBeVisible(lnk_signUp);
		click(lnk_signUp, "SignUp");
		WaitForElementToBeVisible(txt_firstName);
		click(txt_firstName, "firstName");
		sendKeys(txt_firstName, "firstname", fn);
		hideKeyboard();
		click(txt_lastName, "lastname");
		sendKeys(txt_lastName, "lastname", ln);
		hideKeyboard();
		click(txt_emailAddress, "email");
		sendKeys(txt_emailAddress, "email", "automation.shaip+" + getDate() + "@shaip.com");
		hideKeyboard();
		click(txt_password, "password");
		sendKeys(txt_password, "password", "Test@123");
		hideKeyboard();
		click(txt_confirmPassword, "cpassword");
		sendKeys(txt_confirmPassword, "cpassword", "Test@123");
		hideKeyboard();
		tap(drp_country, "country");
		WaitForElementToBeVisible(tpl_countryvalue);
		tap(tpl_countryvalue, "countryValue");
		WaitForElementToBeVisible(chk_checkBox);

		click(chk_checkBox, "checkbox");

		click(btn_submit, "Submit");

		return new RegistrationPage();
	}

	public boolean isMailSent() {
		
		WaitForElementToBeVisible(div_verificationEmail);

		return div_verificationEmail.isDisplayed();

	}
	
	public boolean isSignUpLinkVisible() {

		WaitForElementToBeVisible(lnk_signUp);
		return lnk_signUp.isDisplayed();

	}

	protected String getDate()

	{

		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyHHmmss");
		Date date = new Date();
		String actualDate = format.format(date);
		return actualDate;

	}

}
