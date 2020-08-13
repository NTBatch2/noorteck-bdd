package com.noorteck.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 

public class Demo {

	public static void main(String[] args) throws IOException {
	
		
		String str = "{ \"name\": \"Andrea\", \"job\": \"SDET\" }";
		// Create a Properties class object to access the property file
		Properties prop = new Properties();

		// create FileInputStream object to and pass the file path
		FileInputStream file = new FileInputStream("./src/test/resources/configs/configs.properties");

		// load the properties file
		prop.load(file);

		// getPropertry("key) method --> to retrieve the value
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("username"));
		
	}
}
