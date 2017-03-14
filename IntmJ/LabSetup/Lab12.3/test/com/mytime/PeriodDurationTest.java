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
import java.time.Duration;
import java.time.Instant;
import org.junit.Test;

public class PeriodDurationTest {

  /**
   * TASK: what is the age difference (in years and months)
   * between your parents, or any other 2 people you know?
   * 
   * RESULT:
   */
  @Test
  public void testAgeDifference() {
    // TODO
  }

  /**
   * TASK: how long is it until your next birthday (in months and days)?
   * Note: for testability, you can hardcode today's date using of(), instead of using now();
   *   that way, your assertions will still work tomorrow!
   * Note: consider using the until() method of LocalDate to determine the answer (more API exposure).
   * 
   * RESULT:
   */
  @Test
  public void testNextBirthday() {
    // TODO
  }
  
  /**
   * TASK: Halley's comet orbits the sun every 75-76 years, and was last seen from Earth in 1986.
   *  1. Model its orbit as an integral number of years, using Period or Duration as appropriate.
   *  2. Calculate the year of its next appearance on Earth.
   * Note: consider using the Year class (more API exposure).
   * 
   * RESULT:
   */
  @Test
  public void testNextHalleysComet() {
    // TODO
  }
  
  /**
   * TASK: run the test below and compare the results of these two techniques to measure execution time of a method:
   *  - System.nanoTime() before and after the call, then get the difference and convert to millis.
   *  - Instant.now() before and after the call, then get the Duration between them and convert to millis.
   * 
   * RESULT:
   *  System.nanoTime() is more precise. Read the Javadoc for this method, and then for Instant.now().
   *  See also http://stackoverflow.com/questions/20689055/java-8-instant-now-with-nanosecond-resolution.
   */
  @Test
  public void testPerformance() {
    long start1 = System.nanoTime();
    businessWork();
    long end1 = System.nanoTime();
    
    double elapsedMillis1 = (end1 - start1) / 1000000.0;
    System.out.println("Execution time (ms) via System.nanoTime(): " + elapsedMillis1);
    
    
    Instant start2 = Instant.now();
    businessWork();
    Instant end2 = Instant.now();
    
    Duration duration = Duration.between(start2, end2);
    double elapsedMillis2 = duration.toNanos() / 1000000.0;
    System.out.println("Execution time (ms) via Instant.now(): " + elapsedMillis2);
  }
  
  /**
   * OPTIONAL: scientist have found that something very special occurs in regular intervals,
   * specifically every 5 hours, 5 minutes, and 5 seconds.
   * For testing purposes, the last special event occurred on Feb 18, 2016 at 10:16:48am.
   *  1. Model this interval as a Period or Duration, as appropriate.
   *  2. Determine when the next 3 occurrences of this special event will be.
   * 
   * RESULT:
   */
  @Test
  public void testSpecialEvent() {
    // TODO
  }
  

  /**
   * This method simulates actual business work.
   * It takes between 0 and 1500ms to complete.
   */
  public static void businessWork() {
    try { Thread.sleep((long) (Math.random() * 1500)); }
    catch (InterruptedException ignored) {}
  }
}