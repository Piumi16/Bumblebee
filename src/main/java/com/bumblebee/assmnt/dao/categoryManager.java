package com.bumblebee.assmnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumblebee.assmnt.model.Category;

public class categoryManager {
	
	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlConnectorFactoryImpl();
		return factory.getDbConnector();
	} 
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	public boolean addCategory(Category category) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		String query ="insert into tbl_category (category_name) values (?)";
		//java.sql.Statement st = connection.createStatement();
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, category.getCategory_name());
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		return result>0;
	}
	
	public Category getSpecificCategory(int category_id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "select * from tbl_category where category_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, category_id);
		ResultSet rs = ps.executeQuery();
		Category category = new Category();
		while (rs.next()) {
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_name(rs.getString("category_name"));			
		}
		ps.close();
		connection.close();
		return category;
	}
	public List<Category> getAllCategories() throws ClassNotFoundException, SQLException{
		
		Connection connection = getConnection();
		
		String query = "select * from tbl_category";
		java.sql.Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<Category> categoryList = new ArrayList<Category>();
		while(rs.next()) {
			Category category = new Category();
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_name(rs.getString("category_name"));
			
			categoryList.add(category);
		}
		st.close();
		connection.close();
		
		return categoryList;
	}
	public boolean updateCategory(Category category) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		String query = "update tbl_category set category_name = ? where category_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, category.getCategory_name());
		ps.setInt(2, category.getCategory_id());		
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		return result>0;
	}
	public boolean deleteCategory(int category) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		String query = "delete from tbl_category where category_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, category);
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		return result>0;
	}
	
	

}
