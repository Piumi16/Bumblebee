package com.bumblebee.assmnt.service;

import java.sql.SQLException;
import java.util.List;

import com.bumblebee.assmnt.dao.customerManager;
import com.bumblebee.assmnt.model.Customer;

public class CustomerService {

	private static CustomerService customerServiceObject;
	private CustomerService() {}
	
	public static synchronized CustomerService getCustomerService() {
		if(customerServiceObject == null) {
			customerServiceObject = new CustomerService();
		}		
		return customerServiceObject;
	}
	private customerManager getCustomerManager(){
		return new customerManager();
	}	

	public boolean registerCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		return getCustomerManager().addCustomer(customer);
	}
	
	public Customer getSpecificCustomer(int customer_id) throws ClassNotFoundException, SQLException {
		return getCustomerManager().getSpecificCustomer(customer_id);
	}
	
	public List<Customer> getAllCustomer() throws ClassNotFoundException, SQLException{
		return getCustomerManager().getAllCustomers();
	}
	public boolean editTheCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		return getCustomerManager().updateCustomer(customer);
	}
	public boolean deleteTheCustomer(int customer_id) throws ClassNotFoundException, SQLException {
		return getCustomerManager().deleteCustomer(customer_id);
	}

}
