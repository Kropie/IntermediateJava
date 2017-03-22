/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.entertainment.Television;

public class Catalog {
  // in-memory catalog of Televisions
  private static final Collection<Television> catalog = new ArrayList<>(30);

  // prevent direct instantiation, this is an all-static class
  private Catalog() {
  }
  
  /**
   * Searches catalog by brand.
   * Returns a collection of matching Televisions.
   * COMPLETED: change Object return type.
   * TODONE: implement the method and test it.
   */
  public static Collection<Television> findByBrand(String brand) {
    Collection<Television> retval = new ArrayList();
    
    for (Television television : catalog) {
		if (television.getBrand() == null ? brand == null : television.getBrand().equals(brand)) {
			retval.add(television);
		}
	}
    
    return retval;
  }
  
  /**
   * Searches catalog by several brands.
   * Returns a map with an entry for each brand supplied, 
   * along with a collection of matching Televisions for that brand. 
   * COMPLETED: change Object return type.
   * TODONE: implement the method and test it.
   */
  public static Collection<Television> findByBrands(String... brands) {
    // TODO: create a bucket for results - a no-matches result is an empty map (not null)
	  Collection<Television> result = new ArrayList<>();
    for (String brand : brands) {
		for (Television television : catalog) {
			if (television.getBrand() == null ? brand == null : television.getBrand().equals(brand)) {
				result.add(television);
			}
		}
	}
    
    return result;
  }

  /**
   * Returns entire catalog.
   * NOTE: returning direct reference has serious consequences -
   * a client can manipulate it, since it has a direct reference to it.
   * Sometimes this is okay, but not here.
   * TODONE: change this to return a read-only view of the catalog - see Collections *class*
   */
  public static Collection<Television> getInventory() {
    return Collections.unmodifiableCollection(catalog);
  }

  /*
   * Loads catalog.
   * Static initializers execute when the class is loaded into the JVM.
   */
  static {
    catalog.add(new Television("Zenith",  0));
    catalog.add(new Television("Sony",    4));
    catalog.add(new Television("Sony",    50));
    catalog.add(new Television("Zenith",  33));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("Zenith",  86));
    catalog.add(new Television("Hitachi", 13));
    catalog.add(new Television("Hitachi", 40));
    catalog.add(new Television("Zenith",  46));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("Sony",    94));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("Sony",    50));
    catalog.add(new Television("Hitachi", 50));
    catalog.add(new Television("Zenith",  37));
    catalog.add(new Television("RCA",     31));
    catalog.add(new Television("Sony",    87));
    catalog.add(new Television("Hitachi", 39));
    catalog.add(new Television("Zenith",  27));
    catalog.add(new Television("Zenith",  12));
    catalog.add(new Television("RCA",     10));
    catalog.add(new Television("Hitachi", 50));
    catalog.add(new Television("RCA",     4));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("Sony",    28));
    catalog.add(new Television("Zenith",  50));
    catalog.add(new Television("Zenith",  77));
    catalog.add(new Television("Sony",    22));
    catalog.add(new Television("RCA",     50));
  }
}
