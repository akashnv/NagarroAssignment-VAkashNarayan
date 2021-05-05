package com.qa.pages.mobile;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UserRegistrationPage extends TestBase {

	@AndroidFindBy(id = "io.selendroid.testapp:id/startUserRegistration")
	MobileElement fileIconBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(text(),'Welcome to register')]")
	MobileElement welcomeLabel;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
	MobileElement userNameTxtBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputEmail")
	MobileElement emailTxtBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputPassword")
	MobileElement pwdTxtBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputName")
	public MobileElement nameTxtBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/input_adds")
	MobileElement tNCCheckbox; 
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
	MobileElement regUserBtn;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_name_data")
	public MobileElement nameField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_username_data")
	public MobileElement userNameField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/input_preferedProgrammingLanguage")
	public MobileElement programmingLngDropdownValue;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_password_data")
	public MobileElement pwdField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_email_data")
	public MobileElement emailField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_preferedProgrammingLanguage_data")
	public MobileElement pRLangField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_acceptAdds_data")
	public MobileElement iAcceptVal;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/buttonRegisterUser")
	public MobileElement registerButton;
		
	public WebDriverWait wait;
	public AppiumDriver<MobileElement> driver;
	
	public UserRegistrationPage(AppiumDriver<MobileElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(driver, 30);
	}
	public void verifyRegPageElements() {
		Assert.assertEquals(userNameTxtBox.isDisplayed(), true);
		Assert.assertEquals(emailTxtBox.isDisplayed(), true);
		Assert.assertEquals(pwdTxtBox.isDisplayed(), true);
		Assert.assertEquals(nameTxtBox.isDisplayed(), true);
		Assert.assertEquals(tNCCheckbox.isDisplayed(), true);
		Assert.assertEquals(regUserBtn.isDisplayed(), true);
	}
	
	public void clickFileLogo() {
		Assert.assertEquals(fileIconBtn.isDisplayed(), true);		
		fileIconBtn.click();
	}
	
	public void verifyRegPageTitle() {
		Assert.assertEquals(welcomeLabel.isDisplayed(), true);
	}
	
	public void fillRegistrationFormAndClickRegister(String uname, String email, String pwd, String name) {
		userNameTxtBox.sendKeys(uname);
		emailTxtBox.sendKeys(email);
		pwdTxtBox.sendKeys(pwd);
		nameTxtBox.sendKeys(name);
		tNCCheckbox.click();
		regUserBtn.click();		
		
	}
	
	public void postRegistrationPage(String uname, String email, String pwd, String name, 
			String lang, String acceptVal) {
		
		Assert.assertEquals(nameField.getText(), name);
		Assert.assertEquals(userNameField.getText(), uname);
		Assert.assertEquals(pwdField.getText(), pwd);
		Assert.assertEquals(emailField.getText(), email);
		Assert.assertEquals(pRLangField.getText(), lang);
		Assert.assertEquals(iAcceptVal.getText(), acceptVal);
		
	}
}
