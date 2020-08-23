package com.noorteck.qa.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.noorteck.qa.pages.DashboardPage;
import com.noorteck.qa.pages.JobTitlesPage;
import com.noorteck.qa.pages.LoginPage;
import com.noorteck.qa.pages.SalaryComponentPage;
import com.noorteck.qa.pages.UsersPage;
import com.noorteck.qa.utils.CommonUI;
import com.noorteck.qa.utils.NTKdb;
import com.noorteck.qa.utils.ReadPropertyData;

public class BaseClass extends CommonUI {
//abcabc test test
//	@BeforeMethod TODO use @BeforeMethod annotation if your project using TestNG not Cucumber
	public void setUp() {

		prop = ReadPropertyData.getProperties(configFilePath);
		NTKdb.connectToDB();
		openBrowser(prop.getProperty("browser"));
		navigate(prop.getProperty("url"));

		initializeClassObj();
	}

//	@AfterMethod TODO use @AfterMethod annotation if your project using TestNG not Cucumber
	public void tearDown() {
		quitBrowser();
		NTKdb.closeDBConnections();
	}

	public void initializeClassObj() {
		loginObj = new LoginPage();
		dashboardObj = new DashboardPage();
		salCompObj = new SalaryComponentPage();
		jobTitlesObj = new JobTitlesPage();
		usersObj = new UsersPage();
	}
}
