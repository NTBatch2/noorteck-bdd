package com.noorteck.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.noorteck.qa.base.BaseClass;

public class SalaryComponentTest extends BaseClass {

	@Test
	public void addSalaryTest() {

		loginObj.login();

		jobTitlesObj.clickAdminMenu();
		jobTitlesObj.clickJobMenu();
		salCompObj.clickSalaryComponent();
		salCompObj.clickAddIcon();
		salCompObj.enterComponentName("Selenium_ORDER");
		salCompObj.clickDeductionRadio();
		salCompObj.clickTotalPayRadio();
		salCompObj.clickCostToCompCheckbox();
		salCompObj.clickPercentageCheckbox();
		salCompObj.clickAmountCheckbox();
		salCompObj.clickSave();

		Assert.assertTrue(salCompObj.isSuccessMessageDisp());

	}

	@Test
	public void addSalaryTest2() {

		loginObj.login();

		jobTitlesObj.clickAdminMenu();
		jobTitlesObj.clickJobMenu();
		salCompObj.clickSalaryComponent();
		salCompObj.clickAddIcon();
		salCompObj.clickAmountCheckbox();
		salCompObj.clickPercentageCheckbox();
		salCompObj.clickTotalPayRadio();
		salCompObj.enterComponentName("Selenium_Unorder");
		salCompObj.clickDeductionRadio();

		salCompObj.clickCostToCompCheckbox();

		salCompObj.clickSave();

		Assert.assertTrue(salCompObj.isSuccessMessageDisp());

	}

}
