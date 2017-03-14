/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Before;
import org.junit.Test;
import com.entertainment.catalog.Catalog;

public class TelevisionSortAnonComparatorTest {
  private List<Television> tvList;
  
  @Before
  public void init() {
    tvList = new ArrayList<>(Catalog.getInventory());
  }
  
  @Test
  public void testSortVolume() {
    tvList.sort(new Comparator<Television> () {
      public int compare(Television tv1, Television tv2) {
        return Integer.compare(tv1.getVolume(), tv2.getVolume());
      }
    });
    assertEquals(0, tvList.get(0).getVolume());
    assertEquals(4, tvList.get(1).getVolume());
    assertEquals(4, tvList.get(2).getVolume());
    assertEquals(87, tvList.get(tvList.size() - 2).getVolume());
    assertEquals(94, tvList.get(tvList.size() - 1).getVolume());
  }
  
  /*
   * OPTIONAL part: sort by brand length (duplicate brands removed first)
   */
  @Test
  public void testSortBrandLength() {
    // filter out duplicate brands
    Set<Television> uniqueBrandsSet = new TreeSet<>(new Comparator<Television>() {
      public int compare(Television tv1, Television tv2) {
        return tv1.getBrand().compareTo(tv2.getBrand());
      }
    });
    uniqueBrandsSet.addAll(tvList);
    assertEquals(4, uniqueBrandsSet.size());
    
    // now make a List from it and sort it by brand length
    List<Television> uniqueBrandsList = new ArrayList<>(uniqueBrandsSet);
    uniqueBrandsList.sort(new Comparator<Television>() {
      public int compare(Television tv1, Television tv2) {
        return Integer.compare(tv1.getBrand().length(), tv2.getBrand().length());
      }
    });
    
    assertEquals(3, uniqueBrandsList.get(0).getBrand().length());  // "RCA"
    assertEquals(4, uniqueBrandsList.get(1).getBrand().length());  // "Sony"
    assertEquals(6, uniqueBrandsList.get(2).getBrand().length());  // "Zenith"
    assertEquals(7, uniqueBrandsList.get(3).getBrand().length());  // "Hitachi"
  }
  
  @Test
  public void testSortBrandLengthNoDups() {
    tvList.sort(new Comparator<Television>() {
      public int compare(Television tv1, Television tv2) {
        return Integer.compare(tv1.getBrand().length(), tv2.getBrand().length());
      }
    });
    assertEquals(3, tvList.get(0).getBrand().length());
    assertEquals(7, tvList.get(29).getBrand().length());
  }
}