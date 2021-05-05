package com.qa.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.SeleniumUtil;

public class JQueryUI_Droppable {

	private SeleniumUtil selenium;
	private WebDriver driver;

	@FindBy(xpath = "//iframe[@class='demo-frame']")
	private WebElement demoFrame;

	@FindBy(id = "draggable")
	private WebElement draggable;

	@FindBy(id = "droppable")
	private WebElement droppable;

	public JQueryUI_Droppable(SeleniumUtil selenium, WebDriver driver) {
		this.selenium = selenium;
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void dragAndDropTarget() {
		selenium.switchToFrameElement(demoFrame);
		selenium.staticWait("5");

		Actions actions = new Actions(driver);
		actions.dragAndDrop(draggable, droppable).build().perform();

		selenium.staticWait("5");
	}

}
