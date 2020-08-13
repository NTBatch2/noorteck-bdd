package com.noorteck.qa.api;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DemoGetTwo {
	public static void main(String[] args) {
		
		String uri = "https://reqres.in/api/users";
		
		//Create Response object
		
		Response response;
		
			
		response  = 	given()
							.queryParam("page", "2")
						.when()
							.get(uri)	
						.then()
							.extract()
							.response();
				 
		
		response.prettyPrint();

		System.out.println(response.getStatusCode());
		
		JsonPath jsonPath =  response.jsonPath();
		
		
		System.out.println("The answer:... " + jsonPath.getString("data.id"));
		

		System.out.println("diff answer:... " + jsonPath.getString("data.id[2]"));		
		System.out.println("give me the answer.." + jsonPath.getString("total"));
	}

}
