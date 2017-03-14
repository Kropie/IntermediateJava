/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Interfaces
 *
 * This class defines a Radio.  It will implement Volume easily
 *
 *
 * This class performs no data validation;  however, it
 * mutes/unmutes appropriately, i.e., can't mute a muted
 * Radio
 */

package com.entertainment;

// TODO add in declaration for implementing Volume
public class Radio

{
   // INSTANCE VARIABLES
	private int volume;       // the volume

	// for muting behavior
	private int oldVolume;
	private boolean isMuted;

   // CONSTRUCTORS
   public Radio()
   {
      super();
   }

   public Radio(int volumeIn)
   {
      super();
      this.setVolume(volumeIn);
   }


   // ACCESSOR METHODS
   // from interface Volume
   public void setVolume(int volumeIn)
   {
      // delegate to contained VolumeControl object
      volume = volumeIn;
   }

/* TODO - Uncomment this method so Radio will compile after implementing the interface 
   // from interface IVolume
   public int getVolume()
   {
      return volume;
   }
*/

   // from interface IVolume
   // BEHAVIORAL METHODS
   public void mute()
   {
      if (!this.isMuted())   // not currently muted
      {
         // store current volume in oldVolume
         oldVolume = volume;
         
         // set volume to zero
         this.setVolume(0);
      }
      else              // currently muted
      {
         // restore volume from oldVolume value
         this.setVolume(oldVolume);
      }
      
      // toggle muted flag
      isMuted = !isMuted;
   }
   

   // from interface IVolume
   public boolean isMuted()
   {
      // delegate to contained VolumeControl object
      return isMuted;
   }


   // returns a string representation of this class instance
   @Override
   public String toString()
   {
      // this method uses the "ternary" (three terms) operator
      // (expression ? true-value : false-value)
      // it's just a very compact if-else statement

      return "Radio: volume=" +
         (!this.isMuted() ? String.valueOf(volume) : "<muted>");
   }
}
