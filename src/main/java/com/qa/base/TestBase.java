package com.qa.base;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.qa.util.PropertyLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase {
	public AppiumDriver<MobileElement> driver;
	public PropertyLoader prop;

	@BeforeSuite
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

		System.out.println("Application started");

	}

	@AfterSuite
	public void tearDown() {
		driver.closeApp();
	}
}