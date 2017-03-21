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
import java.util.Objects;

import gov.irs.TaxPayer;

public class SalariedEmployee extends Employee {
	private Double salary;

	public SalariedEmployee() {
	}

	public SalariedEmployee(String name, Date hireDate) {
		super(name, hireDate);
		setHireDate(hireDate);
	}

	public SalariedEmployee(String name, Date hireDate, Double salary) {
		super(name, hireDate);
		setSalary(salary);
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public double pay() {
		StringBuffer sb = new StringBuffer().append(getName()).append(" is paid salary ").append(getSalary());
		System.out.println(sb);
		
		return getSalary();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate() + ", salary="
				+ getSalary();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		SalariedEmployee e = (SalariedEmployee) obj;

		return super.equals(obj) && Objects.equals(getSalary(), e.getSalary());
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ Objects.hash(getSalary());
	}

	@Override
	public double payTaxes() {
		return getSalary() * TaxPayer.SALARIED_TAX_RATE;
	}

}