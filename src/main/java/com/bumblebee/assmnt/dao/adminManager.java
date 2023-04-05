package com.bumblebee.assmnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bumblebee.assmnt.model.Admin;

public class adminManager {
	
	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlConnectorFactoryImpl();
		return factory.getDbConnector();
	} 
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	public Admin getSpecificAdmin(String username, String password) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();		
		
        String sql = "SELECT * FROM tbl_admin WHERE username=? and password=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery(); 
        Admin admin = null; 
        if (result.next()) {
        	admin = new Admin();
        	admin.setUsername(result.getString("username"));
        } 
        connection.close(); 
        return admin;		
	

}
}
