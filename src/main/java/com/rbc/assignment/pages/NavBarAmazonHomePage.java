package com.rbc.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NavBarAmazonHomePage {
	WebDriver driver;
	
	public NavBarAmazonHomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	 /**

     * WebElements on the HomePage
     * Please note that all the webelements are not listed.
     */
	
	@FindBy(id="nav-link-shopall")
	@CacheLookup
	WebElement shopByDepartment;
	
	 /**

     * WebElements of Shop By Department On-hover Dropdown Main Menu 
     * 
     */
	
	@FindBy(xpath="//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[1]/span")
	@CacheLookup	
	WebElement dropDownDepartmentAmazonPrime;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[2]/span")
	@CacheLookup
	WebElement dropDownDepartmentAmazonPrimeVideo;
	
	
	@FindBy(xpath="//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[3]/span[1]")
	@CacheLookup
	WebElement dropDownDepartment;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[8]/span")
	@CacheLookup
	WebElement dropDownDepartmentKindle;
	
	
	
	@FindBy(xpath="//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[8]/span")
	@CacheLookup
	WebElement dropDownMainMenuKindle;
	
	
	
	
}
