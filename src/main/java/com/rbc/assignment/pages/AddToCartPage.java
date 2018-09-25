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
	@FindBy(css = "#confirm-text")
	@CacheLookup
	public WebElement confirmationMessage;

	/* DropDowns */
	@FindBy(css = "#quantity")
	@CacheLookup
	public WebElement ddQuantity;

	/* Buttons */
	@FindBy(css = "#add-to-cart-button")
	@CacheLookup
	public WebElement btnAddToCart;

	@FindBy(css = "#a-popover-7 > div > header > button")
	@CacheLookup
	public WebElement btnCloseAddToYourOrderPopUp;

	@FindBy(css = "#intl_pop_addToOrder")
	@CacheLookup
	public WebElement btnAddToYourOrderPopUp;

	@FindBy(css = "#hlb-next-steps > a.hucSprite.s_checkout.hlb-checkout-button")
	@CacheLookup
	public WebElement btnProceedToCheckout;

}
