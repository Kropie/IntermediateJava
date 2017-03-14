/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.util;

import com.entertainment.Television;

/**
 * Utility class to assist with {@code Television}
 * {@link com.entertainment.Television.DisplayType display type} operations.
 *   
 * @deprecated with no replacement.
 */
@Deprecated
public class TelevisionDisplayAdvisor {
  /**
   * Checks each supplied {@code Television}'s display type, and indicates need for 
   * upgrade if current {@link com.entertainment.Television.DisplayType display type} is CRT.
   * 
   * @param tvs varargs parameter of Televisions to check for display upgrade.
   * @return suitable upgrade advice message. This message is also printed to stdout.
   */
  public static String check(Television... tvs) {
    // DONE
    String result = null;
    boolean foundCrt = false;
    
    for (Television tv : tvs) {
      if (tv.getDisplay() == Television.DisplayType.CRT) {  // OK to use == here (why?)
        result = "Television with display type " + tv.getDisplay() + " should be upgraded";
        System.out.println(result);
        foundCrt = true;
      }
    }
    if (!foundCrt) {
      result = "No televisions need to be upgraded";
      System.out.println(result);
    }
    return result;
  }
}