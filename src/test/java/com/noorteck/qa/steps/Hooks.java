package com.noorteck.qa.steps;

import java.util.List;
import java.util.Map;

import com.noorteck.qa.base.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class Hooks extends BaseClass {

	@Before
	public void setUp(Scenario scenario) {
		System.out.println("Test Environment set up");
		System.out.println("Executing Test Scenario: [" + scenario.getName() + "]");
		setUp();

	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("Finished Exeucting Test Scenario: [" + scenario.getName() + "]");
		tearDown();
	}

	@Given("User is logged in and in NTK Dashboard page")
	public void login() {
		loginObj.login();

	}

	@Given("User provides environment data")
	public void setEnvData(DataTable dataTable) {

		// Convert data table to List Map
		List<Map<String, String>> listMap = dataTable.asMaps(String.class, String.class);

		// Convert List Map to a Map
		for (Map<String, String> map : listMap) {

			envDataMap.put("project", map.get("project"));
			envDataMap.put("region", map.get("region"));
			envDataMap.put("sprint", map.get("sprint"));
			envDataMap.put("usNumber", map.get("usNumber"));

		}
	}

}
