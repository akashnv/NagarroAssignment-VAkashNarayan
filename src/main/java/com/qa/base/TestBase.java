package com.qa.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.util.PropertyLoader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase {
	public AppiumDriver<MobileElement> driver;
	public PropertyLoader prop;

	
	public void init() throws MalformedURLException {
		prop = PropertyLoader.getInstance();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", prop.getValue("deviceName"));
		cap.setCapability("udid", prop.getValue("udid"));
		cap.setCapability("platformName", prop.getValue("platformName"));
		cap.setCapability("platformVersion", prop.getValue("platformVersion"));
		cap.setCapability("appPackage", prop.getValue("appPackage"));
		cap.setCapability("appActivity", prop.getValue("appActivity"));

		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new AppiumDriver<MobileElement>(url, cap);

		try {
			Thread.sleep(4000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element not found");
		}
		System.out.println("Application started");

	}

	@AfterClass
	public void tearDown() {
		driver.terminateApp("io.selendroid.testapp");
		
	}
}