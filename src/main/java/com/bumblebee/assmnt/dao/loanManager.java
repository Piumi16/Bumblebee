package com.bumblebee.assmnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bumblebee.assmnt.model.Loan;

public class loanManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlConnectorFactoryImpl();
		return factory.getDbConnector();
	} 
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	public Loan getSpecificLoan(int cust_id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "select * from tbl_loan where cust_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, cust_id);
		ResultSet rs = ps.executeQuery();
		Loan loan = new Loan();
		while (rs.next()) {
			loan.setLoan_id(rs.getInt("loan_id"));
			loan.setCust_id(rs.getInt("cust_id"));
			loan.setLoan_amount(rs.getDouble("loan_amount"));
			loan.setLoan_get_day(rs.getDate("loan_get_day"));
						
		}
		ps.close();
		connection.close();
		return loan;
	}
}
