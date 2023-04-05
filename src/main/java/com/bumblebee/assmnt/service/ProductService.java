package com.bumblebee.assmnt.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumblebee.assmnt.dao.productManager;
import com.bumblebee.assmnt.model.Product;


public class ProductService {
	
	private static ProductService productServiceObject;
	private ProductService() {}
	
	public static synchronized ProductService getProductService() {
		if(productServiceObject == null) {
			productServiceObject = new ProductService();
		}		
		return productServiceObject;
	}
	
	private productManager getProductManager(){
		return new productManager();
	}	

	
	//services.................................
	
		public boolean registerProduct(Product product) throws ClassNotFoundException, SQLException {
			return getProductManager().addproduct(product);
			
		}
		public Product getSpecificProduct(int product_id) throws ClassNotFoundException, SQLException {
			return getProductManager().getSpecificProduct(product_id);
		}
		public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
			return getProductManager().getAllProducts();
		}
		public boolean editProduct(Product product) throws ClassNotFoundException, SQLException {
			return getProductManager().updateProduct(product);
		}
		public boolean deleteTheProduct(int product_id) throws ClassNotFoundException, SQLException{
			return getProductManager().deleteProduct(product_id);
		}

}
