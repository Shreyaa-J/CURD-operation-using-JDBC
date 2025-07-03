package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	//First, Load And Reset the Driver
	
	private static final String driver_path="com.mysql.cj.jdbc.Driver";
	private static final String database_url="jdbc:mysql://localhost:3306/jdbcdb";
	private static final String username="root";
	private static final String password="orchid@123";
	public Database() {
		try {
			Class.forName(driver_path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();//Allow us to see exactly where the error was occured
			throw new RuntimeException("Something Went Wrong."+e);
		}
	}//End of Constructor
   
	public Connection getConnection() throws SQLException {//to get the connection
		return DriverManager.getConnection(database_url, username, password);
		
		//here getconnection method inside the connection Driver manager class
		//written interface Connection(Present in java.sql package
		
	}//End of getConnection()
}
