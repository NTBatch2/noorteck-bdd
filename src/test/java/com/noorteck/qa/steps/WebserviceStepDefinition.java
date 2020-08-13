package com.noorteck.qa.steps;

import com.noorteck.qa.base.BaseClass;
import com.noorteck.qa.utils.Webservice;
import com.noorteck.qa.webservice.AddressLookupAPI;
import com.noorteck.qa.webservice.UsersAPI;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebserviceStepDefinition extends BaseClass {
	@Given("User wants to make webservice {string} {string} request")
	public void setApiName(String apiName, String endpoint) {
		webApiMap.put("apiName", apiName);
		webApiMap.put("endpoint", endpoint);
	}
	
	@When("User sets Header parameters")
	public void setHeadersData(DataTable dataTable) {
		Webservice.setUpHeaders(dataTable);
	}
	
	@When("User sets Query parameters")
	public void setQueryParamData(DataTable dataTable) {
		Webservice.setUpQueryParameter(dataTable);
	}

	@When("User sends GET request")
	public void makeGETRequest() {
		Webservice.getRequest();
	}

	@When("User sends POST request \"{string}\"")
	public void makePOSTRequest(String requestBody) {
		webApiMap.put("requestBody", requestBody);
		Webservice.postRequest();
	}
	
	
	@When("User sends PUT request \"{string}\"")
	public void makePUTRequest(String requestBody) {
		webApiMap.put("requestBody", requestBody);
		Webservice.putRequest();
	}


	@Then("User recieves status code {string}")
	public void verifyStatus(String expStatusCodeStr) {
		int expStatusCode = Integer.parseInt(expStatusCodeStr);
		int actualStatusCode = Webservice.statusCodeValidation();
		apiSoftAssert.assertEquals(expStatusCode, actualStatusCode);
	}
 
	@Then("User validates response body")
	public void validateResponse() {
		
		try {
			
			switch (webApiMap.get("apiName")) {
			case "addressLookup":
				AddressLookupAPI.validateResponseBody();
				break;

			case "userList":
				//create a class that handles the business logic
				UsersAPI.validateUserResponseBody();
				break;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
	}
}
