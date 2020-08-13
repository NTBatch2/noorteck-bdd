package com.noorteck.qa.utils;

import java.util.List;
import java.util.Map;

import com.noorteck.qa.base.BaseClass;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;

public class Webservice extends BaseClass {
		 
	/**
	 * This method sets up the header before sending the request
	 * @param dataTable
	 */
	public static void setUpHeaders(DataTable dataTable) {
		// Convert data table to List Map
		List<Map<String, String>> listMap = dataTable.asMaps(String.class, String.class);

		// Convert List Map to a Map
		for (Map<String, String> map : listMap) {
			headersMap = map;
		}

		if (headersMap != null) {
			request = request.headers(headersMap);
		}
	}
		
	/**
	 * This method sets up the query parameter before sending the request
	 * @param dataTable
	 */
	public static void setUpQueryParameter(DataTable dataTable) {
	
		// Convert data table to List Map
		List<Map<String, String>> listMap = dataTable.asMaps(String.class, String.class);

		// Convert List Map to a Map
		for (Map<String, String> map : listMap) {
			qParamMap = map;
		}

		if (qParamMap != null) {
			request = request.queryParams(qParamMap);
		}
	}
	
	/**
	 * This method sends get request
	 */
	public static void getRequest() {
		
		response = request
					.when()
						.get(webApiMap.get("endpoint"))
					.then()
						.extract()
						.response();
		
		response.prettyPrint();
	}
	
	
	/**
	 * This method sends postRequest
	 */
	public static void postRequest() {
		
		response = request
					.contentType(ContentType.JSON)
					.body(webApiMap.get("requestBody"))
					.when()
						.post(webApiMap.get("endpoint"))
					.then()
						.extract()
						.response();
		
		response.prettyPrint();
	}
	
	
	
	
	/**
	 * This method sends putRequest
	 */
	public static void putRequest() {
		
		response = request
					.contentType(ContentType.JSON)
					.body(webApiMap.get("requestBody"))
					.when()
						.put(webApiMap.get("endpoint"))
					.then()
						.extract()
						.response();
		
		response.prettyPrint();
	}
	
	
	/**
	 * This method returns the status code of webservice response
	 * @return
	 */
	public static int statusCodeValidation() {
		
		System.out.println(response.getStatusCode());
		
		return response.getStatusCode();
	}
}
