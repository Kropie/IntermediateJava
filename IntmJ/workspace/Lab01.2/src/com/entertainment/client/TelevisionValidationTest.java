/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import com.entertainment.ChannelDisallowedException;
import com.entertainment.InvalidChannelException;
import com.entertainment.Television;

public class TelevisionValidationTest {

	public static void main(String[] args) {
		Television tv1 = new Television("RCA", 10); // invalid volume, should
														// remain 0 (the
														// default)
		System.out.println(tv1);

		// NOTE: to test exhaustively, check all "boundary values" (not doing
		// that here):
		// -1, 0 , 1 on the lower bound
		// 99, 100, 101 on the upper bound
		// we should also use a testing tool like JUnit (coming soon!)
		tv1.setVolume(50); // valid volume, should be accepted
		System.out.println(tv1);
//		tv1.setVolume(101); // invalid volume, should remain 50 from previous
							// setter call
		System.out.println(tv1);

		try {
			tv1.changeChannel(0);
		} catch (ChannelDisallowedException | InvalidChannelException e) {
			// TODO Auto-generated catch block
			System.out.println("STACK TRACE\n");
			e.printStackTrace();
			System.out.println("\nMESSAGE\n");
			System.out.println(e.getMessage());
			System.out.println("\nTOSTRING\n");
			System.out.println(e);
		} // invalid channel, should remain 3 (the default)
		System.out.println(tv1);
		try {
			tv1.changeChannel(9);
		} catch (ChannelDisallowedException | InvalidChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // valid channel, should be accepted
		System.out.println(tv1);
	}
}