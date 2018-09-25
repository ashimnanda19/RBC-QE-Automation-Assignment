package com.rbc.assignment.utility.framework;

import java.io.File;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * This is BaseTestScript class which the core of this framework design. All the
 * reusable methods are defined in this class.
 * 
 * @author ashimnanda19
 *
 */
public class BaseTestScript {

	private static WebDriver driver;

	/***
	 * The setDriver method creates instance of driver based on the input parameter
	 * which is passed on from calling method.
	 * 
	 * @param browser
	 */
	protected void setDriver(String browser) {

		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.firefox.marionette",
						"./src\\main\\resources\\com\\rbc\\assignment\\libs\\geckodriver.exe");
				BaseTestScript.driver = new FirefoxDriver();
				Log.info("Created Instance of Firefox WebDriver");
			} else if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"./src\\main\\resources\\com\\rbc\\assignment\\libs\\chromedriver.exe");
				BaseTestScript.driver = new ChromeDriver();
				Log.info("Created Instance of Chrome WebDriver");
			} else if (browser.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver",
						"./src\\main\\resources\\com\\rbc\\assignment\\libs\\MicrosoftWebDriver.exe");
				BaseTestScript.driver = new EdgeDriver();
				Log.info("Created Instance of Chrome WebDriver");
			}
		} catch (Exception e) {
			Log.error("Exception Occured while initiating the instance of" + browser + " Webdriver" + e.getMessage());
		}

	}

	/***
	 * This returns the current instance of WebDriver. This is a synchronized
	 * method.
	 * 
	 * @return
	 */
	protected static synchronized WebDriver getDriver() {
		return driver;
	}

	/***
	 * This method hovers the control on the WebElement passed as parameter
	 * 
	 * @param testElement
	 * @param elementName
	 */
	protected void seHoverOnElement(WebElement testElement, String elementName) {
		try {
			Actions actHover = new Actions(driver);
			if (testElement.isDisplayed()) {
				actHover.moveToElement(testElement).build().perform();
				Log.info("Successfully hovered on Element: " + elementName);
			} else {
				Log.info("Unable to hover on Element: " + elementName);
			}
		} catch (Exception e) {
			Log.error("Exception occred while trying to hover on Element: " + elementName);
		}

	}

	/***
	 * This method click on a given WebElement passed as parameter.
	 * 
	 * @param testElement
	 * @param elementName
	 */
	protected void seClickOnElement(WebElement testElement, String elementName) {

		try {
			if (testElement.isDisplayed()) {
				testElement.click();
				Log.info("Successfully Clicked on Element: " + elementName);
			} else {
				Log.info("Unable to click on Element: " + elementName);
			}

		} catch (Exception e) {
			Log.error("Exception occred while trying to click on Element: " + elementName);
		}

	}

	/***
	 * This method help to select a dropdown Option based on the value passed a
	 * parameter. This method supports only selecting only single value from
	 * dropdown.
	 * 
	 * @param testElement
	 * @param elementName
	 * @param desiredValue
	 */
	protected void seSelectDropdownByValue(WebElement testElement, String elementName, String desiredValue) {

		try {
			Select dropDown = new Select(testElement);
			dropDown.selectByValue(desiredValue);
		} catch (Exception e) {
			Log.error("Exception occred while trying to select option from dropDown: " + elementName + e.getMessage());
		}

	}

	/***
	 * This method waits for a clickable Webelement passed on as parameter for a
	 * given time.
	 * 
	 * @param driver
	 * @param testElement
	 * @param maxTimeOutInSeconds
	 */
	protected void seWaitForClickableWebElement(WebDriver driver, WebElement testElement, int maxTimeOutInSeconds) {
		try {
			if (driver != null) {
				FluentWait<WebDriver> wait = new FluentWait(driver);
				wait.pollingEvery(Duration.ofMillis(100L));
				wait.withTimeout(Duration.ofSeconds((long) maxTimeOutInSeconds));
				wait.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
				wait.until(ExpectedConditions.elementToBeClickable(testElement));
			} else {
				Log.info("Wait for WebElement: Driver is null so could not perform seWaitForClickableWebElement");
			}

		} catch (Exception e) {
			Log.error("Exception Occured while executing seWaitForClickableWebElement " + e.getMessage());
		}

	}

	/***
	 * This method Explicitly waits till visibility of a given WebElement for a
	 * given time.
	 * 
	 * @param driver
	 * @param testElement
	 * @param maxTimeOutInSeconds
	 */
	protected void seWaitTillVisiblityOfElement(WebDriver driver, WebElement testElement, int maxTimeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, maxTimeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(testElement));
		} catch (Exception e) {
			Log.error("Exception Occured while executing seExplicitWait " + e.getMessage());
		}

	}

	/***
	 * This method compares the Text of a given WebElement with expected value.
	 * 
	 * @param testElement
	 * @param elementName
	 * @param expectedValue
	 * @return
	 */
	protected boolean seCompareText(WebElement testElement, String elementName, String expectedValue) {
		boolean isMatch = false;
		try {
			String actualValue = testElement.getText();
			if (actualValue.equalsIgnoreCase(expectedValue)) {
				isMatch = true;
				Log.info("Compare Text: Expected Value: " + expectedValue + " is matching with Actual Value: "
						+ actualValue + " For WebElement: " + elementName);
			} else {
				Log.info("Compare Text: Expected Value: " + expectedValue + " does not match with Actual Value: "
						+ actualValue + " For WebElement: " + elementName);
			}
		} catch (Exception e) {
			Log.error("Exception Occured while executing seCompareText for WebElement: " + elementName);
		}
		return isMatch;

	}

	/***
	 * This method takes Screenshot when it is invoked.
	 */
	protected void seTakeScreeshot() {

		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File("./test-output\\RBCAutomationSuite");
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			Log.error("Exception Occured while Taking ScreenShot: " + e.getMessage());
		}

	}

}
