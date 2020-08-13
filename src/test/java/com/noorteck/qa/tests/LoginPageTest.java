package com.noorteck.qa.tests;

import org.testng.annotations.Test;

import com.noorteck.qa.base.BaseClass;

public class LoginPageTest extends BaseClass {

	@Test
	public void testOne() {
		
		loginObj.enterUserName();
		loginObj.enterPassword();
		loginObj.clickLogin();
		
	}
}
