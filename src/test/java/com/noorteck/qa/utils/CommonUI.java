package com.noorteck.qa.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUI extends Constants {

	/**
	 * This method
	 * 
	 * @param browser
	 */

	public static void openBrowser(String browser) {
		System.out.println(browser);
		try {
			switch (browser.toLowerCase()) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;

			default:

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("We do not support [" + browser + "] browser. Make sure to pass [chrome, firefox, or ie]");
		}
	}

	/**
	 * This method takes 1 string parameter, sets implicit wait, maximizes page, and
	 * navigates to the web-page
	 * 
	 * @param url
	 */
	public static void navigate(String url) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);

		} catch (Exception e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Check the [" + url + "] URL, make sure it contains proper format");

		}
	}

	/**
	 * This method takes 1 webElement parameter and checks if it is displayed or not
	 * 
	 * @param element
	 * @return
	 */

	public static boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();

		} catch (NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Element does not exits, it is not displayed: " + element);

			return false;
		}
	}

	/**
	 * This method takes 1 webElement parameter and checks if it is selected or not
	 * 
	 * @param element
	 * @return
	 */

	public static boolean isSelected(WebElement element) {
		try {
			return element.isSelected();

		} catch (NoSuchElementException e) {

			e.printStackTrace();

			Assert.assertTrue(false, "Element does not exits, cannot select: " + element);
			return false;
		}
	}

	/**
	 * This method takes 1 webElement parameter and checks if it is enabled or not
	 * 
	 * @param element
	 * @return
	 */

	public static boolean isEnabled(WebElement element) {
		try {
			return element.isEnabled();

		} catch (NoSuchElementException e) {

			e.printStackTrace();

			Assert.assertTrue(false, "Element does not exits, is not enabled " + element);

			return false;
		}
	}

	/**
	 * This method takes 1 WebElement parameter and performs click operation if
	 * element is displayed
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {

		if (isDisplayed(element)) {
			element.click();
		}
	}

	/**
	 * This method takes 1 WebElement parameter and returns the visible text on
	 * web-page
	 * 
	 * @param element
	 * @return
	 */

	public static String getText(WebElement element) {
		String text = null;

		if (isDisplayed(element)) {
			text = element.getText();
		}

		return text;
	}

	/**
	 * This method return the title of the page
	 * 
	 * @return
	 */
	public static String getTitle() {
		String titleStr = null;
		try {
			titleStr = driver.getTitle();

		} catch (Exception e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Driver instance is NULL");
		}
		return titleStr;
	}

	// handle drop down
	/**
	 * drop downs -- select tag can be accessed by selectByIndex,
	 * selectByVisiualText, selectByValue
	 * 
	 */

	public static void selectFromDropdown(WebElement element, String methodName, String indexTextValue) {

		try {
			Select sObj = new Select(element);
			String methodStr = methodName.toLowerCase(); // convert method

			if (methodStr.contains("index")) {

				int index = Integer.parseInt(indexTextValue);// convert String number to integer type
				sObj.selectByIndex(index);

			} else if (methodStr.contains("value")) {

				sObj.selectByValue(indexTextValue);

			} else if (methodStr.contains("text")) {

				sObj.selectByVisibleText(indexTextValue);
			} else {

				Assert.assertTrue(false,
						"Drop down can be selected only with [index, value, or text] check parameters passed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Unable to find the web element ");
		}
	}

	/**
	 * This method quits the driver instance
	 */
	public static void quitBrowser() {

		try {
			Thread.sleep(3000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "Driver object is null ");
		}
	}

	/**
	 * This method checks if alert is present
	 * 
	 * @return
	 */

	public static boolean isAlertPresent() {
		boolean isAlert = false;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);

			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				isAlert = true;
			}

		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present ");
			e.printStackTrace();
		}
		return isAlert;
	}

	/**
	 * This method accepts the alert
	 */
	public static void acceptAlert() {

		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}

	/**
	 * This method dismiss the alert
	 */
	public static void dismissAlert() {

		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		}
	}

	/**
	 * This method takes two parameters and enters value to the field
	 * 
	 * @param element
	 * @param value
	 */

	public static void enter(WebElement element, String value) {

		if (isDisplayed(element)) {
			element.clear();
			element.sendKeys(value);
		}
	}

}
