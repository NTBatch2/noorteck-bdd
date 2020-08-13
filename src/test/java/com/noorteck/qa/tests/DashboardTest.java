package com.noorteck.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.noorteck.qa.base.BaseClass;

public class DashboardTest extends BaseClass {

	@Ignore // appraoch 1 --> ok way
	public void accountNameTest2() {
		SoftAssert softAssert = new SoftAssert();

		String expTitle = "Dashboard";
		String expAccountName = "Jacqueline White";

		loginObj.enterUserName();
		loginObj.enterPassword();
		loginObj.clickLogin();

		String actualTitle = dashboardObj.getDashboardTitle();
		String actualAccountName = dashboardObj.getAccountName();

		System.out.println(actualTitle);
		System.out.println(actualAccountName);

		softAssert.assertEquals(actualTitle, expTitle);
		softAssert.assertEquals(actualAccountName, expAccountName);

		softAssert.assertAll();
	}

	@Ignore // approach 2 ---> preferred way
	public void accountNameTest() {
		SoftAssert softAssert = new SoftAssert();

		loginObj.login();

		softAssert.assertEquals(dashboardObj.getDashboardTitle(), "Dashboard");
		softAssert.assertEquals(dashboardObj.getAccountName(), "Jacqueline White");
		softAssert.assertAll();
	}

	@Ignore
	public void pendTimeDisplayTest() {
		loginObj.login();
		Assert.assertTrue(dashboardObj.isPendTimeSheetIconVisible(), "Pending Timesheet icon is not visible");
	}

	@Ignore
	public void pendLeaveReqDisplayTest() {

		loginObj.login();

		Assert.assertTrue(dashboardObj.isPendLeaveRequIconVisible(), "Pending Leave Request Icon is not visible");

	}

	@Ignore
	public void scheduleRecEventDisplayTest() {

		loginObj.login();
		Assert.assertTrue(dashboardObj.isScheduleRecIconVisible(), "Schedule Recruiter Icon is not visible");
	}

	@Test
	public void signOutTest() throws InterruptedException {
		loginObj.login();

		dashboardObj.clickUserMenuDropdown();
		
		Thread.sleep(2000);
		dashboardObj.clickLogOutOption();

		Assert.assertTrue(loginObj.isLoginButtonVisible(), "We are not in Sign-in page");
	}
	
	

}
