/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

public enum Location {
	USA(new USATax()), EUROPE(new EuropeTax()), ONLINE(new OnlineTax());

	private TaxCalculator calc;

	private Location(TaxCalculator calc) {
		this.calc = calc;
	}
	
	public TaxCalculator getTaxCalculator() {
		return calc;
	}
}