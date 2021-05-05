package com.qa.pages.web;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.SeleniumUtil;

public class JQueryUI_Selectable {

	private SeleniumUtil selenium;
	private WebDriver driver;

	@FindBy(xpath = "//iframe[@class='demo-frame']")
	private WebElement demoFrame;

	@FindBy(xpath = "//ol[@id='selectable']/li[1]")
	private WebElement item1;

	@FindBy(xpath = "//ol[@id='selectable']/li[3]")
	private WebElement item3;

	@FindBy(xpath = "//ol[@id='selectable']/li[7]")
	private WebElement item7;

	public JQueryUI_Selectable(SeleniumUtil selenium, WebDriver driver) {
		this.selenium = selenium;
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void selectItems() {
		selenium.switchToFrameElement(demoFrame);
		selenium.staticWait("5");

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).perform();

		item1.click();
		item3.click();
		item7.click();

		actions.keyUp(Keys.CONTROL).perform();

	}

}
