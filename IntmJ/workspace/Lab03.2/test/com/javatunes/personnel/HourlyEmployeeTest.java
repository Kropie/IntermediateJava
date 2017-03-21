package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gov.irs.TaxPayer;

public class HourlyEmployeeTest {
	
	HourlyEmployee employee;
	
	@BeforeClass
	public static void before() {
		System.out.println("HourlyEmployeeTest - TESTING IS STARTED");
	}
	
	@Before
	public void init() {
		employee = new HourlyEmployee();
		System.out.println("HourlyEmployeeTest.init()");
	}
	
	@Test
	public void testPay() {
		employee.setHours(100d);
		employee.setRate(2d);
		assertEquals(200d, employee.pay(), 0.0);
		System.out.println("HourlyEmployeeTest.testPay()");
	}
	
	@Test
	public void testName() {
		employee.setName("Jon");
		assertEquals("Jon", employee.getName());
		System.out.println("HourlyEmployeeTest.testName()");
	}
	
	@Test
	public void testHireDate() {
		employee.setHireDate(new Date(1999, 12, 1));
		assertEquals(new Date(1999, 12, 1), employee.getHireDate());
		System.out.println("HourlyEmployeeTest.testHireDates()");
	}
	
	@Test
	public void testPayTaxes() {
		int hours = 1000;
		int rate = 2;
		employee.setHours(Double.valueOf(hours));
		employee.setRate(Double.valueOf(rate));
		assertEquals(employee.pay()*TaxPayer.HOURLY_TAX_RATE, employee.payTaxes(), 0.001);
		hours = 200;
		rate = 4;
		employee.setHours(Double.valueOf(hours));
		employee.setRate(Double.valueOf(rate));
		assertEquals(employee.pay()*TaxPayer.HOURLY_TAX_RATE, employee.payTaxes(), 0.001);
		System.out.println("HourlyEmployeeTest.testPayTaxes()");
	}
	
	@After
	public void destroy() {
		System.out.println("-------------------");
	}
	
	@AfterClass
	public static void done() {
		System.out.println("HourlyEmployeeTest - TESTING IS DONE");
	}

}
