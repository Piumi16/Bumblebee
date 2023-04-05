package com.bumblebee.assmnt.service;

import java.sql.SQLException;
import java.util.List;

import com.bumblebee.assmnt.dao.categoryManager;
import com.bumblebee.assmnt.model.Category;

public class CategoryService {
	
	private static CategoryService categoryServiceObject;
	private CategoryService() {}
	
	public static synchronized CategoryService getCategoryServices() {
		if(categoryServiceObject == null) {
			categoryServiceObject = new CategoryService();
		}		
		return categoryServiceObject;
	}
	private categoryManager getCategoryManager(){
		return new categoryManager();
	}
	public boolean registerCategory(Category category) throws ClassNotFoundException, SQLException {
		
		return getCategoryManager().addCategory(category);
	}
	
	public Category getSpecificCategory(int category_id) throws ClassNotFoundException, SQLException {
		return getCategoryManager().getSpecificCategory(category_id);
	}
	
	public List<Category> getAllCategory() throws ClassNotFoundException, SQLException{
		return getCategoryManager().getAllCategories();
	}
	public boolean editTheCategory(Category category) throws ClassNotFoundException, SQLException {
		return getCategoryManager().updateCategory(category);
	}
	public boolean deleteTheCategory(int category_id) throws ClassNotFoundException, SQLException {
		return getCategoryManager().deleteCategory(category_id);
	}

}
