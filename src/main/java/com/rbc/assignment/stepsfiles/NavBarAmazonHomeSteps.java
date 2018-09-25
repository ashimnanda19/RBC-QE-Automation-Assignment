package com.rbc.assignment.stepsfiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rbc.assignment.pages.NavBarAmazonHomePage;
import com.rbc.assignment.utility.framework.BaseTestScript;
import com.rbc.assignment.utility.framework.Log;

public class NavBarAmazonHomeSteps extends BaseTestScript{
 
	WebDriver driver = getDriver();
	
	public synchronized static NavBarAmazonHomeSteps get() {
		NavBarAmazonHomeSteps testObj = new NavBarAmazonHomeSteps();
		return testObj;
	}
	
	/***
	 * This Method selects a department by hovering mouse over the desired
	 * Department passed as parameter. A dynamic cssSelector path is generated to
	 * locate desired department and then option under that department.
	 * 
	 * By default the mouse will hover on the first Department: Amazon Prime.
	 * 
	 * @param department
	 * @param optionsLinkText
	 */
	public  void  selectOptionInDepartment(String department, String optionsLinkText) {
		int departmentCode;
		int optionsListCode;
		switch (department) {
		case "Amazon Prime":
			departmentCode = 1;
			optionsListCode = 1;
			break;
		case "Amazon Prime Video":
			departmentCode = 2;
			optionsListCode = 2;
			break;
		case "Prime Music":
			departmentCode = 3;
			optionsListCode = 3;
			break;
		case "Savings Programs":
			departmentCode = 4;
			optionsListCode = 4;
			break;
		case "Appstore for Android":
			departmentCode = 5;
			optionsListCode = 5;
			break;
		case "Echo & Alexa":
			departmentCode = 7;
			optionsListCode = 6;
			break;
		case "Fire Tablets & Fire TV":
			departmentCode = 8;
			optionsListCode = 7;
			break;
		case "Kindle":
			departmentCode = 9;
			optionsListCode = 8;
			break;
		case "Books & Audible":
			departmentCode = 11;
			optionsListCode = 9;
			break;
		case "Video Games & Twitch Prime":
			departmentCode = 12;
			optionsListCode = 10;
			break;
		case "Music, Movies & TV Shows":
			departmentCode = 13;
			optionsListCode = 11;
			break;
		case "Electronics":
			departmentCode = 14;
			optionsListCode = 12;
			break;
		case "Home, Garden, Pets & Tools":
			departmentCode = 15;
			optionsListCode = 13;
			break;
		case "Grocery & Whole Foods Market":
			departmentCode = 16;
			optionsListCode = 14;
			break;
		case "Health & Beauty":
			departmentCode = 17;
			optionsListCode = 15;
			break;
		case "Toys, Kids, Baby & STEM":
			departmentCode = 18;
			optionsListCode = 16;
			break;
		case "Clothing, Shoes & Jewelry":
			departmentCode = 19;
			optionsListCode = 17;
			break;
		case "Handmade":
			departmentCode = 20;
			optionsListCode = 18;
			break;
		case "Sports & Outdoors":
			departmentCode = 21;
			optionsListCode = 19;
			break;
		case "Automotive & Industrial":
			departmentCode = 22;
			optionsListCode = 20;
			break;
		case "Boutiques Francophones":
			departmentCode = 23;
			optionsListCode = 21;
			break;
		default:
			departmentCode = 1;
			optionsListCode = 1;
			Log.info(" The given Department Name: " + department
					+ " is either incorrect or is not defined in the method: selectDepartmentByHoveringMouse"
					+ "  of NavBarAmazonHomePage.class,Please Check.");
		}

		WebElement desiredDepartment = driver.findElement(By.cssSelector(
				"#nav-flyout-shopAll > div.nav-template.nav-flyout-content.nav-tpl-itemList > span:nth-child("
						+ departmentCode + ")"));
		seHoverOnElement(NavBarAmazonHomePage.get().btnNavbarShopByDepartment, "btnNavbarShopByDepartment");
		seWaitForClickableWebElement(driver, desiredDepartment, 20);
		seHoverOnElement(desiredDepartment, department);
		selectOptionByLinkText(optionsListCode, optionsLinkText);
	}

	/***
	 * This is a private method called internally by selectOptionInAnyDepartment
	 * which passes the list code used dynamic generation of css path to access the
	 * list of options in that department and LinkText to choose a desired option.
	 * 
	 * @param optionsListCode
	 * @param optionsLinkText
	 */
	private void selectOptionByLinkText(int optionsListCode, String optionsLinkText) {
		try {
			boolean OptionFound = false;
			List<WebElement> options = driver.findElements(By.cssSelector(
					"#nav-flyout-shopAll > div.nav-subcats > div:nth-child(" + optionsListCode + ") a>span.nav-text"));
			for (WebElement givenOption : options) {
				if (givenOption.getText().equals(optionsLinkText)) {
					seHoverOnElement(givenOption, optionsLinkText);
					seClickOnElement(givenOption, optionsLinkText);
					OptionFound = true;
					Log.info("Successfully selected option: " + optionsLinkText);
					break;
				}
			}

			if (OptionFound == false) {
				Log.info("Unable of find given option: " + optionsLinkText
						+ ". Please check the LinkText of given option");
			}

		} catch (Exception e) {
			Log.error(
					"Exception occured while selecting the SubDepartment : " + optionsLinkText + " " + e.getMessage());
		}
	}
	
}
