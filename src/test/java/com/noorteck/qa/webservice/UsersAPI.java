package com.noorteck.qa.webservice;

import com.noorteck.qa.base.BaseClass;

import io.restassured.path.json.JsonPath;

public class UsersAPI  extends BaseClass  {
	
	public static void validateUserResponseBody() {
		JsonPath jsonPath = response.jsonPath();
		
		
		apiSoftAssert.assertEquals(jsonPath.getString("name"), "Denis II");
		apiSoftAssert.assertEquals(jsonPath.getString("job"), "SDET");


		apiSoftAssert.assertAll();
	}
	

}
