package com.rbc.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NavBarAmazonHomePage {
	WebDriver driver;

	public NavBarAmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public static NavBarAmazonHomePage get(WebDriver driver) { this.driver =
	 * driver; PageFactory.initElements(driver, this); }
	 */

	/**
	 * 
	 * WebElements on the HomePage. Please note that all the WebElements have not
	 * been created here.
	 * 
	 */

	@FindBy(id = "nav-link-shopall")
	@CacheLookup
	WebElement btnNavbarShopByDepartment;

	/**
	 * 
	 * WebElements of Shop By Department On-hover Dropdown Main Menu
	 * 
	 */

	@FindBy(xpath = "//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[8]/span")
	@CacheLookup
	WebElement departmentKindle;

	/**
	 * 
	 * WebElements representing options in the menu of Kindle department
	 * 
	 */

	@FindBy(linkText = "Kindle")
	@CacheLookup
	WebElement linkKindleOptions_Kindle;

	@FindBy(linkText = "Kindle Paperwhite")
	@CacheLookup
	WebElement linkKindleOptions_KindlePaperWhite;

}
