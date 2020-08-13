package com.noorteck.qa.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;



public class PutDemo {

	public static void main(String[] args) {
		
		String uri = "https://reqres.in/api/users/2";
		String requestBody = "{ \"name\": \"Denis\", \"job\": \"SDET\" }";
		
		//Create Response obj
		Response response;
		
		
		response = given()
						.queryParam("city", "reston")
						.header("x-rapidapi-host","restcountries-v1.p.rapidapi.com")
						.header("x-rapidapi-key", "b42bf2a0f0msh9f2ced883e4e79ep1c821bjsn899a3c43ec0c")
						.contentType(ContentType.JSON)
						.body(requestBody)
					.when()
						.put(uri)
					.then()
						.extract()
						.response();
		
		response.prettyPrint();
		
		SoftAssert softAssert = new SoftAssert();	
		softAssert.assertEquals(200, response.getStatusCode());

		JsonPath jsonPath = response.jsonPath();

		softAssert.assertEquals(jsonPath.getString("name"), "Denis");
		softAssert.assertEquals(jsonPath.getString("job"), "SDET");

		softAssert.assertTrue(jsonPath.getString("updatedAt").contains("2020"));
		softAssert.assertAll();

	}

}
