package com.noorteck.qa.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DemoGetFour {
	
	public static void main(String[] args) {
		
		String uri = "https://us-zipcode.api.smartystreets.com/lookup";
		
		//create response obj
		Response response;


		response = given()
						.queryParam("auth-id", "61f926d0-4996-13a8-c0ff-be05d212a694")
						.queryParam("auth-token", "Vhz4zNp7uJ7BMq4BTTmm")
						.queryParam("city", "reston")
						.queryParam("state", "VA")
						.queryParam("zipcode", "20190")
				   .when()
				   		.get(uri)
				   .then()
				   		.extract()
				   		.response();
		
		
		response.prettyPrint();
		
		System.out.println(response.getStatusCode());
		
	}
	
	

}
