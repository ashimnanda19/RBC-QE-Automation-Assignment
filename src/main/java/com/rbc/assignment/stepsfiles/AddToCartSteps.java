package com.rbc.assignment.stepsfiles;

import org.openqa.selenium.WebDriver;

import com.rbc.assignment.pages.AddToCartPage;
import com.rbc.assignment.utility.framework.BaseTestScript;
import com.rbc.assignment.utility.framework.Log;

/***
 * This is steps class for AddToCartPage, This class contains generic methods of
 * operation on AddToCartPage .
 * 
 * @author ashimnanda19
 *
 */
public class AddToCartSteps extends BaseTestScript {
	private static AddToCartSteps testObj;
	WebDriver driver = getDriver();

	public synchronized static AddToCartSteps get() {
		 testObj = new AddToCartSteps();
		return testObj;
	}

	/***
	 * This method select given value from the quantity dropdown.
	 * 
	 * @param qty
	 */
	public void selectQuantity(String qty) {
		seWaitForClickableWebElement(driver, AddToCartPage.get().ddQuantity, 20);
		seSelectDropdownByValue(AddToCartPage.get().ddQuantity, "ddQuantity", qty);
	}

	public void clickAddToCart() {
		seClickOnElement(AddToCartPage.get().btnAddToCart, "btnAddToCart");
	}

	public void closeAddToYourOrderPopUp() {
		seWaitForClickableWebElement(driver, AddToCartPage.get().btnAddToYourOrderPopUp, 20);
		seClickOnElement(AddToCartPage.get().btnCloseAddToYourOrderPopUp, "btnCloseAddToYourOrderPopUp");
	}

	public void acceptAddToYourOrderPopUp() {
		seClickOnElement(AddToCartPage.get().btnAddToYourOrderPopUp, "btnAddToYourOrderPopUp");
	}

	/***
	 * This method confirms the addition of product in to cart and returns true if
	 * the products are successfully added to the cart.
	 * 
	 * @return
	 */
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
