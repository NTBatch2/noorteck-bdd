package com.noorteck.qa.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.noorteck.qa.base.BaseClass;

public class NTKdb extends BaseClass{


	public static void connectToDB() {
		try {
			// Load the Driver
			Class.forName(prop.getProperty("dbDriverName"));
			
			// Create connection with database
			con = DriverManager.getConnection(	prop.getProperty("dbURL"), 
												prop.getProperty("dbUsername"), 
												prop.getProperty("dbPassword"));	
			
			// create statement object
			stm = con.createStatement();
						
		} catch (Exception e) {
			System.out.println("Could not establish connection with DB");
			e.printStackTrace();
		}
	}
	
	/**
	 * This method takes query and retrieves the result set
	 * 
	 * @param query
	 * @return
	 */
	public static ResultSet retrieveResultSet(String query){

		try {

			rs = stm.executeQuery(query);

		} catch (Exception e) {
			System.out.println("Couldnot retireve data from table");
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * This method takes query and inserts in DB table
	 * 
	 * @param query
	 * @return
	 */
	public static void insertToDBTable(String query) {

		try {

			stm.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Couldnot insert data into table");
			e.printStackTrace();
		}
 
	}

	
	/**
	 * This method closes all DB objects 
	 */
	public static void closeDBConnections() {
		
		try {
 			con.close();
			stm.close();
			
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Con or Statement  or rs object is null");
			e.printStackTrace();
		}
	}
	
	public static void insertTestExecutionResult(String executionResult, String failedDescription) {
		String query = "INSERT INTO TestResult VALUES ('"+
						envDataMap.get("project")    +"', '"+
						envDataMap.get("region")     +"', '"+
						envDataMap.get("sprint")   +"', '"+
						envDataMap.get("usNumber") +"', '"+
						executionResult +"', '"+
						failedDescription + "' )";
		System.out.println(query);
		insertToDBTable(query);
	}
}
