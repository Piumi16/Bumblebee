package com.bumblebee.assmnt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bumblebee.assmnt.model.Loan;
import com.bumblebee.assmnt.service.LoanService;


public class LoanConroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoanService service;
    public LoanConroller() {
    	service = LoanService.getLoanService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type != null && type.equals("specific")) {
			searchSpecificLoan(request,response);
		}else {
			
		}
	}

	
	private void searchSpecificLoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		Loan loan = new Loan();
		int cust_id = Integer.parseInt(request.getParameter("cust_id")) ;
		
		try {
			loan = service.getSpecificLoan(cust_id);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		request.setAttribute("loan", loan);
		RequestDispatcher rd = request.getRequestDispatcher("ManageLoan.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
