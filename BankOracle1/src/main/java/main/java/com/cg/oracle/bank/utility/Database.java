package main.java.com.cg.oracle.bank.utility;

import java.sql.*;

public class Database {

	public Connection connect() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "connection", "honey@123");
		return con;
	}

}
