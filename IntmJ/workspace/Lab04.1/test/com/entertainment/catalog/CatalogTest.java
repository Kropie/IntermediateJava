package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.entertainment.Television;

public class CatalogTest {

	protected static Collection<Television> catalog;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		catalog = Catalog.getInventory();
	}

	@Test
	public void testFindByBrand() {
		String brand = "Sony";
		assertFalse(Catalog.findByBrand(brand).isEmpty());
		
		brand = "KROPFINGER";
		assertTrue(Catalog.findByBrand(brand).isEmpty());
	}

	@Test
	public void testFindByBrands() {
		String b1 = "Sony";
		String b2 = "Kropfinger";
		String b3 = "RCA";
		assertTrue(Catalog.findByBrands(b1,b2).size() == 7);
		System.out.println("Looking for brands: " + b1 + ", " + b2 + "\n" + Catalog.findByBrands(b1,b2));
		assertTrue(Catalog.findByBrands(b1,b2,b3).size() == 16);
	}

	@Test
	public void testGetInventory() {
		try {
			Catalog.getInventory().add(new Television());
			fail("The catalog collection should not be modifiable!");
		} catch (UnsupportedOperationException e) {
			// The test worked. Yay!
		}
	}
	
	@Test
	public void testRemovingDuplicates() {
		Collection<Television> catalog = Catalog.getInventory();
		Set<Television> testCollection = new HashSet<>(catalog);
		
		int sonyCount = 0;
		for (Television tv : testCollection) {
			if(tv.getBrand().equals("RCA")) {
				sonyCount ++;
			}
		}
		
		assertTrue(sonyCount == 4);
	}

}
