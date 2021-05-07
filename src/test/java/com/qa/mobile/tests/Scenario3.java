package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.mobile.ChromeBrowserPage;
import com.qa.pages.mobile.HomePage;

public class Scenario3 extends TestBase {

	ChromeBrowserPage chromePage = new ChromeBrowserPage(driver);

	@BeforeTest
	public void initialise() {
		chromePage = new ChromeBrowserPage(driver);
	}

	@Test
	public void user_verifies_the_title() {
		String name = "TestTest";
		chromePage.tapChromeIconAndEnterDetails(name);
		Assert.assertTrue((chromePage.getMyWayElement().isDisplayed()));
		Assert.assertEquals(chromePage.enteredName().getText(), name);
		Assert.assertEquals(chromePage.selectedCar().getText(), "mercedes");
		chromePage.ClickclickHereLink();
		Assert.assertEquals(chromePage.verifySelectedCar(), "volvo");
	}
}
