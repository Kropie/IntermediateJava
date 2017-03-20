/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package gov.irs;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Note the interface type TaxPayer, used throughout the class.
 */
public class IRS {
	// what types of objects can this collection contain?
	private Collection<TaxPayer> payers = new ArrayList<TaxPayer>();

	// what methods are available on each 'payer' reference?
	public void collectTaxes() {
		StringBuffer sb = new StringBuffer();
		for (TaxPayer payer : payers) {
			if (payer instanceof NamedEntity) {
				((NamedEntity) payer).getName();
				sb.append(((NamedEntity) payer).getName())
				.append(" paid $")
				.append(payer.payTaxes())
				.append(" of taxes this year");
				System.out.println(sb);
			} else {
				sb.append(payer.toString())
				.append(" paid $").append(payer.payTaxes()).append(" of taxes this year ");
				System.out.println(sb);
			}
			sb.setLength(0);
		}
	}

	// helper method to add a TaxPayer to the collection
	// what types of objects can be passed to this method?
	public void register(TaxPayer payer) {
		payers.add(payer);
	}
}