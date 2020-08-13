package com.noorteck.qa.steps;

import java.util.List;
import java.util.Map;

import com.noorteck.qa.base.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class DatatableExStepDefinition extends BaseClass {

	@When("User provides job title data")
	public void user_provides_job_title_data(DataTable dataTable) {

		// Convert data table to List Map
		List<Map<String, String>> listMap = dataTable.asMaps(String.class, String.class);

		// Convert List Map to a Map
		for (Map<String, String> map : listMap) {

			// use get() method to retrieve the value by passing the key
			jobTitlesObj.enterJobTitleName(map.get("JobTitle"));
			jobTitlesObj.enterJobDescription(map.get("JobDescription"));
			jobTitlesObj.enterNote(map.get("Note"));

		}
	}
}
