package com.noorteck.qa.steps;

import com.noorteck.qa.base.BaseClass;

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

}
