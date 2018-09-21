package com.rbc.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

	WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * WebElements of the Add to the cart Section.
	 * 
	 */

	/* Labels */
	@FindBy(xpath = "//form//label")
	@CacheLookup
	WebElement lblEmailOrMobilePhoneNumber;

	/* Textboxes */
	@FindBy(id = "ap_email")
	@CacheLookup
	WebElement txtEmailOrMobilePhoneNumber;

}
