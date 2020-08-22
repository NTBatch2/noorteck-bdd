package com.noorteck.qa.runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//surefire:test -Dtest=com\noorteck\qa\runners\SmokeTestRunner -DfailIfNoTests=false
@CucumberOptions(
		features = "src/test/resources/ntk360/SmokeTest.feature", 
		glue = {"com.noorteck.qa.steps"},
		plugin  = { "pretty", 
					"html:target/cucumber-reports.html",
					"json:target/cucumber.json"}, 
		monochrome = true,
		tags = "@smoke"
		
		)

public class SmokeTestRunner {
}
