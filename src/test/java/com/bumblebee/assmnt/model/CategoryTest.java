package com.bumblebee.assmnt.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

	Category cat = new Category(005,"beauty");
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
	void testGetCategory_id() {
		int expected = 005;
		int result = cat.getCategory_id();
		assertEquals(expected,result);
	}

	@Test
	void testSetCategory_id() {
		int categoryId = 005;
		cat.setCategory_id(categoryId);
		int expected = 005;
		int result = cat.getCategory_id();
		assertEquals(expected,result);
	}

}
