package com.bumblebee.assmnt.model;

public class Loan {


	private int loan_id;
	private int cust_id;
	private double loan_amount;
	private java.sql.Date loan_get_day;
	
	
	public Loan(int loan_id, int cust_id, double loan_amount,java.sql.Date loan_get_day) {
		super();
		this.loan_id = loan_id;
		this.cust_id = cust_id;
		this.loan_amount = loan_amount;
		this.loan_get_day = loan_get_day;
		
	}

	public Loan() {
		
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public double getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}

	public java.sql.Date getLoan_get_day() {
		return loan_get_day;
	}

	public void setLoan_get_day(java.sql.Date loan_get_day) {
		this.loan_get_day = loan_get_day;
	}
	
	
}
