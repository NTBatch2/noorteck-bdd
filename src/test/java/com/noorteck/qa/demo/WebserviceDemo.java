package com.noorteck.qa.demo;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
public class WebserviceDemo {

	public static void main(String[] args) {
		
		Response response;
		 String requestBody ="[{\"city\":\"reston\", \"state\":\"VA\"}]";
		System.out.println(requestBody);
		response = 
				given()
				 	.contentType(ContentType.JSON)
					.queryParam("auth-id", "61f926d0-4996-13a8-c0ff-be05d212a694")
					.queryParam("auth-token","Vhz4zNp7uJ7BMq4BTTmm")
					.body(requestBody)
					
					
				.when()
					.post("https://us-zipcode.api.smartystreets.com/lookup")
				.then()
				.extract()
				.response();
	  
		response.prettyPrint();
		
		
		
		
	}
	
	 public static void getRequest1() {
			Response response;
			String pathParameter = "2";
			
			response = 
					given()
						  
						
					.when()
						.get("https://reqres.in/api/users/"+pathParameter)
					.then()
					.extract()
					.response();
		  
			response.prettyPrint();
	 }
	 
	 public static void getRequest2QueryParam() {
			Response response;
			 
			
			response = 
					given()
						 .param("page", "2")
						
					.when()
						.get("https://reqres.in/api/users")
					.then()
					.extract()
					.response();
		  
			response.prettyPrint();
	 }
	 
	 public static void getRequest3WithHeader() {
		 Response response;
		 
			
			response = 
					given()
						 .header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
						 .header("x-rapidapi-key","b42bf2a0f0msh9f2ced883e4e79ep1c821bjsn899a3c43ec0c")
						
						
					.when()
						.get("https://restcountries-v1.p.rapidapi.com/name/usa")
					.then()
					.extract()
					.response();
		  
			response.prettyPrint();
	 }
	 
	 public static void getRequest4WithParam() {
		 Response response;
		 
			
			response = 
					given()
					 
						.queryParam("auth-id", "61f926d0-4996-13a8-c0ff-be05d212a694")
						.queryParam("auth-token","Vhz4zNp7uJ7BMq4BTTmm")
						.queryParam("city","reston")
						.queryParam("state","VA")
						.queryParam("zipcode","20191")
						
						
					.when()
						.get("https://us-zipcode.api.smartystreets.com/lookup")
					.then()
					.extract()
					.response();
		  
			response.prettyPrint();
	 }
	 
	 public static void postwithQuery() {
			Response response;
			 String requestBody ="[{\"city\":\"reston\", \"state\":\"VA\"}]";
			System.out.println(requestBody);
			response = 
					given()
					 	.contentType(ContentType.JSON)
						.queryParam("auth-id", "61f926d0-4996-13a8-c0ff-be05d212a694")
						.queryParam("auth-token","Vhz4zNp7uJ7BMq4BTTmm")
						.body(requestBody)
						
						
					.when()
						.post("https://us-zipcode.api.smartystreets.com/lookup")
					.then()
					.extract()
					.response();
		  
			response.prettyPrint();
	 }

}
