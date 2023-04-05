package com.bumblebee.assmnt.model;

public class Customer {

	private int customer_id;
	private String customer_name;
	private java.sql.Date date_of_birth;
	private int customer_tel;
	private String customer_mail;
	private String customer_username;
	private String customer_password;

	public Customer(int customer_id, String customer_name, java.sql.Date date_of_birth, int customer_tel, String customer_mail,
			String customer_username, String customer_password) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.date_of_birth = date_of_birth;
		this.customer_tel = customer_tel;
		this.customer_mail = customer_mail;
		this.customer_username = customer_username;
		this.customer_password = customer_password;

	}

	public Customer() {
		
	}
	public Customer( String customer_name, java.sql.Date date_of_birth, int customer_tel, String customer_mail,
			String customer_username, String customer_password) {
		super();
		this.customer_name = customer_name;
		this.date_of_birth = date_of_birth;
		this.customer_tel = customer_tel;
		this.customer_mail = customer_mail;
		this.customer_username = customer_username;
		this.customer_password = customer_password;

	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public java.sql.Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(java.sql.Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getCustomer_tel() {
		return customer_tel;
	}

	public void setCustomer_tel(int customer_tel) {
		this.customer_tel = customer_tel;
	}

	public String getCustomer_mail() {
		return customer_mail;
	}

	public void setCustomer_mail(String customer_mail) {
		this.customer_mail = customer_mail;
	}

	public String getCustomer_username() {
		return customer_username;
	}

	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	
	
	
}
