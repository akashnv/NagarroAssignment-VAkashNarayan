package com.qa.mobile.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.mobile.UserRegistrationPage;

import io.appium.java_client.MobileElement;

public class Scenario5 extends TestBase {
	UserRegistrationPage regPage;

	@BeforeTest
	public void initialise() throws MalformedURLException {
		System.out.println("Running scenario-5");
		init();
		regPage = new UserRegistrationPage(driver);
	}
	@Test
	public void clickOnProgressBarAndVerifyRegPageElements() throws InterruptedException {
		MobileElement pButton = driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest"));
		pButton.click();
		Thread.sleep(4000);
		MobileElement wait = driver.findElement(By.id("android:id/progress"));
		try {
		while (wait.isDisplayed()) {
			continue;
		}}
		catch(Exception e ) {
			
		}
		regPage.verifyRegPageElements();
	}
}
