package com.bumblebee.assmnt.model;

public class Admin {

	private int admin_id;
	private String admin_name;
	private int tel;
	private String username;
	private String password;
		
	public Admin(int admin_id, String admin_name, int tel, String username, String password) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.tel = tel;
		this.username = username;
		this.password = password;
	}

	public Admin() {
		
	}
	
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
