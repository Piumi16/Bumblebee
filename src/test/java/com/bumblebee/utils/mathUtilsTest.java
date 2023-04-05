package com.bumblebee.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
@TestInstance(Lifecycle.PER_METHOD)
class mathUtilsTest {

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
	void testCalInstallments() {
		System.out.println("Installment calculation test");
		
		try {
			mathUtils util = new mathUtils();
			util.calInstallments(15000, 3);

			}

			catch(Exception exp){

			assertEquals(ArithmeticException.class,exp.getClass(), "Aarithmetic exception  "+exp.getClass());

			}

	}

}
