package com.qa.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.SeleniumUtil;

public class JQueryUI_ControlGroup {

	private SeleniumUtil selenium;
	private WebDriver driver;

	@FindBy(xpath = "//iframe[@class='demo-frame']")
	private WebElement demoFrame;

	@FindBy(id = "car-type-button")
	private WebElement horizontalCarTypeButton;

	@FindBy(id = "ui-id-4")
	private WebElement horizontalSUVCarType;

	@FindBy(xpath = "//label[@for='transmission-automatic']/span[1]")
	private WebElement horizontalAutomatic;

	@FindBy(xpath = "//label[@for='insurance']/span[1]")
	private WebElement horizontalInsurance;

	@FindBy(id = "horizontal-spinner")
	private WebElement horizontalSpinner;

	@FindBy(id = "ui-id-8-button")
	private WebElement verticalCarTypeButton;

	@FindBy(id = "ui-id-14")
	private WebElement verticalTruckCarType;

	@FindBy(xpath = "//label[@for='transmission-standard-v']/span[1]")
	private WebElement verticalStandard;

	@FindBy(xpath = "//label[@for='insurance-v']/span[1]")
	private WebElement verticalInsurance;

	@FindBy(id = "vertical-spinner")
	private WebElement verticalSpinner;

	@FindBy(id = "book")
	private WebElement book;

	public JQueryUI_ControlGroup(SeleniumUtil selenium, WebDriver driver) {
		this.selenium = selenium;
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void switchToDemoFrame() {
		selenium.switchToFrameElement(demoFrame);
		selenium.staticWait("5");
	}

	public void selectHorizontalCarType() {
		horizontalCarTypeButton.click();
		horizontalSUVCarType.click();
	}

	public void selectHorizontalGroup() {
		horizontalAutomatic.click();
		horizontalInsurance.click();
		horizontalSpinner.sendKeys("2");
	}

	public void selectVerticalCarType() {
		verticalCarTypeButton.click();
		verticalTruckCarType.click();
	}

	public void selectVerticalGroup() {
		verticalStandard.click();
		verticalInsurance.click();
		verticalSpinner.sendKeys("1");
		book.click();
	}

}
