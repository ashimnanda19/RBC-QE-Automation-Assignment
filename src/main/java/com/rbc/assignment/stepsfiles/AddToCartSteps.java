package com.rbc.assignment.stepsfiles;

import org.openqa.selenium.WebDriver;

import com.rbc.assignment.pages.AddToCartPage;
import com.rbc.assignment.utility.framework.BaseTestScript;
import com.rbc.assignment.utility.framework.Log;

public class AddToCartSteps extends BaseTestScript {

	WebDriver driver = getDriver();

	public synchronized static AddToCartSteps get() {
		AddToCartSteps testObj = new AddToCartSteps();
		return testObj;
	}

	public void selectQuantity(String qty) {
		seWaitForClickableWebElement(driver, AddToCartPage.get().ddQuantity, 20);
		seSelectDropdownByValue(AddToCartPage.get().ddQuantity, "ddQuantity", qty);
	}

	public void clickAddToCart() {
		seClickOnElement(AddToCartPage.get().btnAddToCart, "btnAddToCart");
	}

	public void closeAddToYourOrderPopUp() {
		seClickOnElement(AddToCartPage.get().btnCloseAddToYourOrderPopUp, "btnCloseAddToYourOrderPopUp");
	}

	public void acceptAddToYourOrderPopUp() {
		seClickOnElement(AddToCartPage.get().btnAddToYourOrderPopUp, "btnAddToYourOrderPopUp");
	}

	public boolean confirmProductAddedToCart() {
		try {
			String ActualMessage = AddToCartPage.get().confirmationMessage.getText();
			if (ActualMessage.contains("added to Cart")) {
				Log.info("Confirmed: product added to cart");
				return true;
			} else {
				Log.info("Product addition to cart is not  cofirmed");
				return false;
			}
		} catch (Exception e) {
			Log.error("Exception occured while executing confirmProductAddedToCart " + e.getMessage());

		}
		return false;
	}

	public void clickCheckoutButton() {
		seClickOnElement(AddToCartPage.get().btnProceedToCheckout, "btnProceedToCheckout");
	}

}
