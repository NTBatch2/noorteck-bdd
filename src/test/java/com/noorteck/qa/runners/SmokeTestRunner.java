package com.noorteck.qa.runners;
 
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/ntk360/", 
		glue = {"com.noorteck.qa.steps"},
		plugin  = { "pretty", 
					"html:target/cucumber-reports.html",
					"json:target/cucumber.json"}, 
		monochrome = true,
		tags = "@smoke"
	 
		
		)


public class SmokeTestRunner extends AbstractTestNGCucumberTests{
	
}
