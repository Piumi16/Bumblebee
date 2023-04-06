package com.bumblebee.assmnt.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	Customer cust = new Customer(8,"tom",java.sql.Date.valueOf("2000-02-10"),0123123,"tomgmail.com","üntom","pwtom");
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetCustomer_id() {
		int expected = 8;
		int result = cust.getCustomer_id();
		assertEquals(expected,result);
	}

	@Test
	void testSetCustomer_id() {
		int custId = 8;
		cust.setCustomer_id(custId);
		int expected = 8;
		int result =cust.getCustomer_id();
		assertEquals(expected,result);	
	}

	@Test
	void testGetCustomer_name() {
		String expected = "tom";
		String result = cust.getCustomer_name();
		assertEquals(expected,result);
	}

	@Test
	void testSetCustomer_name() {
		String custnm = "tom";
		cust.setCustomer_name(custnm);
		String expected = "tom";
		String result =cust.getCustomer_name();
		assertEquals(expected,result);
	}

	@Test
	void testGetCustomer_tel() {
		int expected = 0123123;
		int result = cust.getCustomer_tel();
		assertEquals(expected,result);
	}

	@Test
	void testSetCustomer_tel() {
		int custnm =  0123123;
		cust.setCustomer_tel(custnm);
		int expected = 0123123;
		int result =cust.getCustomer_tel();
		assertEquals(expected,result);
	}

}
