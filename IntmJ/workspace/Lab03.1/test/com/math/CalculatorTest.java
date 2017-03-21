/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		assertEquals(5, calc.add(1, 4)); // expected, actual
	}
	
	@Test
	public void testDivide() {
		Calculator calc = new Calculator();
		assertEquals((long)2, (long)calc.divide(8, 4));
		assertEquals((long)3, (long)calc.divide(12, 4));
		// The final parameter is the delta that is acceptable from the expected and actual results.
		assertEquals(2.5, calc.divide(5, 2), 0.001);
	}
	
	@Test
	public void testIsEven() {
		Calculator calc = new Calculator();
		assertTrue(!calc.isEven(13));
		assertTrue(calc.isEven(12));
		assertTrue(calc.isEven(Integer.MIN_VALUE));
		assertTrue(!calc.isEven(Integer.MAX_VALUE));
	}
}