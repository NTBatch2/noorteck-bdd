package com.noorteck.qa.steps;

import java.sql.SQLException;

import com.noorteck.qa.base.BaseClass;
import com.noorteck.qa.utils.NTKdb;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DbBExampleStep extends BaseClass{

	@When("User provides db job title data")
	public void enterJobTitleData() {
		String query = "SELECT * FROM jobTitles LIMIT 1";
		try {
			NTKdb.retrieveResultSet(query);
			
			while(rs.next()) {
				
				jobTitlesObj.enterJobTitleName("qq" +rs.getString("title"));
				jobTitlesObj.enterJobDescription(rs.getString("description"));
				jobTitlesObj.enterNote(rs.getString("note"));
				
				
			}
		} catch (SQLException e) {
 			e.printStackTrace();
		}
	}

	@Then("User updates execution result in db")
	public void insertExecutionResult() {
		NTKdb.insertTestExecutionResult("Passed", "NULL");
	}

}
