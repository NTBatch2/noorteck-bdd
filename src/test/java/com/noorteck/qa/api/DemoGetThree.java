package com.noorteck.qa.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DemoGetThree {
	public static void main(String[] args) {
		String uri = "https://restcountries-v1.p.rapidapi.com/name/usa";
		
		//create Response object
		Response response;
		
		
		response = given()
						.header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
						.header("x-rapidapi-key","b42bf2a0f0msh9f2ced883e4e79ep1c821bjsn899a3c43ec0c")
					.when()
						.get(uri)				
					.then()
						.extract()
						.response();
		
		
	
		response.prettyPrint();
		
		System.out.println(response.getStatusCode());
	}

}
