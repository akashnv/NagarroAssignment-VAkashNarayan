package com.qa.web.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.pages.web.JQueryUI_Droppable;
import com.qa.pages.web.JQueryUI_Home;
import com.qa.util.ExtentManager;

public class Test_JQueryUI_Droppable extends Test_Base {

	ExtentManager extent;

	JQueryUI_Home homePage;
	JQueryUI_Droppable droppablePage;

	@Parameters({ "browser" })
	@BeforeMethod
	public void openTest(String browser) {
		selenium.setDriver(browser);
		selenium.setPageLoadTimeout(60);
		selenium.setImplicitWait(60);
		extent = new ExtentManager(selenium.getFileName(".//src//test//resources//results//WebReport") + ".html", "JQueryUI_ExtentReports");
		extent.initializeExtentTest("Test JQueryUI Droppable feature", "Check droppable feature", "Test",
				"Regression");

		// Initializing Application Pages (POM)
		homePage = new JQueryUI_Home(selenium, selenium.driver);
		droppablePage = new JQueryUI_Droppable(selenium, selenium.driver);
	}

	@Test
	public void test1() {
		homePage.launch();
		extent.log(Status.PASS, "HomePage Launced");

		homePage.clickDroppable();
		extent.log(Status.PASS, "Clicked on Dropppable link");

		droppablePage.dragAndDropTarget();
		extent.createImageForLog(Status.PASS, "Performed on Drag and Drop operation",
				selenium.captureScreen(selenium.getFileName("JQueryUIImage")));
	}

	@AfterMethod
	public void closeTest() {
		if (selenium.driver != null)
			selenium.driver.close();
		extent.finish();
	}

}
