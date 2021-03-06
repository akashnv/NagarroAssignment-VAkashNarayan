package com.qa.pages.mobile;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChromeBrowserPage extends TestBase {
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
	MobileElement btnChromeLogo;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.TextView")
	MobileElement header;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.widget.TextView")
	MobileElement hdrTxt;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]")
	MobileElement nameTxtBox;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]"
			+ "/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[6]")
	MobileElement sendMeNameBtn;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
			+ "/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.view.View[1]")
	MobileElement myWayLabel;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]"
			+ "/android.webkit.WebView/android.webkit.WebView/android.widget.TextView[1]")
	MobileElement enteredName;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]"
			+ "/android.webkit.WebView/android.webkit.WebView/android.view.View[5]")
	MobileElement selectedCar;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"here\"]/android.widget.TextView")
	MobileElement clickHereLink;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView"
			+ "/android.view.View/android.view.View[4]/android.view.View[2]")
	MobileElement carSelect;


	public WebDriverWait wait;
	public AppiumDriver<MobileElement> driver;
	
	public ChromeBrowserPage(AppiumDriver<MobileElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(driver, 30);
	}

	public void tapChromeIconAndEnterDetails(String nameToSend) {
		btnChromeLogo.click();
		wait.until(ExpectedConditions.visibilityOf(header));
		Assert.assertEquals(header.getText(), "Web View Interaction");
		Assert.assertEquals(hdrTxt.getText(), "Hello, can you please tell me your name?");
		nameTxtBox.clear();
		nameTxtBox.sendKeys(nameToSend);
	    List <MobileElement> options=driver.findElementsByClassName("android.widget.CheckedTextView");	       
        System.out.println("Total number of options available in dropdown:"+options.size());       
       
        for(MobileElement e:options)
        {
            String val=e.getText();
           
            if(val.equalsIgnoreCase("mercedes"))
            {
                e.click();
                break;
            }
        }
        sendMeNameBtn.click();   
        wait.until(ExpectedConditions.visibilityOf(myWayLabel));
        
	}
	
	public MobileElement getMyWayElement() {
		return myWayLabel;		
	}
	
	public MobileElement enteredName() {
		return enteredName;		
	}
	
	public MobileElement selectedCar() {
		return selectedCar;		
	}
	
	public String verifySelectedCar() {		
		String txt = carSelect.getText();
		return txt;
		
	}
	public void ClickclickHereLink() {
		clickHereLink.click();		
	}

}
