package com.qa.mobile.tests;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.mobile.ChromeBrowserPage;

public class Scenario3 extends TestBase {

	ChromeBrowserPage chromePage;

	@BeforeTest
	public void initialise() throws MalformedURLException {
		System.out.println("Running scenario-3");
		init();
		chromePage = new ChromeBrowserPage(driver);
	}

	@Test
	public void userVerifiesTheTitle() {
		String name = "TestTest";
		chromePage.tapChromeIconAndEnterDetails(name);
		Assert.assertTrue((chromePage.getMyWayElement().isDisplayed()));
		Assert.assertEquals(chromePage.enteredName().getText(), name);
		Assert.assertEquals(chromePage.selectedCar().getText(), "mercedes");
		chromePage.ClickclickHereLink();
		Assert.assertEquals(chromePage.verifySelectedCar(), "volvo");
	}
}
