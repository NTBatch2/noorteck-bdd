package com.noorteck.qa.steps;

import org.testng.Assert;

import com.noorteck.qa.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobTitlesStepDefinition extends BaseClass {

	@Given("User is logged in on the dashboard page")
	public void user_is_logged_in_on_the_dashboard_page() {
		setUp();
		loginObj.login();
	}

	@When("User navigates to Job Titles")
	public void user_navigates_to_job_titles() {
		jobTitlesObj.clickAdminMenu();
		jobTitlesObj.clickJobMenu();
		jobTitlesObj.clickJobTitlesMenu();
	}

	@When("User clicks on the Add icon")
	public void user_clicks_on_the_add_icon() {
		jobTitlesObj.clickAddIcon();

	}

	@When("User provides job title data {string}, {string}, {string}")
	public void user_provides_job_title_data(String jobTitle, String jobDescription, String note) {
		jobTitlesObj.enterJobTitleName(jobTitle);
		jobTitlesObj.enterJobDescription(jobDescription);
		jobTitlesObj.enterNote(note);
	}

	@When("User clicks save button")
	public void user_clicks_save_button() {
		jobTitlesObj.clickSaveButton();
	}

	@Then("System displays successfuly message {string}")
	public void system_displays_successfuly_message(String successMessage) {
		Assert.assertEquals(jobTitlesObj.getSuccessMessage(), successMessage);
	}

	@When("User clicks on the Edit icon") 
	public void user_clicks_on_the_edit_icon() {
		jobTitlesObj.clickEditIcon();
	}
}
