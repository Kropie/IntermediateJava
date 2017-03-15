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

public class Television implements Comparable<Television>{
  private String brand;
  private int volume;
  private Tuner tuner = new Tuner();  // set up internally and used for channel management
  
  public Television() {
  }
  
  public Television(String brand, int volume) {
    setBrand(brand);
    setVolume(volume);
  }
  
  public String getBrand() {
    return this.brand;
  }
  public void setBrand(String brand) {
    this.brand = brand;
  }
  
  public int getVolume() {
    return this.volume;
  }
  public void setVolume(int volume) {
    this.volume = volume;
  }
  
  public int getCurrentChannel() {
    return tuner.getChannel();  // delegate to contained Tuner object
  }
  
  public void changeChannel(int channel) {
    tuner.setChannel(channel);  // delegate to contained Tuner object
  }
  
  public String toString() {
    return getClass().getSimpleName() + " [brand=" + getBrand() + ", volume=" + getVolume() + ", currentChannel=" + getCurrentChannel() + "]";
  }

@Override
public int hashCode() {
	return Objects.hash(getBrand(), getVolume(), getCurrentChannel());
}

@Override
public boolean equals(Object obj) {
	boolean result = false;
	if(obj instanceof Television) {
		Television other = (Television) obj;
		result = Objects.equals(this.getBrand(), other.getBrand())
				&& Objects.equals(this.getCurrentChannel(), other.getCurrentChannel())
				&& Objects.equals(this.getVolume(), other.getVolume());
	}
	return result;
}

	@Override
	public int compareTo(Television arg0) {
		int retval = 0;
		retval = this.getBrand().compareTo(arg0.getBrand());
		retval = (retval == 0) ? Integer.compare(this.getVolume(), arg0.getVolume()) : retval;
		return retval;
	}
}