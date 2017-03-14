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

/**
 * Manages {@code Television} inventory. Provides several 
 * {@link #findByBrand(String) finder} methods for searching.
 * 
 * @author Derek Smalls
 * @version 2.0
 * @see "Entertainment API 2.0 Specification"
 */
public class Catalog {
  // in-memory catalog of Televisions
  private static final Collection<Television> catalog = new ArrayList<>(30);

  // prevent direct instantiation, this is an all-static class
  private Catalog() {
  }
  
  /**
   * Searches catalog by brand. A most useful feature!
   * 
   * @param brand the specified brand. Searches are case-sensitive.
   * @return collection of matching Televisions - never null.
   * @see #findByBrands(String...)
   * @see java.lang.String#equals(Object)
   * @since 1.2
   */
  public static Collection<Television> findByBrand(String brand) {
    // DONE: create a bucket for results - a no-matches result is an empty collection (not null)
    Collection<Television> result = new ArrayList<>();

    // DONE: perform the search and return the result
    for (Television tv : catalog) {
      if (tv.getBrand().equals(brand)) {
        result.add(tv);
      }
    }
    return result;
  }
  
  /**
   * Searches catalog by several brands.
   * Returns a {@link java.util.Map Map} with an entry for each brand supplied, 
   * along with a collection of matching {@code Television}s for that brand.
   * 
   * @param brands varargs parameter of desired brands.
   * @return map of brand-collection entries for each brand found - never null.
   * @see java.util.Map
   */
  public static Map<String,Collection<Television>> findByBrands(String... brands) {
    // DONE: create a bucket for results - a no-matches result is an empty map (not null)
    Map<String,Collection<Television>> result = new HashMap<>();
    
    // DONE: perform the search and return the result
    // delegate to single-brand finder, store returned collection in map
    for (String brand : brands) {
      Collection<Television> tvs = findByBrand(brand);
      result.put(brand, tvs);
    }
    return result;
  }

  /**
   * Returns entire catalog.<br>
   * <b>NOTE:</b> returned collection is read-only.
   * 
   * @return read-only view of Catalog inventory.
   */
  public static Collection<Television> getInventory() {
    // return catalog;
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
