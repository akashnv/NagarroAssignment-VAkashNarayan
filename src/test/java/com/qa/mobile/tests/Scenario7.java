package com.qa.mobile.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import io.appium.java_client.MobileElement;

public class Scenario7 extends TestBase{
	
	@BeforeTest
	public void initialise() throws MalformedURLException {
		System.out.println("Running scenario-7");
		init();		
	}
	@Test
	public void clickonDisplayPopupAndDismiss() {
		MobileElement pButton = driver.findElement(By.id("io.selendroid.testapp:id/showPopupWindowButton"));
		pButton.click();
		MobileElement dismissBtn = driver.findElement(By.id("io.selendroid.testapp:id/showPopupWindowButton"));
		Alert alert = driver.switchTo().alert();
		alert.accept();		
		Assert.assertEquals(dismissBtn.isDisplayed(), false);
		
	}

}
