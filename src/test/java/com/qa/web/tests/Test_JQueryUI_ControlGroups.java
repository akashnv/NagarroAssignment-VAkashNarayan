package com.qa.web.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.pages.web.JQueryUI_ControlGroup;
import com.qa.pages.web.JQueryUI_Home;
import com.qa.util.ExtentManager;

public class Test_JQueryUI_ControlGroups extends Test_Base {

	ExtentManager extent;

	JQueryUI_Home homePage;
	JQueryUI_ControlGroup controlGroupPage;

	@Parameters({ "browser" })
	@BeforeMethod
	public void openTest(String browser) {
		selenium.setDriver(browser);
		selenium.setPageLoadTimeout(60);
		selenium.setImplicitWait(60);
		extent = new ExtentManager(selenium.getFileName(".//src//test//resources//results//WebReport") + ".html", "JQueryUI_ExtentReports");
		extent.initializeExtentTest("Test JQueryUI Control Groups feature", "Check Control Groups feature",
				"Test", "Regression");

		// Initializing Application Pages (POM)
		homePage = new JQueryUI_Home(selenium, selenium.driver);
		controlGroupPage = new JQueryUI_ControlGroup(selenium, selenium.driver);
	}

	@Test
	public void test() {
		homePage.launch();
		extent.log(Status.PASS, "HomePage Launced");

		homePage.clickControlGroup();
		extent.log(Status.PASS, "Clicked on Selectable link");

		controlGroupPage.switchToDemoFrame();
		extent.log(Status.PASS, "Switched to Demo Frame");

		controlGroupPage.selectHorizontalCarType();
		controlGroupPage.selectHorizontalGroup();
		extent.log(Status.PASS, "Selected Horizontal Group");

		controlGroupPage.selectVerticalCarType();
		controlGroupPage.selectVerticalGroup();
		extent.createImageForLog(Status.PASS, "Performed on all control operations",
				selenium.captureScreen(selenium.getFileName("JQueryUIImage")));
	}

	@AfterMethod
	public void closeTest() {
		if (selenium.driver != null)
			selenium.driver.close();
		extent.finish();
	}

}
