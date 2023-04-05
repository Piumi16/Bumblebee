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
import javax.servlet.http.HttpSession;

import com.bumblebee.assmnt.model.Product;
import com.bumblebee.assmnt.service.ProductService;


public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private ProductService service;
    public ProductController() {
    	service = ProductService.getProductService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type != null && type.equals("specific")) {
			searchSpecificProduct(request,response);
		}else {
			searchAllProducts(request,response);
		}
	}

	
	private void searchAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		List<Product> productList;
		try {
			 productList = service.getAllProducts();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			productList = new ArrayList<Product>();
		}
		request.setAttribute("message", message);
		request.setAttribute("productList", productList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewProducts.jsp");
		rd.forward(request, response);
	}

	private void searchSpecificProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		Product product = new Product();
		int product_id = Integer.parseInt(request.getParameter("product_id")) ;
		
		try {
			product = service.getSpecificProduct(product_id);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		request.setAttribute("product", product);
		RequestDispatcher rd = request.getRequestDispatcher("ManageProducts.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type != null && type.equals("add")) 
		{
			addProduct(request,response);
		}else if(type != null && type.equals("update"))
		{
			updateProduct(request,response);
		}else if(type != null && type.equals("delete"))
		{
			deleteProduct(request,response);
		}
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = "";
		int product_id = Integer.parseInt(request.getParameter("product_id")) ;
		
		try {
			boolean result = service.deleteTheProduct(product_id);
			if(result) {
				message= "Product Deletion Success, Product Code : "+ product_id ;
			}else {
				message= "Product Deletion Failed, Product Code : "+ product_id ;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message", session);
		response.sendRedirect("product");
	}
		


	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		int product_id = Integer.parseInt(request.getParameter("product_id")) ;
		String product_name = request.getParameter("product_name") ;
		Double product_price = Double.parseDouble(request.getParameter("product_price"));
		String product_brand = request.getParameter("product_brand");
		String product_category = request.getParameter("product_category"); 
		Product product = new Product(product_id, product_name, product_price, product_brand, product_category);
		
		try {
			boolean result = service.editProduct(product);
			if(result) {
				message= "Product Updated Success, Product Code : "+ product.getProduct_id() ;
			}else {
				message= "Product Updation Failed, Product Code : "+ product.getProduct_id() ;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("ManageProducts.jsp");
		rd.forward(request, response);
		
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		
		String product_name = request.getParameter("product_name");
		double product_price = Double.parseDouble(request.getParameter("product_price"));
		String product_brand = request.getParameter("product_brand");
		String product_category = request.getParameter("category");
		
		Product product = new Product(product_name,product_price,product_brand,product_category);
		
		try {
			boolean result = service.registerProduct(product);
			if(result) {
				message = "Product has been added, Product name "+product_name;
			}else {
				message = "Product has been failed to add, Product name "+product_name;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("InsertProduct.jsp");
		rd.forward(request, response);
	}
		
	}


