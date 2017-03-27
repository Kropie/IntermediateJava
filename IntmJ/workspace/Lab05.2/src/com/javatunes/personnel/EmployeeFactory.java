/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {

	public static final String SALARIED_EMPLOYEE_KEY = "SE";
	public static final String HOURLY_EMPLOYEE_KEY = "HE";
	public static final String TYPE_KEY = "type";
	public static final String NAME_KEY = "name";
	public static final String HIRE_DATE_KEY = "hireDate";
	public static final String RATE_KEY = "rate";
	public static final String HOURS_KEY = "hours";
	public static final String SALARY_KEY = "salary";

	// prevent direct instantiation - this is an all-static factory class
	private EmployeeFactory() {
	}

	/**
	 * COMPLETED: given the input map, create and return the correct object
	 * (with its properties set)
	 */
	public static Employee createEmployee(Map<String, String> inputMap) throws IllegalArgumentException {
		// return value
		Employee emp = null;

		if (inputMap.containsKey(TYPE_KEY) && (inputMap.get(TYPE_KEY).equals(SALARIED_EMPLOYEE_KEY)
				|| inputMap.get(TYPE_KEY).equals(HOURLY_EMPLOYEE_KEY))) {
			
			// Initialize specific instances of employees
			if (inputMap.get(TYPE_KEY).equals(SALARIED_EMPLOYEE_KEY)) {
				emp = initializeSalariedEmployee(inputMap);
			} else if (inputMap.get(TYPE_KEY).equals(HOURLY_EMPLOYEE_KEY)) {
				emp = initializeHourlyEmployee(inputMap);
			}
			
			// Initialize general employee fields
			if (inputMap.containsKey(HIRE_DATE_KEY)) {
				emp.setHireDate(Date.valueOf(inputMap.get(HIRE_DATE_KEY)));
			}

			if (inputMap.containsKey(NAME_KEY)) {
				emp.setName(inputMap.get(NAME_KEY));
			}
		}

		return emp;
	}

	private static Employee initializeSalariedEmployee(Map<String, String> inputMap) {
		Employee emp = new SalariedEmployee();

		emp = new SalariedEmployee();

		if (inputMap.containsKey(SALARY_KEY)) {
			((SalariedEmployee) emp).setSalary(Double.valueOf(inputMap.get(SALARY_KEY)));
		}

		return emp;
	}
	
	private static Employee initializeHourlyEmployee(Map<String, String> inputMap) {
		Employee emp = new HourlyEmployee();

		if (inputMap.containsKey(RATE_KEY)) {
			try {
				((HourlyEmployee) emp).setRate(Double.valueOf(inputMap.get(RATE_KEY)));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		if (inputMap.containsKey(HOURS_KEY)) {
			try {
				((HourlyEmployee) emp).setHours(Double.valueOf(inputMap.get(HOURS_KEY)));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}
}