package com.qa.mobile.tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.mobile.HomePage;

public class Scenario1 extends TestBase {
	HomePage home;

	@BeforeTest
	public void initialise() throws MalformedURLException {
		System.out.println("Running scenario-1");
		init();
		home = new HomePage(driver);
	}
	
	

	@Test
	public void userUerifiesTitle() {
		Assert.assertEquals(home.getTitle(), "selendroid-test-app", "Verifying Title");
	}

	@Test
	public void userVerifyElementsOnApplication() {
		Assert.assertEquals(home.getTestBtn().isDisplayed(), true,"Verifying Test Btn");
		Assert.assertEquals(home.getTextField().isDisplayed(), true,"Verifying Text Field");
		Assert.assertEquals(home.getProgressBar().isDisplayed(), true,"Verifying Progress Bar");
		Assert.assertEquals(home.getDisplayToast().isDisplayed(), true,"Verifying Toast Display");
		Assert.assertEquals(home.getDisplayTestView().isDisplayed(), true,"Verifying Test View Display");
	}
	
}
