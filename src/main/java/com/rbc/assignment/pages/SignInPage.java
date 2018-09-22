package com.rbc.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.rbc.assignment.utility.framework.BaseTestScript;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BaseTestScript {
	private static SignInPage testObj;
	WebDriver driver;

	public synchronized static SignInPage get() {
		testObj = PageFactory.initElements(getDriver(), SignInPage.class);
		return testObj;
	}

	/**
	 * WebElements of the Add to the cart Section.
	 * 
	 */

	/* Labels */
	@FindBy(xpath = "//form//label")
	@CacheLookup
	public WebElement lblEmailOrMobilePhoneNumber;

	/* Text boxes */
	@FindBy(id = "ap_email")
	@CacheLookup
	public WebElement txtEmailOrMobilePhoneNumber;

}
