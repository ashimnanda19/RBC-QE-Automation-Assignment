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
import com.rbc.assignment.stepsfiles.AddToCartSteps;
import com.rbc.assignment.stepsfiles.NavBarAmazonHomeSteps;
import com.rbc.assignment.stepsfiles.SignInSteps;
import com.rbc.assignment.utility.framework.BaseTestScript;

/***
 * This is a test script class for RBC Automation assignment.
 * 
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.ca/");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void validateSignInAtCheckout() {
		NavBarAmazonHomeSteps.get().selectOptionInDepartment("Kindle", "Kindle Paperwhite");
		AddToCartSteps.get().selectQuantity("2");
		AddToCartSteps.get().clickAddToCart();
		AddToCartSteps.get().closeAddToYourOrderPopUp();
		softAssert.assertTrue(AddToCartSteps.get().confirmProductAddedToCart(), "Product not added to cart");
		AddToCartSteps.get().clickCheckoutButton();
		softAssert.assertTrue(SignInSteps.get().verifyThePageTitle(),"User is not on SignIn page");
		Assert.assertTrue(SignInSteps.get().verifyPresenceOfEmailandPhoneField());

	}

}
