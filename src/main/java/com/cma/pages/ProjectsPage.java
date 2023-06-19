package com.cma.pages;

import org.openqa.selenium.support.PageFactory;

import com.cma.driver.DriverManager;
import com.cma.utils.Fileutils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends ActionClass {

	// Page Factory
	// By locators
	// String locators

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Disagree and Exit']")
	@iOSXCUITFindBy(accessibility = "Views")
	private MobileElement btn_disAgree;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Agree']")
	private AndroidElement btn_agree;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Tasks']")
	private AndroidElement btn_task;

	public ProjectsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}

	public ProjectsPage clickOnDisAgree() {
		click(btn_disAgree, "DisAgree Button");

		return new ProjectsPage();
	}

	public boolean isAgreementDisplayed() {

		WaitForElementToBeVisible(btn_disAgree);

		return btn_disAgree.isDisplayed();
	}

	public boolean isTaskButtonDisplayed() {

		WaitForElementToBeVisible(btn_task);

		return btn_task.isDisplayed();
	}

	public ProjectsPage clickOnAgree() {
		WaitForElementToBeVisible(btn_agree);
		click(btn_agree, "Agree Button");

		return new ProjectsPage();
	}

	public ProjectsPage searchToProject() throws InterruptedException {

		Thread.sleep(2000);
		String text = "P1012563";
		// DriverManager.getDriver().findElementByAndroidUIAutomator("new
		// UiScrollable(new UiSelector()).scrollIntoView(descriptionContains
		// (\""+text+"\"));");
		List<AndroidElement> element = DriverManager.getDriver().findElements(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionStartsWith(\""
						+ text + "\").instance(0))"));
		Thread.sleep(2000);

		boolean flag = false;

		while (true) {

			System.out.println("In While loop");

			List<AndroidElement> tasks = DriverManager.getDriver()
					.findElements(By.xpath("//android.widget.ImageView[@content-desc='Tasks']"));
			int count = tasks.size();
			System.out.println("Count of Tasks" + count);

			for (int i = 1; i <= count; i++)

			{
				System.out.println("I" + i);
				List<AndroidElement> projects = DriverManager.getDriver()
						.findElements(By.xpath("//android.view.View[@content-desc]"));
				String text1 = projects.get(i).getAttribute("contentDescription");
				System.out.println("content Descriptions are" + text1);

				if (text1.startsWith("P1012563")) {
					System.out.println("I in if loop" + i);

					System.out.println("Size of task buttons " + DriverManager.getDriver()
							.findElements(By.xpath("//android.widget.ImageView[@content-desc='Tasks']")).size());
					tap(tasks.get(i - 1), "Task");
					// tasks.get(i).click();
					Thread.sleep(5000);
					flag = true;
					break;
				}
			}
			if (flag) {
				System.out.println("Current flag end" + flag);
				break;
			} else {
				System.out.println("More scrolling");
				Fileutils.scrollDown();
			}

		}
		return this;
	}

}
