package com.rbc.assignment.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rbc.assignment.pages.AddToCartPage;
import com.rbc.assignment.pages.NavBarAmazonHomePage;
import com.rbc.assignment.pages.SignInPage;
import com.rbc.assignment.utility.framework.BaseTestScript;
/***
 * This is a test script class for RBC Automation assignment.
 * @author ashimnanda19
 *
 */
@Listeners(com.rbc.assignment.utility.framework.Listener.class)
public class RBCAutomationTS extends BaseTestScript {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	@Parameters("browser")
	public void setUp(@Optional("Chrome") String browser) {
		setDriver(browser);
		driver = getDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void validateSignInAtCheckout() {
		driver.get("https://www.amazon.ca/");
		driver.manage().window().maximize();
		seHoverOnElement(NavBarAmazonHomePage.get().btnNavbarShopByDepartment, "btnNavbarShopByDepartment");
		seWaitForClickableWebElement(driver, NavBarAmazonHomePage.get().departmentKindle, 20);
		seHoverOnElement(NavBarAmazonHomePage.get().departmentKindle, "departmentKindle");
		seWaitForClickableWebElement(driver, NavBarAmazonHomePage.get().linkKindleOptions_KindlePaperWhite, 20);
		seClickOnElement(NavBarAmazonHomePage.get().linkKindleOptions_KindlePaperWhite, "linkKindleOptions_KindlePaperWhite");
		seWaitForClickableWebElement(driver, AddToCartPage.get().ddQuantity, 20);
		seSelectDropdownByValue(AddToCartPage.get().ddQuantity, "ddQuantity", "2");
		seClickOnElement(AddToCartPage.get().btnAddToCart, "btnAddToCart");
		seWaitTillVisiblityOfElement(driver, AddToCartPage.get().btnCloseAddToYourOrderPopUp, 20);
		seClickOnElement(AddToCartPage.get().btnCloseAddToYourOrderPopUp, "btnProceedToCheckout");
		seWaitForClickableWebElement(driver,AddToCartPage.get().ConfirmationMessage, 20);
		seCompareText(AddToCartPage.get().ConfirmationMessage, "ConfirmationMessage", "2 items added to Cart");
		seClickOnElement(AddToCartPage.get().btnProceedToCheckout, "btnProceedToCheckout");
		seWaitForClickableWebElement(driver, SignInPage.get().txtEmailOrMobilePhoneNumber, 20);
		
		/*Verifying that Email id or Mobile Phone is being asked at the end of scenario*/
		softAssert.assertEquals(driver.getTitle(),"Amazon Sign In");
		Assert.assertTrue(SignInPage.get().lblEmailOrMobilePhoneNumber.isDisplayed());
		Assert.assertTrue(SignInPage.get().txtEmailOrMobilePhoneNumber.isDisplayed());
	}

}
