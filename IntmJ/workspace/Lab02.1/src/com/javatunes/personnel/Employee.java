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

import gov.irs.NamedEntity;
import gov.irs.TaxPayer;

public abstract class Employee implements TaxPayer, NamedEntity {
	private String name;
	private Date hireDate;

	public Employee() {
		name = "";
		hireDate = new Date(0);
	}

	public Employee(String name, Date hireDate) {
		setName(name);
		setHireDate(hireDate);
	}

	public void work() {
		System.out.println(getName() + " working hard since " + getHireDate());
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate();
	}

	public abstract void pay();

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}

		Employee e = (Employee) obj;
		return Objects.equals(getName(), e.getName()) && Objects.equals(getHireDate(), e.getHireDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getHireDate());
	}

}