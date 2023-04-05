package com.bumblebee.assmnt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bumblebee.assmnt.model.Category;
import com.bumblebee.assmnt.service.CategoryService;


public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CategoryService service;
    
    public CategoryController() {
    	service = CategoryService.getCategoryServices();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type != null && type.equals("specific")) {
			searchSpecificCategory(request,response);
		}else if(type != null && type.equals("select")){
			getAllCategories(request,response);
		}else {
			searchAllCategories(request,response);
		}
	}
	private void getAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		List<Category> categoryList;
		try {
			categoryList = service.getAllCategory();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			categoryList = new ArrayList<Category>();
		}
		request.setAttribute("message", message);
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher("InsertProduct.jsp");
		rd.forward(request, response);
		
	}

	private void searchAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		List<Category> categoryList;
		try {
			categoryList = service.getAllCategory();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			categoryList = new ArrayList<Category>();
		}
		request.setAttribute("message", message);
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewCategories.jsp");
		rd.forward(request, response);
				
	}


	private void searchSpecificCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		Category category = new Category();
		int categoryId = Integer.parseInt(request.getParameter("category_id")) ;
		
		try {
			category = service.getSpecificCategory(categoryId);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		request.setAttribute("category", category);
		RequestDispatcher rd = request.getRequestDispatcher("ManageCategories.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type != null && type.equals("add")) 
		{
			addCategory(request,response);
		}else if(type != null && type.equals("update"))
		{
			updateCategory(request,response);
		}else if(type != null && type.equals("delete"))
		{
			deleteCategory(request,response);
		}
	}


	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = "";
		int category_id = Integer.parseInt(request.getParameter("categoryId")) ;
		
		try {
			boolean result = service.deleteTheCategory(category_id);
			if(result) {
				message= "Category Deletion Success, Category Code : "+ category_id ;
			}else {
				message= "Category Deletion Failed, Category Code : "+ category_id ;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		//HttpSession session = request.getSession();
		//session.setAttribute("message", session);
		response.sendRedirect("CategoryController");
	}
		



	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		int category_id = Integer.parseInt(request.getParameter("category_id")) ;
		String category_name = request.getParameter("category_name") ; 
		Category category = new Category(category_id, category_name);
		
		try {
			boolean result = service.editTheCategory(category);
			if(result) {
				message= "Category Updated Success, Category Code : "+ category.getCategory_id() ;
			}else {
				message= "Category Updation Failed, Category Code : "+ category.getCategory_id() ;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("ManageCategories.jsp");
		rd.forward(request, response);
	}


	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		
		String category_name = request.getParameter("categoryName");
		
		Category category = new Category(category_name);
		
		try {
			boolean result = service.registerCategory(category);
			if(result) {
				message = "Category has been added, Category name "+category_name;
			}else {
				message = "Category has been failed to add, Category name "+category_name;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("InsertCategory.jsp");
		rd.forward(request, response);
		
	}

}
