package com.noorteck.qa.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class DemoPost {
	
	public static void main(String[] args) {
		
		String uri = "https://us-zipcode.api.smartystreets.com/lookup";
		String bodyStr = "[{\"city\":\"reston\", \"state\":\"VA\"}]";
		
		//Response object
		Response response;
		
		
		response = 	given()
						.queryParam("auth-id", "61f926d0-4996-13a8-c0ff-be05d212a694")
						.queryParam("auth-token", "Vhz4zNp7uJ7BMq4BTTmm")
						.contentType(ContentType.JSON)
						.body(bodyStr)
				
					.when()
						.post(uri)
					.then()
						.extract()
						.response();
					
		
		response.prettyPrint();
		
		//display city name
		//display all the zipcodes
		//display countyName for zipcode that has value 20190
		

		JsonPath jsonPath =  response.jsonPath();
		
	 
		System.out.println("city name: " + jsonPath.getString("city_states.city"));
		
		System.out.println("all the zipcodes: " + jsonPath.getString("zipcodes.zipcode"));
	
		System.out.println("countYname for zipcode 20190: " + jsonPath.getString("zipcodes.county_name[0]"));
		System.out.println("countYname for zipcode 20190: " + jsonPath.getString("zipcodes[0].county_name[0]"));
		System.out.println("countYname for zipcode 20190: " + jsonPath.getString("zipcodes[1].county_name[0]"));

		
	}
}
