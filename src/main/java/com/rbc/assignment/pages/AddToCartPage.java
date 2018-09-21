package com.rbc.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage {

	WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * WebElements of the Add to the cart Section.
	 * 
	 */

	/*Text Fields*/
	@FindBy(id = "confirm-text")
	@CacheLookup
	WebElement ConfirmationMessage;
	
	/* DropDowns */
	@FindBy(id = "nav-link-shopall")
	@CacheLookup
	WebElement ddQuantity;

	/* Buttons */
	@FindBy(id = "add-to-cart-button")
	@CacheLookup
	WebElement btnAddToCart;

	@FindBy(xpath = "//*[@id=\"a-popover-6\"]/div/header/button")
	@CacheLookup
	WebElement btnCloseAddToYourOrder;

	@FindBy(xpath = "//*[@id=\"hlb-next-steps\"]/a[2]")
	@CacheLookup
	WebElement btnProceedToCheckout;

}
