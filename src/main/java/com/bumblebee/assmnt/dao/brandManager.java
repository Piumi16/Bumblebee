package com.bumblebee.assmnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumblebee.assmnt.model.Brand;
import com.bumblebee.assmnt.model.Category;

public class brandManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlConnectorFactoryImpl();
		return factory.getDbConnector();
	} 
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	public boolean addBrand(Brand brand) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		String query ="insert into tbl_brand (brand_name) values (?)";
		//java.sql.Statement st = connection.createStatement();
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, brand.getBrand_name());
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		return result>0;
	}
	
	public Brand getSpecificBrand(int brand_id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "select * from tbl_brand where brand_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, brand_id);
		ResultSet rs = ps.executeQuery();
		Brand brand = new Brand();
		while (rs.next()) {
			brand.setBrand_id(rs.getInt("brand_id"));
			brand.setBrand_name(rs.getString("brand_name"));			
		}
		ps.close();
		connection.close();
		return brand;
	}
	public List<Brand> getAllBrands() throws ClassNotFoundException, SQLException{
		
		Connection connection = getConnection();
		
		String query = "select * from tbl_brand";
		java.sql.Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<Brand> BrandList = new ArrayList<Brand>();
		while(rs.next()) {
			Brand brand = new Brand();
			brand.setBrand_id(rs.getInt("brand_id"));
			brand.setBrand_name(rs.getString("brand_name"));
			
			BrandList.add(brand);
		}
		st.close();
		connection.close();
		
		return BrandList;
	}
	public boolean updateBrand(Brand brand) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		String query = "update tbl_brand set brand_name = ? where brand_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, brand.getBrand_name());
		ps.setInt(2, brand.getBrand_id());		
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		return result>0;
	}
	public boolean deleteBrand(int brand_id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		String query = "delete from tbl_brand where brand_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, brand_id);
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		return result>0;
	}
	
}
