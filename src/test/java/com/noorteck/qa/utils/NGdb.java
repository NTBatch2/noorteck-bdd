package com.noorteck.qa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NGdb {

	static String url = "jdbc:mysql://localhost:3306/hr";
	static String userName = "root";
	static String password = "123456";
	
	static Statement stm;
	static Connection con;
	
	public static void connectToDB() {
		try {
			// Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Create connection with database
			con = DriverManager.getConnection(url, userName, password);	
			
			// create statement object
			stm = con.createStatement();
						
		} catch (Exception e) {
			System.out.println("Could not establish connection with DB");
			e.printStackTrace();
		}
	}
	
	/**
	 * This method takes query and retrieves the result set
	 * @param query
	 * @return
	 */
	public static ResultSet executeQuery(String query) {
		ResultSet rs = null;

		try {

			rs = stm.executeQuery(query);

		} catch (Exception e) {
			System.out.println("Couldnot retireve data from table");
			e.printStackTrace();
		} finally {

			try {
				con.close();
				stm.close();
			} catch (SQLException e) {
				System.out.println("Con or Statement object is null");
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	
}
