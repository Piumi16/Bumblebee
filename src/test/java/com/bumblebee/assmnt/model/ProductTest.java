package com.bumblebee.assmnt.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

	
	Product prdct = new Product(03,"lipstick",2000,"oriflame","beauty");
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
	void testGetProduct_id() {
		int expected = 03;
		int result = prdct.getProduct_id();
		assertEquals(expected,result);
	}

	@Test
	void testSetProduct_id() {
		int productId = 03;
		prdct.setProduct_id(productId);
		int expected = 03;
		int result = prdct.getProduct_id();
		assertEquals(expected,result);	
	}

	@Test
	void testGetProduct_name() {
		String expected = "lipstick";
		String result = prdct.getProduct_name();
		assertEquals(expected,result);
	}

	@Test
	void testSetProduct_name() {
		String productnm = "lipstick";
		prdct.setProduct_name(productnm);
		String expected ="lipstick";
		String result = prdct.getProduct_name();
		assertEquals(expected,result);
	}

	@Test
	void testGetProduct_price() {
		double expected = 2000;
		double result = prdct.getProduct_price();
		assertEquals(expected,result);
	}

	@Test
	void testSetProduct_price() {
		double productnm = 2000;
		prdct.setProduct_price(productnm);
		double expected =2000;
		double result = prdct.getProduct_price();
		assertEquals(expected,result);
	}

}
