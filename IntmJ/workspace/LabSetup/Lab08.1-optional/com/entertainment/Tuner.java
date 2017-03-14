package com.entertainment;

/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-12 LearningPatterns Inc.
 */

/*
 * Composition (Optional)
 *
 * This class is a tuner component that can be
 * used by classes that need to change channels, such as Television.
 *
 * Its set of public methods is very simple (getting/setting a channel) but internally
 * it contains complex functionality - making it ideal to encapsulate in its own class 
 * The functionality we include here doesn't do any actual tuner-related work.  It is illustrative only
 *
 */

public class Tuner {
	
	public String channel = "";
	public long station = 0;
	
	public void setChannel (String channelIn) {
		if (isValid(channelIn)) {
			channel = channelIn;
			findStation(channelIn);
			goToStation();
		}
	}
	
	public String getChannel() {
		return channel;
	}
	
	private boolean isValid(String channelIn) {
		boolean isValid = true;
		if (channelIn.equals("none")) {
			isValid = false;
		}
		System.out.println("Tuner: Validity of channel: " + channelIn + " : " + isValid);
		return isValid;
	}
	
	private void findStation(String channelIn) {
		station = channelIn.hashCode();
		System.out.println("Tuner: Station is: " + station);
	}
	
	private void goToStation() {
		System.out.println("Tuner: Going to station: " + station);
	}

}
