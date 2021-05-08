package com.qa.mobile.tests;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import io.appium.java_client.MobileElement;


public class Scenario9 extends TestBase{
	
	@BeforeTest
	public void initialise() throws MalformedURLException {
		System.out.println("Running scenario-9");
		init();		
	}
	
	@Test()
	public void enterTextInExceptionFieldAndVerifyHomePageTitle() throws MalformedURLException {
		String text = "test";
		MobileElement field = driver.findElement(By.id("io.selendroid.testapp:id/exceptionTestField"));
		try {
		field.sendKeys(text);
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Exception occured when sending a text to the Exception textbox");
			init();	
		}
		//driver.closeApp();		
		MobileElement title = driver.findElement(By.id("android:id/title"));
		Assert.assertEquals(title.getText(), "selendroid-test-app");
	}
}
