package com.bumblebee.assmnt.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumblebee.assmnt.dao.adminManager;
import com.bumblebee.assmnt.model.Admin;

public class AdminService {

	private static AdminService adminServiceObject;
	private AdminService() {}
	
	public static synchronized AdminService getAdminServices() {
		if(adminServiceObject == null) {
			adminServiceObject = new AdminService();
		}		
		return adminServiceObject;
	}
	private adminManager getAdminManager(){
		return new adminManager();
	}	
	public boolean registerAdmin(Admin admin_id) throws ClassNotFoundException, SQLException {
		return false;
	}	
	public Admin getSpecificAdmin(String username, String password) throws ClassNotFoundException, SQLException {
		return getAdminManager().getSpecificAdmin(username, password);
	}	
	public List<Admin> getAllAdmin() throws ClassNotFoundException, SQLException{
		return new ArrayList<Admin>();
	}
	public boolean editTheAdmin(Admin admin_id) throws ClassNotFoundException, SQLException {
		return false;
	}
	public boolean deleteTheAdmin(int admin_id) throws ClassNotFoundException, SQLException {
		return false;
}
}
