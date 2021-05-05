package com.qa.util;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtil {

	public WebDriver driver;

	private SeleniumUtil() {
	}

	public static SeleniumUtil getInstance() {
		return new SeleniumUtil();
	}

	public void setDriver(String browser) {
		browser = browser.toLowerCase();
		if (browser.contains("chrome") || browser.equalsIgnoreCase("gc")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-infobars");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browser.contains("firefox") || browser.contains("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.contains("ie") || browser.contains("internetexplorer")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			InternetExplorerOptions options = new InternetExplorerOptions(capabilities);
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(options);
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 			
		 else {
			throw new InvalidArgumentException("CSTMEXP: Invalid Browser Name.");
		}
		driver.manage().window().maximize(); // Maximize or Full Screen the browser
	}

	public void perform(String action, By by, String data) {
		switch (action.toUpperCase()) {
		case "CLICK":
			click(by);
			break;
		case "CLICKANDWAIT":
			clickAndWait(by, data);
			break;
		case "ENTER":
			input(by, data);
			break;
		case "CLEAR":
			clear(by);
			break;
		case "SUBMIT":
			submit(by);
			break;
		case "LAUNCH":
			goTo(data);
			break;
		case "SELECTBYINDEX":
			selectByIndex(by, data);
			break;
		case "SELECTBYVALUE":
			selectByValue(by, data);
			break;
		case "SELECTBYVISIBLETEXT":
			selectByVisibleText(by, data);
			break;
		case "NAVIGATE":
			navigateTo(data);
			break;
		case "NAVIGATEFORWARD":
			navigateForward();
			break;
		case "NAVIGATEBACK":
			navigateBack();
			break;
		case "SWITCHTOALERT":
			switchToAlert();
			break;
		case "SWITCHTOFRAMEELEMENT":
			switchToFrameElement(by);
			break;
		case "SWITCHTOFRAMEINDEX":
			switchToFrameIndex(data);
			break;
		case "SWITCHTOWINDOW":
			switchToWindow(data);
			break;
		case "DELETEALLCOOKIES":
			deleteAllCookies();
			break;
		case "REFRESH":
			refresh();
			break;
		case "VERIFYTEXTPRESENT":
			verifyTextPresent(by, data);
			break;
		case "VERIFYALERTTEXT":
			verifyAlertText(data);
			break;
		case "ACCEPTALERT":
			acceptAlert();
			break;
		case "DISMISSALERT":
			dismissAlert();
			break;
		case "CAPTURESCREEN":
			captureScreen(data);
			break;
		case "JAVASCRIPT":
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(data);
			break;
		default:
			throw new InvalidArgumentException("CSTMEXP: Invalid Action - " + action);
		}
	}

	public void setImplicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void setPageLoadTimeout(int seconds) {
		driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
	}

	public void staticWait(String seconds) {
		try {
			Thread.sleep(Integer.valueOf(seconds) * 1000);
		} catch (Exception e) {
			throw new IllegalArgumentException("CSTMEXP: Wrong wait time format.");
		}
	}

	public void waitTillElementIsVisible(WebElement element, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void click(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}

	public void clickAndWait(By by, String data) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
		staticWait(data);
	}

	public void input(By by, String data) {
		driver.findElement(by).sendKeys(data);
	}

	public void clear(By by) {
		driver.findElement(by).clear();
	}

	public void submit(By by) {
		driver.findElement(by).submit();
	}

	public void goTo(String url) {
		driver.get(url);
	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void switchToFrameElement(By by) {
		driver.switchTo().frame(driver.findElement(by));
	}

	public void switchToFrameElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToFrameIndex(String index) {
		driver.switchTo().frame(Integer.parseInt(index));
	}

	public void switchToWindow(String windowTitle) {
		driver.switchTo().window(windowTitle);
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void switchToAlert() {
		driver.switchTo().alert();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public void verifyTextPresent(By by, String expectedText) {
		String actualText = driver.findElement(by).getText();
		assertEquals(actualText, expectedText, "Expected text is correct");
	}

	public void verifyAlertText(String alertText) {
		String actualText = driver.switchTo().alert().getText();
		assertEquals(actualText, alertText, "Alert Text is correct");
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void selectByVisibleText(By by, String text) {
		new Select(driver.findElement(by)).selectByVisibleText(text);
	}

	public void selectByIndex(By by, String index) {
		new Select(driver.findElement(by)).selectByIndex(Integer.parseInt(index));
	}

	public void selectByValue(By by, String value) {
		new Select(driver.findElement(by)).selectByValue(value);
	}

	public void fullscreen() {
		driver.manage().window().fullscreen();
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public By getLocator(String locator, String locatorValue) {
		locator = locator.toLowerCase();
		if (locator.equals("id")) {
			return By.id(locatorValue);
		} else if (locator.equals("classname")) {
			return By.className(locatorValue);
		} else if (locator.equals("name")) {
			return By.name(locatorValue);
		} else if (locator.equals("xpath")) {
			return By.xpath(locatorValue);
		} else if (locator.equals("cssselector")) {
			return By.cssSelector(locatorValue);
		} else if (locator.equals("partiallinktext")) {
			return By.partialLinkText(locatorValue);
		} else if (locator.equals("linktext")) {
			return By.linkText(locatorValue);
		} else if (locator.equals("tagname")) {
			return By.tagName(locatorValue);
		} else {
			throw new IllegalArgumentException("CSTMEXP: Invalid locator - " + locator);
		}
	}

	public String captureScreen(String imageName) {
		String time;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");

		time = date.format(cal.getTime());
		time = time.replaceAll(":", "-");
		time = time.replaceAll("/", "-");

		String filePath = System.getProperty("user.dir") + File.separator + "images" + File.separator + imageName + "-"
				+ time + ".png";

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);

		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}

	public void dragAndDropActions(WebDriver driver, WebElement source, WebElement target) {
		Actions builder = new Actions(driver);
		builder.clickAndHold(source).perform();
		builder.moveToElement(target, target.getLocation().x, target.getLocation().y).perform();
		builder.release(target).perform();
	}

	public void dragAndDropJS(WebDriver driver, WebElement source, WebElement target) {
		String xto = Integer.toString(source.getLocation().x);
		String yto = Integer.toString(target.getLocation().y);
		((JavascriptExecutor) driver).executeScript(
				"function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; "
						+ "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
				source, xto, yto);
	}

	public String getFileName(String fileName) {
		SimpleDateFormat date = new SimpleDateFormat("dd_MMM_yyyy-hh_mm_ss");
		String time = date.format(Calendar.getInstance().getTime());
		return fileName + "-" + time;
	}

}
