package com.qa.mobile.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import io.appium.java_client.MobileElement;

public class Scenario6 extends TestBase {
	
	@Test
	public void clickToastBtnAndVerifyToastText() {
		MobileElement toastButton = driver.findElement(By.id("io.selendroid.testapp:id/showToastButton"));
		toastButton.click();
		MobileElement toastTxt = driver.findElement(By.xpath("*//[contains(text(),'Hello Selendroid')]"));
		Assert.assertEquals(toastTxt, "Hello Selendroid toast!");
		}


}
