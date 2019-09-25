package com.extent.tests;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestP {

	public static void main(String[] args) {
		try {
			System.out.println("ttrtr");

			Class.forName("org.mariadb.jdbc.Driver");
			//conn = DriverManager.getConnection(pro.getProperty("db"), pro.getProperty("db_username"), pro.getProperty("db_password"));
			Connection conn = DriverManager.getConnection("jdbc:mariadb://172.16.0.49:3306/pcloudy_sample","swapna","password");

			//logger.debug("Database Connection Established Successfully...");
			System.out.println("done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Database Connection Terminated... "+e.getLocalizedMessage());
		}
	}
}
