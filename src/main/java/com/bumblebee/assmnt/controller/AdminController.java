package com.bumblebee.assmnt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bumblebee.assmnt.dao.adminManager;
import com.bumblebee.assmnt.model.Admin;
import com.bumblebee.assmnt.service.AdminService;


public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	private AdminService service;
    public AdminController() {
    	
    	service = AdminService.getAdminServices();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");

		if (type != null && type.equals("specific")) {
			try {
				searchSpecificAdmin(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (type != null && type.equals("logout")){
			logout(request, response);
		}else {}
	}

	private void searchSpecificAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

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

					response.sendRedirect("AdminLandingPage.jsp");

				} else {
					response.sendRedirect("AdminLogin.jsp");
				}

			} else {

				 username = request.getParameter("username");
				 password = request.getParameter("password");

				if (isValidUser(username, password)) {
					session = request.getSession(true);
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					response.sendRedirect("AdminLandingPage.jsp");

				} else {
					message = "Login Failed";
					session.setAttribute("message", message);
					response.sendRedirect("AdminLogin.jsp");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("AdminLogin.jsp");
	}

	private boolean isValidUser(String username, String password) throws ClassNotFoundException, SQLException {
		boolean validity;
		Admin admin = new adminManager().getSpecificAdmin(username, password);
		return validity = admin != null ? true : false;

	}
		
	
	}


