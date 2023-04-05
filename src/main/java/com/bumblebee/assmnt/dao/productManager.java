package com.bumblebee.assmnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumblebee.assmnt.model.Product;




public class productManager {
	
public DbConnector getDbConnector() {
		
		DbConnectorFactory factory = new MySqlConnectorFactoryImpl();
		return factory.getDbConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException { 
		DbConnector connector = getDbConnector(); 
		return connector.getDbConnection(); }
	
	public boolean addproduct(Product product) throws ClassNotFoundException, SQLException{
	
		Connection connection = getConnection(); 
		String query ="insert into tbl_product (product_name, product_price, product_brand, product_category) values (?,?,?,?)"; 
		//java.sql.Statement st = connection.createStatement(); 
		PreparedStatement ps = connection.prepareStatement(query); 
		ps.setString(1, product.getProduct_name()); 
		ps.setDouble(2, product.getProduct_price()); 
		ps.setString(3, product.getProduct_brand()); 
		ps.setString(4, product.getProduct_category());
		int result = ps.executeUpdate(); 
		ps.close(); 
		connection.close(); 
		return result>0; 
	}
	public Product getSpecificProduct(int product_id) throws ClassNotFoundException, SQLException{
		
		Connection connection = getConnection();
		String query = "select * from tbl_product where product_id=?"; 
		PreparedStatement ps = connection.prepareStatement(query); 
		ps.setInt(1, product_id); 
		ResultSet rs = ps.executeQuery(); 
		Product product = new Product(); 
		while (rs.next()) { 
		product.setProduct_id(rs.getInt("product_id")); 
		product.setProduct_name(rs.getString("product_name")); 
		product.setProduct_price(rs.getDouble("product_price")); 
		product.setProduct_brand(rs.getString("product_brand"));
		product.setProduct_category(rs.getString("product_category"));
		} 
		ps.close(); 
		connection.close(); 
		return product; 
	} 
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException{
		
		
		Connection connection = getConnection(); 
		String query = "select * from tbl_product"; 
		java.sql.Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query); 
		List<Product> productList = new ArrayList<Product>(); 
		while(rs.next()) { 
		Product product = new Product(); 
		product.setProduct_id(rs.getInt("product_id")); 
		product.setProduct_name(rs.getString("product_name")); 
		product.setProduct_price(rs.getDouble("product_price")); 
		product.setProduct_brand(rs.getString("product_brand")); 
		product.setProduct_category(rs.getString("product_category")); 
		productList.add(product); 
		} 
		st.close(); 
		connection.close(); 
		return productList; 
		
	}
	public boolean updateProduct(Product product_id) throws ClassNotFoundException, SQLException{
		
		Connection connection = getConnection(); 
		String query = "update tbl_product set Product_name = ?, Product_price = ?, Product_brand = ?, Product_category = ? where product_id = ?"; 
		PreparedStatement ps = connection.prepareStatement(query); 
		ps.setString(1, product_id.getProduct_name()); 
		ps.setDouble(2, product_id.getProduct_price()); 
		ps.setString(1, product_id.getProduct_brand()); 
		ps.setString(1, product_id.getProduct_category()); 
		ps.setInt(3, product_id.getProduct_id()); 
		int result = ps.executeUpdate(); 
		ps.close(); 
		connection.close(); 
		return result>0;
	}
	public boolean deleteProduct(int product_id) throws SQLException, ClassNotFoundException{
		
		Connection connection = getConnection(); 
		String query = "delete from tbl_product where product_id = ?"; 
		PreparedStatement ps = connection.prepareStatement(query); 
		ps.setInt(1, product_id); 
		int result = ps.executeUpdate(); 
		ps.close(); 
		connection.close(); 
		return result>0;
	}

}
