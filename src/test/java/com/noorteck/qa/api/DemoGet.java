package com.noorteck.qa.api;

import static io.restassured.RestAssured.given;

import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DemoGet {

	public static void main(String[] args) {
		
		String uri = "https://reqres.in/api/users/2";
		
		int expStatusCode = 200;
		String expId = "2";
		String expFirstName = "Janet";
		String expLastName = "Weaver";
		String expCompany = "StatusCode Weekly";
		
		
		//Create Response object
		Response response;		
		//Sending get request and storing the Server response to response object
		response=	given()

					.when()
						.get(uri) 
					.then()
						.extract()
						.response();
						 
		//PrettyPrint() just prints the response in json format
		response.prettyPrint();		
		
		int actualStatusCode = response.getStatusCode(); //get the status code
				
	//	System.out.println("Status Code: "+ statusCode);
			
	//	System.out.println(response.getStatusLine()); //get the status code with message/description
				
		//create a jsonPath obj 
		JsonPath jsonPath = response.jsonPath();
		
		String actualId = jsonPath.getString("data.id");
		
		System.out.println("ID: "+ actualId);
				
		//firstname
		//lastname
		//company
		String actualFirstName = jsonPath.getString("data.first_name");
		String actualLastName = jsonPath.getString("data.last_name");
		String actualCompany = jsonPath.getString("ad.company");
		
		
		SoftAssert softAssert = new SoftAssert();
	
		softAssert.assertEquals(expStatusCode, actualStatusCode);

		softAssert.assertEquals(actualId, expId);
		softAssert.assertEquals(actualFirstName, expFirstName);
		softAssert.assertEquals(actualLastName, expLastName);
		softAssert.assertEquals(actualCompany, expCompany);	
		softAssert.assertAll();
		
	}
}









/**
 * 
 * 			GIVEN   ---> precondition
 * 
 * 			WHEN    ---> action performed
 * 
 * 			THEN   ----> outcome
 * 
 */