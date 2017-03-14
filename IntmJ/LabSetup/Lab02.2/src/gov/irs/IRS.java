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
    for (TaxPayer payer : payers) {
      payer.payTaxes();
    }
  }
  
  // helper method to add a TaxPayer to the collection
  // what types of objects can be passed to this method?
  public void register(TaxPayer payer) {
    payers.add(payer);
  }
}