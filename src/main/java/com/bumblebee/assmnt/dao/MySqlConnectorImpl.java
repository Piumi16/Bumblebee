package com.bumblebee.assmnt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlConnectorImpl  implements DbConnector {

	@Override
	public Connection getDbConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bumblebee_assmnt";
		String userName = "root";
		String password = "P#6464@KMPHJ";

		Connection connection = DriverManager.getConnection(url, userName, password);
		return connection;		

}
}
