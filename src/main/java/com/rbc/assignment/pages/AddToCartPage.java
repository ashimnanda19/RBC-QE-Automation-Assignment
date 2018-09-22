package com.rbc.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.rbc.assignment.utility.framework.BaseTestScript;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BaseTestScript {
	private static AddToCartPage testObj;
	WebDriver driver = getDriver();

	public synchronized static AddToCartPage get() {
		testObj = PageFactory.initElements(getDriver(), AddToCartPage.class);
		return testObj;
	}

	/**
	 * WebElements of the Add to the cart Section.
	 * 
	 */

	/* Text Fields */
	@FindBy(id = "confirm-text")
	@CacheLookup
	public WebElement ConfirmationMessage;

	/* DropDowns */
	@FindBy(id = "nav-link-shopall")
	@CacheLookup
	public WebElement ddQuantity;

	/* Buttons */
	@FindBy(id = "add-to-cart-button")
	@CacheLookup
	public WebElement btnAddToCart;

	@FindBy(xpath = "//*[@id=\"a-popover-6\"]/div/header/button")
	@CacheLookup
	public WebElement btnCloseAddToYourOrder;

	@FindBy(xpath = "//*[@id=\"hlb-next-steps\"]/a[2]")
	@CacheLookup
	public WebElement btnProceedToCheckout;

}
