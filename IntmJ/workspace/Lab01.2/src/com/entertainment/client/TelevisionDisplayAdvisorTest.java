/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import com.entertainment.Television;
import com.entertainment.Television.DisplayType;
import com.entertainment.util.TelevisionDisplayAdvisor;

public class TelevisionDisplayAdvisorTest {
  
  public static void main(String[] args) {
    // NOTE: TelevisionDisplayAdvisor.check() is a static method, so it's called via the classname
    
    // COMPLETED: pass individual instances
    TelevisionDisplayAdvisor.check(new Television("J", 11, DisplayType.CRT),
    		                       new Television("K", 10, DisplayType.OLED),
    		                       new Television("O", 9, DisplayType.PLASMA));
    System.out.println("-----");
    
    // COMPLETED: pass nothing
    TelevisionDisplayAdvisor.check();
    System.out.println("-----");
    
    // COMPLETED: pass an array - would only do this if you already had one, otherwise just pass individual instances
    Television[] tvArray = { new Television("J", 11, DisplayType.LED),
            new Television("K", 10, DisplayType.OLED),
            new Television("O", 9, DisplayType.PLASMA)};
    TelevisionDisplayAdvisor.check(tvArray);
    System.out.println("-----");
  }
}