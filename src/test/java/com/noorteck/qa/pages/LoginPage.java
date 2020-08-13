package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.base.BaseClass;

public class LoginPage extends BaseClass {

	// username field
	@FindBy(id = "txtUsername")
	WebElement userNameField;

	// password field
	@FindBy(id = "txtPassword")
	WebElement passwordField;

	// login button
	@FindBy(name = "Submit")
	WebElement loginButton;

	// Step2. Create Constructor for your class

	public LoginPage() {
		PageFactory.initElements(driver, this); // LoginPage.class
	}

	// Step 3. Create methods to perform action with above web elements

	public void enterUserName() {
		enter(userNameField, prop.getProperty("username"));
	}

	public void enterPassword() {
		enter(passwordField, prop.getProperty("password"));
	}

	public void clickLogin() {
		click(loginButton);
	}

	public void login() {
		enterUserName();
		enterPassword();
		clickLogin();
	}

	public boolean isLoginButtonVisible() {
		return isDisplayed(loginButton);
	}

	public void enterUserName(String username) {
		enter(userNameField, username);
	}

	public void enterPassword(String password) {
		enter(passwordField, password);
	}

}
