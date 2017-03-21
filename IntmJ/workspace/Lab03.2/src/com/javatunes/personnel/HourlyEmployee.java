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

public class HourlyEmployee extends Employee {
	private Double rate;
	private Double hours;
	private static final Double DEFAULT_RATE = Double.valueOf(0.0);
	private static final Double DEFAULT_HOURS = Double.valueOf(0.0);

	public HourlyEmployee() {
		super();
		
		rate = DEFAULT_RATE;
		hours = DEFAULT_HOURS;
	}

	public HourlyEmployee(String name, Date hireDate) {
		super(name,hireDate);
		
		rate = DEFAULT_RATE;
		hours = DEFAULT_HOURS;
	}

	public HourlyEmployee(String name, Date hireDate, Double rate, Double hours) {
		super(name, hireDate);
		setRate(rate);
		setHours(hours);
	}

	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public double pay() {
		StringBuffer sb = new StringBuffer().append(getName()).append(" is paid hourly ")
				.append(getRate() * getHours());
		System.out.println(sb);
		return getRate() * getHours();
	}

	public Double getHours() {
		return this.hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate() + ", rate="
				+ getRate() + ", hours=" + getHours();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}

		HourlyEmployee e = (HourlyEmployee) obj;

		return super.equals(obj) && Objects.equals(getHours(), e.getHours()) && Objects.equals(getRate(), e.getRate());
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ Objects.hash(getHours(), getRate());
	}

	@Override
	public double payTaxes() {
		return getRate() * getHours() * TaxPayer.HOURLY_TAX_RATE;
	}

}