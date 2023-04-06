package com.bumblebee.assmnt.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdminTest {

	Admin admn = new Admin(02,"hashan",0123123123,"hash","hash123");
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
	void testGetAdmin_id() {
		int expected = 02;
		int result = admn.getAdmin_id();
		assertEquals(expected,result);
	}

	@Test
	void testSetAdmin_id() {
		int admnId = 03;
		admn.setAdmin_id(admnId);
		int expected = 03;
		int result = admn.getAdmin_id();
		assertEquals(expected,result);
	}

	@Test
	void testGetAdmin_name() {
		String expected = "hashan";
		String result = admn.getAdmin_name();
		assertEquals(expected,result);
	}

	@Test
	void testSetAdmin_name() {
		String admnId = "hashan";
		admn.setAdmin_name(admnId);
		String expected = "hashan";
		String result = admn.getAdmin_name();
		assertEquals(expected,result);
	}

	@Test
	void testGetTel() {
		int expected = 0123123123;
		int result = admn.getTel();
		assertEquals(expected,result);
	}

	@Test
	void testSetTel() {
		int tel = 0123123123;
		admn.setTel(tel);
		int expected = 0123123123;
		int result = admn.getTel();
		assertEquals(expected,result);
	}

}
