package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Simple JDBC Connection and fetching data from Oracle DB dependencies Jar files is --> ojdbc8-21.3.0.0.jar for java 1.8
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Driver driver = new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(driver);
		String URL = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "test";
		String password = "test";
		Connection con = DriverManager.getConnection(URL, username, password);
		Statement statement = con.createStatement();
		boolean execute = statement.execute("select * from tbl_student");
		System.out.println(execute);
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			System.out.println("S_ID : "+resultSet.getString(1));
			System.out.println("S_NAME : "+resultSet.getString(2));
			System.out.println("S_MOBILE : "+resultSet.getString(3));
			System.out.println("S_ADDRESS : "+resultSet.getString(4));
		}
		
	}

}
