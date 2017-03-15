/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

class Tuner {
	private int channel = 3; // default channel for cable and satellite
								// customers
	public static final int MAX_CHANNEL = 999;
	public static final int MIN_CHANNEL = 1;

	public int getChannel() {
		return this.channel;
	}

	public void setChannel(int channel) {
		if (channel <= MAX_CHANNEL && channel >= MIN_CHANNEL) {
			this.channel = channel;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + channel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuner other = (Tuner) obj;
		if (channel != other.channel)
			return false;
		return true;
	}

}