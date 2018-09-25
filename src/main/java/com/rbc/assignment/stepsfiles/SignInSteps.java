package com.rbc.assignment.stepsfiles;

import org.openqa.selenium.WebDriver;

import com.rbc.assignment.pages.SignInPage;
import com.rbc.assignment.utility.framework.BaseTestScript;
import com.rbc.assignment.utility.framework.Log;

/***
 * This is the steps class corresponding to SignInPage class.
 * This class contains methods to do common operations on Sign In Page.
 * @author ashimnanda19
 *
 */

public class SignInSteps extends BaseTestScript {

	WebDriver driver = getDriver();

	public synchronized static SignInSteps get() {
		SignInSteps testObj = new SignInSteps();
		return testObj;
	}

	/***
	 * This method returns true if the current title of the page is that of 
	 * Amazon Sign In page. Thus verifies the presence of user on Sign In page.
	 * @return
	 */
	public boolean verifyThePageTitle() {
		try {
			seWaitForClickableWebElement(driver, SignInPage.get().txtEmailOrMobilePhoneNumber, 20);
			if (driver.getTitle().equals("Amazon Sign In")) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			Log.error("Error Occured while verifying that user is on SignOn Page");
		}
		return false;

	}

	
	/***
	 * This method check for the presence of E-mail address or mobile phone number field
	 * and returns true if fields are present on the screen.
	 * @return
	 */
	public boolean verifyPresenceOfEmailandPhoneField() {
		try {
			seWaitForClickableWebElement(driver, SignInPage.get().txtEmailOrMobilePhoneNumber, 20);
			if (SignInPage.get().lblEmailOrMobilePhoneNumber.isDisplayed()
					&& SignInPage.get().txtEmailOrMobilePhoneNumber.isDisplayed()) {
				Log.info("E-mail address or mobile phone number field is displayed. ");
				return true;	
			} else {
				Log.info("E-mail address or mobile phone number field is not displayed. ");
				return false;
			}

		} catch (Exception e) {
			Log.error("Error Occured while verifying the presence of E-mail address or mobile phone number field");
		}
		return false;
	}

}
