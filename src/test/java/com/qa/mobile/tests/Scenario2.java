package com.qa.mobile.tests;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.mobile.HomePage;

public class Scenario2 extends TestBase {
	HomePage home;
	@BeforeTest
	public void initialise() throws MalformedURLException {
		System.out.println("Running scenario-2");
		init();
		home = new HomePage(driver);
	}

	@Test
	public void clickEN_BtnAndVerify() {
		home.clickEN_Btn();
		home.waitForMsg();
		home.clickNoBtn();
		Assert.assertTrue(home.homeTitleElement().isDisplayed());
	}
	
	
}
