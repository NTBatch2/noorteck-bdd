package com.noorteck.qa.webservice;

import com.noorteck.qa.base.BaseClass;
import com.noorteck.qa.utils.Webservice;

import io.restassured.path.json.JsonPath;

public class AddressLookupAPI extends BaseClass {

	public static void validateResponseBody() {

		JsonPath jsonPath = response.jsonPath();

		apiSoftAssert.assertEquals(jsonPath.getString("city_states[0].city[0]"), qParamMap.get("city"));
		apiSoftAssert.assertEquals(jsonPath.getString("city_states[0].state_abbreviation[0]"), qParamMap.get("state"));
		
		apiSoftAssert.assertAll();
	}

}
