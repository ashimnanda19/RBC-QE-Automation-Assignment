package com.rbc.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.rbc.assignment.utility.framework.BaseTestScript;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NavBarAmazonHomePage extends BaseTestScript {
	private static NavBarAmazonHomePage testObj;
	WebDriver driver = getDriver();

	public synchronized static NavBarAmazonHomePage get() {
		testObj = PageFactory.initElements(getDriver(), NavBarAmazonHomePage.class);
		return testObj;
	}

	/**
	 * 
	 * WebElements on the HomePage. Please note that all the WebElements have not
	 * been created here.
	 * 
	 */

	@FindBy(css = "#nav-link-shopall")
	@CacheLookup
	public WebElement btnNavbarShopByDepartment;

}
