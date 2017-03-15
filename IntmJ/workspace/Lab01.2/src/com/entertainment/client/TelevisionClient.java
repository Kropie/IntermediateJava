/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import java.util.HashSet;
import java.util.Set;

import com.entertainment.Television;
import com.entertainment.Television.DisplayType;

public class TelevisionClient {

	public static void main(String[] args) {
		Television tv1 = new Television();
		System.out.println(tv1);
		System.out.println();

		Television tv2 = new Television("RCA", 10);
		System.out.println(tv2);
		tv2.changeChannel(9);
		System.out.println(tv2);
		System.out.println();

		Television tvA = new Television("Sony", 50);
		Television tvB = new Television("Sony", 50);
		System.out.println(tvA);
		System.out.println(tvB);
		System.out.println("tvA == tvB: " + (tvA == tvB));
		System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));

		Set<Television> tvs = new HashSet<Television>();
		tvs.add(tvA);
		tvs.add(tvB);
		System.out.println(tvs.size());
		System.out.println(tvs);

		/*
		 * The following was added for lab 1.4 where we learned about packages
		 * and enums.
		 */
		Television tvC = new Television();
		System.out.println(tvC);
		tvC = new Television("JON", 11, DisplayType.CRT);
		System.out.println(tvC);
		tvC.setDisplayType(DisplayType.OLED);
		System.out.println(tvC);
	}
}