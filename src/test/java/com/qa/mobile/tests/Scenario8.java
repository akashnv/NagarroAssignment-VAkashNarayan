package com.qa.mobile.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import io.appium.java_client.MobileElement;

public class Scenario8 extends TestBase{
	@Test
	public void clickOnExceptionBtnAndVerifyHomescreenTitle() {
		MobileElement eButton = driver.findElement(By.id("io.selendroid.testapp:id/exceptionTestButton"));
		eButton.click();
		MobileElement title = driver.findElement(By.id("android:id/title"));
		Assert.assertEquals(title.getText(), "selendroid-test-app");
	}


}
