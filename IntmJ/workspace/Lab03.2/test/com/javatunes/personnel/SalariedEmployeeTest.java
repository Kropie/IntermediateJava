package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gov.irs.TaxPayer;

public class SalariedEmployeeTest {

	SalariedEmployee employee;
	
	@BeforeClass
	public static void before() {
		System.out.println("HourlyEmployeeTest - TESTING IS STARTED");
	}
	
	@Before
	public void init() {
		employee = new SalariedEmployee();
		System.out.println("SalariedEmployeeTest.init()");
	}
	
	@Test
	public void testPay() {
		employee.setSalary(1000d);
		assertEquals(1000d, employee.pay(), 0.0);
		employee.setSalary(-1111d);
		assertEquals(-1111, employee.pay(), 0.0);
		System.out.println("SalariedEmployeeTest.testPay()");
	}
	
	@Test
	public void testName() {
		employee.setName("Jon");
		assertEquals("Jon", employee.getName());
		System.out.println("SalariedEmployeeTest.testName()");
	}
	
	@Test
	public void testHireDate() {
		employee.setHireDate(new Date(1999, 12, 1));
		assertEquals(new Date(1999, 12, 1), employee.getHireDate());
		System.out.println("SalariedEmployeeTest.testHireDate()");
	}

	@Test
	public void testPayTaxes() {
		int salary = 1000;
		employee.setSalary(Double.valueOf(salary));
		assertEquals(salary*TaxPayer.SALARIED_TAX_RATE, employee.payTaxes(), 0.001);
		salary = 200;
		employee.setSalary(Double.valueOf(salary));
		assertEquals(salary*TaxPayer.SALARIED_TAX_RATE, employee.payTaxes(), 0.001);
		System.out.println("SalariedEmployeeTest.testPayTaxes()");
	}
	
	@After
	public void destroy() {
		System.out.println("-------------------");
	}
	
	@AfterClass
	public static void done() {
		System.out.println("SalariedEmployeeTest - TESTING DONE");
	}
}
