package com.bumblebee.assmnt.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bumblebee.assmnt.dao.customerManager;
import com.bumblebee.assmnt.model.Customer;
import com.bumblebee.assmnt.service.CustomerService;


public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService service;
    public CustomerController() {
    	service = CustomerService.getCustomerService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type != null && type.equals("specific")) {
			searchSpecificCustomer(request,response);
		}else {
			searchAllCustomer(request,response);
		}
	}

	
	private void searchAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		List<Customer> customerList;
		try {
			customerList = service.getAllCustomer();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			customerList = new ArrayList<Customer>();
		}
		request.setAttribute("message", message);
		request.setAttribute("customerList", customerList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewCustomers.jsp");
		rd.forward(request, response);
		
	}


	private void searchSpecificCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		Customer customer = new Customer();
		int customer_id = Integer.parseInt(request.getParameter("customer_id")) ;
		
		try {
			customer = service.getSpecificCustomer(customer_id);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		request.setAttribute("customer", customer);
		RequestDispatcher rd = request.getRequestDispatcher("ManageCustom.jsp");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type != null && type.equals("add")) 
		{
			addCustomer(request,response);
		}else if(type != null && type.equals("update"))
		{
			updateCustomer(request,response);
		}else if(type != null && type.equals("delete"))
		{
			deleteCustomer(request,response);
		}else if(type != null && type.equals("login"))
		{
			login(request,response);
		}else if(type != null && type.equals("logout"))
		{
			logout(request,response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String message = "";

		HttpSession session = request.getSession(false);
		
		String username = null;
		String password = null;
		try {

			if (session != null && session.getAttribute("username") != null
					&& session.getAttribute("password") != null) {

				 username = (String) session.getAttribute("username");
				 password = (String) session.getAttribute("password");

				if (isValidUser(username, password)) {

					response.sendRedirect("UserLandingPage.jsp");

				} else {
					response.sendRedirect("UserLogin.jsp");
				}

			} else {

				 username = request.getParameter("username");
				 password = request.getParameter("password");

				if (isValidUser(username, password)) {
					session = request.getSession(true);
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					response.sendRedirect("UserLandingPage.jsp");

				} else {
					message = "Login Failed";
					session.setAttribute("message", message);
					
					response.sendRedirect("UserLogin.jsp");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("UserLogin.jsp");
	}

	private boolean isValidUser(String username, String password) throws ClassNotFoundException, SQLException {
		boolean validity;
		Customer customer = new customerManager().login(username, password);
		return validity = customer != null ? true : false;

	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = "";
		int customer_id = Integer.parseInt(request.getParameter("customer_id")) ;
		
		try {
			boolean result = service.deleteTheCustomer(customer_id);
			if(result) {
				message= "Customer Deletion Success, Customer Code : "+ customer_id ;
			}else {
				message= "Customer Deletion Failed, Customer Code : "+ customer_id ;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		//HttpSession session = request.getSession();
		//session.setAttribute("message", session);
		response.sendRedirect("customer");
	}
		
	


	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
		String message = "";

		int customer_id = Integer.parseInt(request.getParameter("customer_id")) ;
		String customerName = request.getParameter("customer_name");
		LocalDate dob =  LocalDate.parse("date_of_birth");//Date.parse(request.getParameter("dob"));  //Date.parse(request.getParameter("dob")) ;
		int customer_tell = Integer.parseInt(request.getParameter("customer_tell"));
		String customer_mail = request.getParameter("customer_mail");
		String customer_userName = request.getParameter("customer_userName");
		String customer_password = request.getParameter("customer_password");
	
		
		
	}


	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		
		
		String customerName = request.getParameter("customerName");
		String str = request.getParameter("dob");
		Date dt = Date.valueOf(str);
        int customer_tell = Integer.parseInt(request.getParameter("customerContact"));
		String customer_mail = request.getParameter("custMail");
		String customer_username = request.getParameter("custUserName");
		String customer_password = request.getParameter("custPassword");
		//LocalDate date_of_birth =  LocalDate.parse("date_of_birth");
		
						
		Customer customer = new Customer(customerName,dt,customer_tell,customer_mail,customer_username,customer_password);
		
		try {
			boolean result = service.registerCustomer(customer);
			if(result) {
				message = "Customer has been added, Customer name "+customerName;
			}else {
				message = "Customer has been failed to add, Customer name "+customerName;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("InsertCustomer.jsp");
		rd.forward(request, response);
		
	}

}
