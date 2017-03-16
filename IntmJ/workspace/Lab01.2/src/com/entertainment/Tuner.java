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
	public static final int PC_MAX_CHANNEL = 599;
	public static final int PC_MIN_CHANNEL = 500;
	
	private boolean parentalControl;

	public boolean isParentalControl() {
		return parentalControl;
	}

	public void setParentalControl(boolean parentalControl) {
		this.parentalControl = parentalControl;
	}

	public int getChannel() {
		return this.channel;
	}

	public void setChannel(int channel) throws InvalidChannelException, ChannelDisallowedException{
		if (!parentalControl && (channel <= MAX_CHANNEL && channel >= MIN_CHANNEL)) {
			this.channel = channel;
		} else if (!parentalControl) {
			StringBuffer sb = new StringBuffer().append("Channel value of ")
					.append(channel).append(" is not in the range of [").append(MIN_CHANNEL)
					.append(",").append(MAX_CHANNEL).append("]");
			throw new InvalidChannelException(sb.toString());
		} else if(parentalControl && !(channel > PC_MAX_CHANNEL && channel < PC_MIN_CHANNEL)) {
			StringBuffer sb = new StringBuffer().append("Channel value of ")
					.append(channel).append(" is not in the range of [").append(PC_MIN_CHANNEL)
					.append(",").append(PC_MAX_CHANNEL).append("]");
			throw new ChannelDisallowedException(sb.toString());
		} else {
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