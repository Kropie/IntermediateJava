/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import java.util.Objects;

/**
 * This class does not implement the java bean class because the setter for the channel
 * does not adhere to the bean naming convention (set"fieldName")
 * 
 * @author Jonathan Kropfinger
 *
 */
public class Television implements Comparable<Television> {
	public enum DisplayType {
		LCD,LED,OLED,PLASMA,CRT;
	}
	private String brand;
	private int volume;
	private DisplayType displayType;

	private Tuner tuner = new Tuner(); // set up internally and used for channel
										// management

	public Television() {
	}
	
	public Television(String brand, int volume) {
		setBrand(brand);
		setVolume(volume);
	}

	public Television(String brand, int volume, DisplayType displayType) {
		super();
		this.brand = brand;
		this.volume = volume;
		this.displayType = displayType;
	}

	public void changeChannel(int channel) {
		tuner.setChannel(channel); // delegate to contained Tuner object
	}

	/**
	 * This will first sort by the brand. If the brands are equivalent then this
	 * will sort by the channel.
	 * 
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Television arg0) {
		int retval = 0;
		retval = this.getBrand().compareTo(arg0.getBrand());
		retval = (retval == 0) ? Integer.compare(this.getVolume(), arg0.getVolume()) : retval;
		return retval;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Television) {
			Television other = (Television) obj;
			result = Objects.equals(this.getBrand(), other.getBrand())
					&& Objects.equals(this.getCurrentChannel(), other.getCurrentChannel())
					&& Objects.equals(this.getVolume(), other.getVolume())
					&& Objects.equals(this.getDisplayType(), other.getDisplayType());
		}
		return result;
	}

	public String getBrand() {
		return this.brand;
	}

	public int getCurrentChannel() {
		return tuner.getChannel(); // delegate to contained Tuner object
	}
	
	public DisplayType getDisplayType() {
		return displayType;
	}
	
	public int getVolume() {
		return this.volume;
	}

	/**
	 * Objects.hash was introduced in Java 7.
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getBrand(), getVolume(), getCurrentChannel(), getDisplayType());
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setDisplayType(DisplayType type) {
		displayType = type;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public String toString() {
		return getClass().getSimpleName() + " [brand=" + getBrand() + ", volume=" + getVolume() + ", currentChannel="
				+ getCurrentChannel() + ", displayType=" + getDisplayType()  + "]";
	}
}