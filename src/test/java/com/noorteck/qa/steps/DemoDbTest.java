package com.noorteck.qa.steps;

import java.sql.SQLException;

import com.noorteck.qa.utils.Constants;
import com.noorteck.qa.utils.NTKdb;
import com.noorteck.qa.utils.ReadPropertyData;

public class DemoDbTest  extends Constants{

	public static void main(String[] args) throws SQLException {
		
		
		 prop = ReadPropertyData.getProperties( configFilePath);
		 
		 NTKdb.connectToDB();
		 
		 String query = "select * from employees";
		 
		 NTKdb.retrieveResultSet(query);
		 
		 while (rs.next()) {
			 System.out.println(rs.getString("employee_id") +"\t\t"+ 
					 			rs.getString("first_name")  +"\t\t"+
					 			rs.getString("employee_id"));
	 

		 }
		 
		NTKdb.closeDBConnections();
	}
}
