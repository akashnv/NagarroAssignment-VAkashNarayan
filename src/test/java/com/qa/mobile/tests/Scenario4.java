package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.mobile.HomePage;
import com.qa.pages.mobile.UserRegistrationPage;

public class Scenario4 extends TestBase{
	UserRegistrationPage regPage = new UserRegistrationPage(driver);
	HomePage home = new HomePage(driver);
	
	@Test
	public void verifyClickFileLogoAndVerifyRegPageElements() {
		regPage.clickFileLogo();
		regPage.verifyRegPageTitle();
		regPage.verifyRegPageElements();
		String nameTxt = "Mr. Burns";
		String langTxt = "Ruby";
		Assert.assertEquals(regPage.nameTxtBox.getText(), nameTxt);
		Assert.assertEquals(regPage.programmingLngDropdownValue.getText(), langTxt);
}
	@Test
	public void verifyUserRegistration() {
		String uName = "Test";
		String email = "test@gmail.com";
		String pwd = "Test@123";
		String name = "Mr.Yoyo";
		regPage.fillRegistrationFormAndClickRegister(uName,email ,pwd,name);
		regPage.postRegistrationPage(uName,email ,pwd,name,"Ruby","true");
		regPage.registerButton.click();
		Assert.assertTrue(home.homeTitleElement().isDisplayed());
}
	
	

}
