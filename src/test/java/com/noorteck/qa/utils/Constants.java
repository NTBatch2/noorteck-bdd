package com.noorteck.qa.utils;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.noorteck.qa.pages.DashboardPage;
import com.noorteck.qa.pages.JobTitlesPage;
import com.noorteck.qa.pages.LoginPage;
import com.noorteck.qa.pages.SalaryComponentPage;
import com.noorteck.qa.pages.UsersPage;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class Constants {

	public static WebDriver driver;
	
	public static Properties prop;
	public static String configFilePath = "./src/test/resources/configs/configs.properties";
	
	//Create static object of each webPage	
	public static LoginPage loginObj;
	public static DashboardPage dashboardObj;
	public static SalaryComponentPage salCompObj;
	public static JobTitlesPage jobTitlesObj;
	public static UsersPage usersObj;
	
	
 
	
	//Create Web service API objects
	public static  Map<String, String> webApiMap = new HashMap<String, String>();

	public static  Map<String, String> headersMap = new HashMap<String, String>();
	public static  Map<String, String> qParamMap = new HashMap<String, String>();

	public static RequestSpecification  request =  given();
	public static Response response;
	public static SoftAssert apiSoftAssert = new SoftAssert();
	
	
	//DB class objects
	public static  Statement stm;
	public static  Connection con;
	public static  ResultSet rs;
	
	
	public static  Map<String, String> envDataMap = new HashMap<String, String>();
	
	
  }
