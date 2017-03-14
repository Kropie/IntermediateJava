/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.mytime;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Test;

public class DateTimeTest {
  
	/**
	 * TASK: create current date, time, and date-time via now() and print them.
	 */
  @Test
  public void testNow() {
    // TODO
  }
  
	@Test
	public void testCreateAndGetValues() {
	  // TODO: create your birthday via of() and verify some of the fields are correct
	  
	  // TODO: what day of the week were you born on? (you can use visual inspection)
	  
	  // TODO: what day of the year were you born on? [1-366] (you can use visual inspection)
	  // Note: try this using the generalized get(TemporalField) method
	  
	  // OPTIONAL: use of() to represent the 1st lunar landing as a date-time - it happened on 7/20/69 at 3:18pm eastern time
	  // Note: ignore time-zone, just assume eastern time is the local time
	  // You can just print the date-time, and/or verify its fields with assertions
	  
	}
	
	/**
	 * NOTE: verify these via JUnit assertions.
	 * Use visual inspection (sysout) if you are pressed for time.
	 */
	@Test
	public void testParse() {
		// TODO: create your birthday by parsing a text representation in standard format
	  
	  // TODO: now create it by parsing text in the form "2/15/2016"
	  
	  // TODO: create the training class start time by parsing a text representation in standard format
	  
	  // TODO: now create it by parsing text in the form "8:30AM"
	  
	  // OPTIONAL: create the training class start date-time by parsing text in the form "2/15/2016 @ 8:30am"
	  // Note: the 'am' is deliberately lowercase.
	  // solution 1: use a formatter builder to remove case sensitivity from the parse (example in coursebook).
	  
	  // solution 2: pre-process the input text for easier parsing.
	  
	}
	
	/**
	 * TASK: create format strings from the date below in these formats:
	 *  10/14/1066
	 *  14-10-1066
	 *  October 14, 1066 (hint: use MMMM for the full month, works for all months)
	 */
	@Test
	public void testFormat() {
	  LocalDate hastings = LocalDate.of(1066, 10, 14);
	  
	  // TODO: 10/14/1066
	  	  
	  // TODO: 14-10-1066
	  
	  // TODO: October 14, 1066
	  
	}
}