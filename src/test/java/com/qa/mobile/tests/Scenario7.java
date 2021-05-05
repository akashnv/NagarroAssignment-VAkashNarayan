package com.qa.mobile.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import io.appium.java_client.MobileElement;

public class Scenario7 extends TestBase{
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
