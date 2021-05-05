package com.qa.web.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.pages.web.JQueryUI_Home;
import com.qa.pages.web.JQueryUI_Selectable;
import com.qa.util.ExtentManager;

public class Test_JQueryUI_Selectable extends Test_Base {

	ExtentManager extent;

	JQueryUI_Home homePage;
	JQueryUI_Selectable selectablePage;

	@Parameters({ "browser" })
	@BeforeMethod
	public void openTest(String browser) {
		selenium.setDriver(browser);
		selenium.setPageLoadTimeout(60);
		selenium.setImplicitWait(60);
		extent = new ExtentManager(selenium.getFileName(".//src//test//resources//results//WebReport") + ".html", "JQueryUI_ExtentReports");
		extent.initializeExtentTest("Test JQueryUI Selectable feature", "Check selectable feature", "Test",
				"Regression");

		// Initializing Application Pages (POM)
		homePage = new JQueryUI_Home(selenium, selenium.driver);
		selectablePage = new JQueryUI_Selectable(selenium, selenium.driver);
	}

	@Test
	public void test2() {
		homePage.launch();
		extent.log(Status.PASS, "HomePage Launced");

		homePage.clickSelectable();
		extent.log(Status.PASS, "Clicked on Selectable link");

		selectablePage.selectItems();
		extent.createImageForLog(Status.PASS, "Performed on multiple selections operation",
				selenium.captureScreen(selenium.getFileName("JQueryUIImage")));
	}

	@AfterMethod
	public void closeTest() {
		if (selenium.driver != null)
			selenium.driver.close();
		extent.finish();
	}

}
