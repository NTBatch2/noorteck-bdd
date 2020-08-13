package com.noorteck.qa.steps;

import org.testng.Assert;

import com.noorteck.qa.base.BaseClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountStepDefinition extends BaseClass {

	@When("User enters username {string}")
	public void user_enters_username(String username) {
		loginObj.enterUserName(username);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
		loginObj.enterPassword(password);

	}

	@Then("User able to view {string}")
	public void user_able_to_view(String pageText) {

		Assert.assertEquals(dashboardObj.getDashboardTitle(), pageText);

	}

	@Then("User able to view account name {string}")
	public void user_able_to_view_account_name(String accountName) {
		Assert.assertEquals(dashboardObj.getAccountName(), accountName);

	}

}
