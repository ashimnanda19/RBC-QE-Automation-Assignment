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

	@FindBy(id = "nav-link-shopall")
	@CacheLookup
	public WebElement btnNavbarShopByDepartment;

	/**
	 * 
	 * WebElements of Shop By Department On-hover Dropdown Main Menu
	 * 
	 */

	@FindBy(xpath = "//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[8]/span")
	@CacheLookup
	public WebElement departmentKindle;

	/**
	 * 
	 * WebElements representing options in the menu of Kindle department
	 * 
	 */

	@FindBy(xpath = "//*[@id=\"nav-flyout-shopAll\"]/div[3]/div[8]//a[1]/span[1]")
	@CacheLookup
	public WebElement linkKindleOptions_Kindle;

	@FindBy(xpath = "//*[@id=\"nav-flyout-shopAll\"]/div[3]/div[8]//a[2]/span[1]")
	@CacheLookup
	public WebElement linkKindleOptions_KindlePaperWhite;

}
