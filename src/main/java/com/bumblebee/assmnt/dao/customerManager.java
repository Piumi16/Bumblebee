package com.bumblebee.assmnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bumblebee.assmnt.model.Customer;

public class customerManager {
	
	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlConnectorFactoryImpl();
		return factory.getDbConnector();
	} 
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	public Customer login(String userName, String password) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();		
		
        String sql = "SELECT * FROM tbl_customer WHERE customer_username=? and customer_password=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userName);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery(); 
        Customer customer = null; 
        if (result.next()) {
        	customer = new Customer();
        	customer.setCustomer_username(result.getString("customer_username"));
        } 
        connection.close(); 
        return customer;		
		
		
	}
	
public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		String query ="insert into tbl_customer (customer_name, date_of_birth, customer_tel, customer_mail, customer_username, customer_password) values (?,?,?,?,?,?)";
		//java.sql.Statement st = connection.createStatement();
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, customer.getCustomer_name());
		ps.setDate(2,  customer.getDate_of_birth());
		ps.setInt(3, customer.getCustomer_tel());
		ps.setString(4, customer.getCustomer_mail());
		ps.setString(5, customer.getCustomer_username());
		ps.setString(6, customer.getCustomer_password());
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		return result>0;
	}
	
	public Customer getSpecificCustomer(int customer_id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "select * from tbl_customer where customer_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, customer_id);
		ResultSet rs = ps.executeQuery();
		Customer customer = new Customer();
		while (rs.next()) {
			customer.setCustomer_name(rs.getString("customer_name"));
			customer.setDate_of_birth(rs.getDate("date_of_birth"));
			customer.setCustomer_tel(rs.getInt("customer_tel"));
			customer.setCustomer_mail(rs.getString("customer_mail"));
			customer.setCustomer_username(rs.getString("customer_userName"));
			customer.setCustomer_password(rs.getString("customer_password"));
			
			
		}
		ps.close();
		connection.close();
		return customer;
	}
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException{
		
		Connection connection = getConnection();
		
		String query = "select * from tbl_customer";
		java.sql.Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<Customer> customerList = new ArrayList<Customer>();
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setCustomer_id(rs.getInt("customer_id"));
			customer.setCustomer_name(rs.getString("customer_name"));
			customer.setDate_of_birth(rs.getDate("date_of_birth"));
			customer.setCustomer_tel(rs.getInt("customer_tel"));
			customer.setCustomer_mail(rs.getString("customer_mail"));
			customer.setCustomer_username(rs.getString("customer_username"));
			customer.setCustomer_password(rs.getString("customer_password"));
			
			
			customerList.add(customer);
		}
		st.close();
		connection.close();		
		return customerList;
	}
	public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		String query = "update tbl_customer set customer_name = ?, date_of_birth = ?, customer_tell = ?, customer_mail = ?, customer_username = ?, customer_password = ? where customer_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, customer.getCustomer_name());
		ps.setDate(2,  customer.getDate_of_birth());
		ps.setInt(3, customer.getCustomer_tel());
		ps.setString(4, customer.getCustomer_mail());
		ps.setString(5, customer.getCustomer_username());
		ps.setString(6, customer.getCustomer_password());
		
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		return result>0;
	}
	public boolean deleteCustomer(int customer_id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		String query = "delete from tbl_customer where customer_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, customer_id);
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		return result>0;
	}
	
	

}
