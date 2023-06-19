package com.cma.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import com.cma.constants.FrameworkConstants;
import com.cma.driver.DriverManager;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TaskPage extends ActionClass {

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='addtask']")
	@iOSXCUITFindBy(accessibility = "Views")
	private MobileElement btn_addtask;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='1 min diff_1.wav']")
	private AndroidElement btn_uFile;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='0%']")
	private AndroidElement cont_audioContainer;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Submit']")
	private AndroidElement btn_submitTask;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='pause']")
	private AndroidElement btn_pauseTask;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='save']")
	private AndroidElement btn_saveTask;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private AndroidElement btn_allowLocationWhileUsingApp;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private AndroidElement btn_allowMediaPermission;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Info\n"
			+ "The task has been saved successfully. Please note that the mandatory criteria must be fulfilled before clicking on the submit action']")

	// @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc='Show
	// roots']")
	// private MobileElement btn_rootsMenu;

	// @AndroidFindBy(xpath = "//android.widget.TextView[@text='Downloads']")
	// private MobileElement btn_downloads;

	private MobileElement toast_save;

	public TaskPage() {

		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}

	
	public boolean isAddTaskButtonDisplayed() {

		WaitForElementToBeVisible(btn_addtask);

		return btn_addtask.isDisplayed();
	}

	public TaskPage clickOnAddTaskButton() throws InterruptedException {

		click(btn_addtask, "Add Task Button");
		Thread.sleep(5000);
		return new TaskPage();
	}

	public TaskPage clickOnSubmitTaskButton() throws InterruptedException {

		click(btn_submitTask, "Submit Task Button");
		return new TaskPage();
	}

	public TaskPage clickOnSaveTaskButton() throws InterruptedException {

		click(btn_saveTask, "Save Task Button");
		return new TaskPage();
	}

	public TaskPage clickOnPauseTaskButton() throws InterruptedException {

		click(btn_pauseTask, "Pause Task Button");
		return new TaskPage();
	}

	public TaskPage navigateToDownload() throws InterruptedException {

		AndroidElement btn_rootsMenu = DriverManager.getDriver()
				.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Show roots']"));
		click(btn_rootsMenu, "Root Menu");
		Thread.sleep(2000);
		// AndroidElement rootList=
		// DriverManager.getDriver().findElement(MobileBy.id("com.android.documentsui:id/container_roots"));
		AndroidElement btn_downloads = DriverManager.getDriver()
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Download' or @text='Downloads']"));
		// System.out.println("size of downloads button"+btn_downloads.size());
		click(btn_downloads, "Downloads Menu");
		return new TaskPage();

	}

	public TaskPage navigateToDownloadFolder() throws InterruptedException {

		AndroidElement btn_rootsMenu = DriverManager.getDriver()
				.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Show roots']"));
		click(btn_rootsMenu, "Root Menu");
		Thread.sleep(2000);
		AndroidElement btn_sdcard = DriverManager.getDriver()
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='SDCARD']"));
		click(btn_sdcard, "SD Card Menu");
		AndroidElement btn_dowanload = DriverManager.getDriver()
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Download']"));
		click(btn_dowanload, "Download Menu");
		return new TaskPage();

	}

	public TaskPage uploadAudioFile() throws InterruptedException, IOException {

		allowLocationPermission();
		List<AndroidElement> uploadButtons = DriverManager.getDriver()
				.findElements(By.xpath("//android.view.View[@content-desc='upload']"));
		click(uploadButtons.get(0), "Add Task Button");
		allowMediaPermission();
		Thread.sleep(2000);
		navigateToDownload();
		Thread.sleep(2000);
		click(btn_uFile, "uploaded file");
		WaitForAudioPlayerToBeVisible(cont_audioContainer);
		clickOnSaveTaskButton();
		verifySaveTaskToaster();
		Thread.sleep(5000);
		return new TaskPage();
	}
	
	public TaskPage SaveTask() throws InterruptedException, IOException {

		allowLocationPermission();
		clickOnSaveTaskButton();
		verifySaveTaskToaster();
		Thread.sleep(5000);
		return new TaskPage();
	}
	
	public TaskPage PauseTask() throws InterruptedException, IOException {

		allowLocationPermission();
		clickOnPauseTaskButton();
		//verifyPauseTaskToaster();
		Thread.sleep(5000);
		return new TaskPage();
	}
	
	public TaskPage justUploadAudioFile() throws InterruptedException, IOException {

		allowLocationPermission();
		List<AndroidElement> uploadButtons = DriverManager.getDriver()
				.findElements(By.xpath("//android.view.View[@content-desc='upload']"));
		click(uploadButtons.get(0), "Add Task Button");
		allowMediaPermission();
		Thread.sleep(2000);
		navigateToDownload();
		Thread.sleep(2000);
		click(btn_uFile, "uploaded file");
		WaitForAudioPlayerToBeVisible(cont_audioContainer);
		Thread.sleep(2000);
		return new TaskPage();
	}

	
	public boolean isAudioContainerVisible() {

		WaitForElementToBeVisible(cont_audioContainer);

		return cont_audioContainer.isDisplayed();
	}
	// DriverManager.getDriver().pressKey(new KeyEvent().withKey(AndroidKey.BACK));

	public TaskPage pullFile() throws InterruptedException {

		DriverManager.getDriver().pullFile(FrameworkConstants.getAudio1());
		return new TaskPage();
	}

	public TaskPage verifySaveTaskToaster() throws InterruptedException {

		WaitForElementToBeVisible(toast_save);
		return new TaskPage();
	}

	public static TaskPage pushFilesToEmulator() throws InterruptedException {

		try {
			DriverManager.getDriver().pushFile(FrameworkConstants.getRemotePath(),
					new File(FrameworkConstants.getAudio1()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		return new TaskPage();
	}

	public TaskPage allowLocationPermission() throws InterruptedException {

		Thread.sleep(3000);

		try {
			int permisionBtn = DriverManager.getDriver()
					.findElements(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).size();

			System.out.println("size of button"+permisionBtn);
			if (permisionBtn != 0) {
				click(btn_allowLocationWhileUsingApp, "Allow Location");

			}
		} catch (WebDriverException e) {
			// TODO: handle exception
		}

		return new TaskPage();
	}

	public TaskPage allowMediaPermission() throws InterruptedException {

		Thread.sleep(2000);
		try {
		int permisionBtn = DriverManager.getDriver()
				.findElements(By.id("com.android.permissioncontroller:id/permission_allow_button")).size();

		
			if (permisionBtn != 0) {
				click(btn_allowMediaPermission, "Allow Media Permission");

			}
		} catch (WebDriverException e) {
			// TODO: handle exception
		}
		return new TaskPage();
	}

}
