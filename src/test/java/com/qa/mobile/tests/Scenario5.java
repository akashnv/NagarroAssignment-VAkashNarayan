package com.qa.mobile.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.mobile.UserRegistrationPage;

import io.appium.java_client.MobileElement;

public class Scenario5 extends TestBase {
	UserRegistrationPage regPage = new UserRegistrationPage(driver);

	
	@Test
	public void clickOnProgressBarAndVerifyRegPageElements() {
		MobileElement pButton = driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest"));
		pButton.click();
		MobileElement wait = driver.findElement(By.id("android:id/message"));
		while (wait.isDisplayed()) {
			continue;
		}
		regPage.verifyRegPageElements();
	}
}
