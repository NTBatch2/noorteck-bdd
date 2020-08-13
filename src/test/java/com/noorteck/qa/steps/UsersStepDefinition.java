package com.noorteck.qa.steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.noorteck.qa.base.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersStepDefinition extends BaseClass {

	@When("User navigates to Users page")
	public void user_navigates_to_users_page() {
		usersObj.clickUsersMenu();
	}

	@Then("User verifies employee data {string},{string}")
	public void user_verifies_employee_data(String expEmpName, String expUsername) {

		System.err.println(usersObj.isUsernameAndEmpNameMatch(expEmpName, expUsername));

		Assert.assertTrue(usersObj.isUsernameAndEmpNameMatch(expEmpName, expUsername),
				"Employee name and username does not match");
	}

	@Then("User verifies employee data")
	public void user_verifies_employee_data(DataTable dataTable) {
		// Convert data table to List Map
		List<Map<String, String>> listMap = dataTable.asMaps(String.class, String.class);
		SoftAssert sofAssert = new SoftAssert();
		// Convert List Map to a Map
		for (Map<String, String> map : listMap) {

	 
			System.err.println(usersObj.isUsernameAndEmpNameMatch(map.get("EmployeeName"), map.get("Username")));

			sofAssert.assertTrue(usersObj.isUsernameAndEmpNameMatch(map.get("EmployeeName"), map.get("Username")),
					"Employee name and username does not match: ");
		}
		
		sofAssert.assertAll();
	}

}
