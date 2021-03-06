package com.qa.pages.mobile;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase{	
		
	@AndroidFindBy(id = "android:id/title")
	MobileElement title;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/buttonTest")
	MobileElement testBtn;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/my_text_field")
	MobileElement textField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/waitingButtonTest")
	MobileElement progressBar;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/visibleButtonTest")
	MobileElement displayToast;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/visibleButtonTest")
	MobileElement displayTestView;
	
	@AndroidFindBy(id = "android:id/message")
	MobileElement msg;
	
	@AndroidFindBy(id = "android:id/button2")
	MobileElement noBtn;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/continue_button")
	MobileElement continueBtn;
	
	
	public WebDriverWait wait;
	public AppiumDriver<MobileElement> driver;
	
	public HomePage(AppiumDriver<MobileElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(driver, 30);
	}
	
	public MobileElement getTextField() {
		return textField;
	}
	
	public MobileElement getProgressBar() {
		return progressBar;
	}
	
	public MobileElement getDisplayTestView() {
		return displayTestView;
	}

	
	public MobileElement getDisplayToast() {
		return displayToast;
	}
	
	public String getTitle() {
		return title.getText();
	}
	
	public MobileElement getTestBtn() {
		return testBtn;
	}
	
	public void clickEN_Btn() {
		testBtn.click();
	}
	
	public void waitForMsg() {
		wait.until(ExpectedConditions.visibilityOf(msg));		
	}
	
	public void clickNoBtn() {
		noBtn.click();
	}
	
	public MobileElement homeTitleElement() {
		return title;
	}
	
	
	
}
