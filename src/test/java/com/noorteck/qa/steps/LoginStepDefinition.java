package com.noorteck.qa.steps;

import org.testng.Assert;

import com.noorteck.qa.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends BaseClass {

	@Given("User is on NTK login page")
	public void loginPage() {
		setUp();
	}

	@When("User enters valid credentials")
	public void enterCredentials() {
		loginObj.enterUserName();
		loginObj.enterPassword();
	}

	@When("User clicks login button")
	public void clickLogin() {
		loginObj.clickLogin();
	}

	@Then("User is on dashboard page")
	public void dashboardPage() {

		Assert.assertEquals(dashboardObj.getDashboardTitle(), "Dashboard");

		// close the browser
		// tearDown();

	}

	@Then("System displays the pending timesheet icon")
	public void system_displays_the_pending_timesheet_icon() {

		Assert.assertTrue(dashboardObj.isPendTimeSheetIconVisible(), "Pending Timesheet icon is not visible");
	}

	@Then("System displays the pending leave request icon")
	public void system_displays_the_pending_leave_request_icon() {
		Assert.assertTrue(dashboardObj.isPendLeaveRequIconVisible(), "Pending Leave Request icon is not visible");

	}

	@Then("System displays the Scheduled Recruitment Event icon")
	public void system_displays_the_scheduled_recruitment_event_icon() {
		Assert.assertTrue(dashboardObj.isScheduleRecIconVisible(), "Schedule Recruitment Event icon is not visible");

	}

}
