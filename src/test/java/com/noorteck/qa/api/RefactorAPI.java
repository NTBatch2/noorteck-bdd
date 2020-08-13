package com.noorteck.qa.api;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RefactorAPI {
	
	
	public static void main(String[] args) {
		
		String name = "Denis";
		
		if(name != null) {
			name = name.toUpperCase();
			
		}
		 
	}
	
	public static void requestMethod() {
		Map<String, String> qParamsMap = new HashMap<String, String>();
		Map<String, String> headersMap = new HashMap<String, String>();
		Response response;
		String uri = "https://us-zipcode.api.smartystreets.com/lookup";
		
		RequestSpecification request = given().contentType(ContentType.JSON);
				 
		
		if(qParamsMap != null) {
			request = request.queryParams(qParamsMap);
		}
		
		if(headersMap != null) {
			request = request.headers(headersMap);
		}
		
		response = request.when()
							.get(uri)
						.then()
							.extract()
							.response();
		
		
		
	}
	
	/**
	 * When we send request GET/POST/PUT     contentType(ContenType.JSON)
	 */
	
	
	
	
	
	public static void getMethodwithQueryParam() {
		String uri = "https://us-zipcode.api.smartystreets.com/lookup";
		Map<String, String> queryMap = new HashMap<String, String>();
		
		queryMap.put("auth-id", "61f926d0-4996-13a8-c0ff-be05d212a694");
		queryMap.put("auth-token", "Vhz4zNp7uJ7BMq4BTTmm");
		queryMap.put("city", "reston");
		queryMap.put("state", "VA");
		queryMap.put("zipcode", "20190");
			
		//create response obj
		Response response;
		
			response = given()
							.queryParams(queryMap)
						.when()
							.get(uri)
						.then()
							.extract()
							.response();
						
			response.prettyPrint();
			
			System.out.println(response.getStatusCode());
	}
	
	
	
	public static void getMethodWIthHeaderAndQParam() {
		String uri = "https://reqres.in/api/users/2";
		String requestBody = "{ \"name\": \"Denis\", \"job\": \"SDET\" }";
		Map<String, String> queryMap = new HashMap<String, String>();
		Map<String, String> headerMap = new HashMap<String, String>();
		
		
		
		queryMap.put("city", "reston");
		headerMap.put("x-rapidapi-host","restcountries-v1.p.rapidapi.com");
		headerMap.put("x-rapidapi-key", "b42bf2a0f0msh9f2ced883e4e79ep1c821bjsn899a3c43ec0c");
		

		//Create Response obj
		Response response;
		
		response = given()
					.queryParams(queryMap)
					.headers(headerMap)
					.contentType(ContentType.JSON)
					.body(requestBody)
				.when()
					.put(uri)
			    .then()
					.extract()
					.response();

			response.prettyPrint();
		
	}
}
