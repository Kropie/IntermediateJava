package com.entertainment;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.entertainment.Television.DisplayType;

public class TelevisionTest {

	private static Television tv;
	private static Television compareToTv;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tv = new Television();
		compareToTv = new Television();
	}

	@Test
	public void testHashCode() {
		assertTrue(new Television().hashCode() == new Television().hashCode());
		assertTrue(new Television("KROP", 10).hashCode() == new Television("KROP", 10).hashCode());
		assertTrue(new Television("J", 11, DisplayType.CRT).hashCode() == new Television("J", 11, DisplayType.CRT).hashCode());

	}

	@Test
	public void testChangeChannel() {
		tv.setParentalControl(false);
		
		int channel = 19;
		try {
			tv.changeChannel(channel);
			assertEquals(channel, tv.getCurrentChannel());
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			fail("An exception should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		}
	}
	
	@Test
	public void testChangeChannelChannelDisallowedException() {
		tv.setParentalControl(true);
		final int pcMaxChannel = 599;
		final int pcMinChannel = 500;
		
		
		int channel = pcMinChannel;
		try {
			tv.changeChannel(channel);
			fail("A ChannelDisallowedException should have been thrown");
		} catch (InvalidChannelException e) {
			fail("A InvalidChannelException should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		} catch (ChannelDisallowedException e) {
			// Do nothing, this is desired behavior.
		}

		channel = pcMaxChannel;
		try {
			tv.changeChannel(channel);
			fail("A ChannelDisallowedException should have been thrown");
		} catch (InvalidChannelException e) {
			fail("A InvalidChannelException should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		} catch (ChannelDisallowedException e) {
			// Do nothing, this is desired behavior.
		}
		
		channel = pcMaxChannel - 1;
		try {
			tv.changeChannel(channel);
			fail("A ChannelDisallowedException should have been thrown");
		} catch (InvalidChannelException e) {
			fail("A InvalidChannelException should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		} catch (ChannelDisallowedException e) {
			// Do nothing, this is desired behavior.
		}

		channel = pcMinChannel + 1;
		try {
			tv.changeChannel(channel);
			fail("A ChannelDisallowedException should have been thrown");
		} catch (InvalidChannelException e) {
			fail("A InvalidChannelException should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		} catch (ChannelDisallowedException e) {
			// Do nothing, this is desired behavior.
		}
	}
	
	
	
	public void testChangeChannelInvalidChannelException() {
		final int maxChannel = 999;
		final int minChannel = 1;
		
		int channel = maxChannel + 1;
		try {
			tv.changeChannel(channel);
			fail("An InvalidChannelException was supposed to be thrown");
		} catch (InvalidChannelException e) {
			// Do nothing, this is desired behavior.
		} catch (ChannelDisallowedException e) {
			fail("A ChannelDisallowedException should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		}

		channel = minChannel - 1;
		try {
			tv.changeChannel(channel);
			fail("An InvalidChannelException was supposed to be thrown");
		} catch (InvalidChannelException e) {
			// Do nothing, this is desired behavior.
		} catch (ChannelDisallowedException e) {
			fail("A ChannelDisallowedException should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		}
		
		channel = minChannel;
		try {
			tv.changeChannel(channel);
		} catch (InvalidChannelException e) {
			// Do nothing, this is desired behavior.
			fail("An InvalidChannelException should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		} catch (ChannelDisallowedException e) {
			fail("A ChannelDisallowedException should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		}
		
		channel = maxChannel;
		try {
			tv.changeChannel(channel);
		} catch (InvalidChannelException e) {
			// Do nothing, this is desired behavior.
			fail("An InvalidChannelException should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		} catch (ChannelDisallowedException e) {
			fail("A ChannelDisallowedException should not have been thrown when changing the "
					+ "channel to a value of " + channel);
		}
		
	}

	@Test
	public void testCompareTo() {
		String brand1 = "KROP";
		String brand2 = brand1;
		int channel1 = 10;
		int channel2 = 11;
		tv.setBrand(brand1);
		compareToTv.setBrand(brand2);
		try {
			tv.changeChannel(channel1);
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			// This test does not test when the exceptions are thrown.
		}
		try {
			compareToTv.changeChannel(channel2);
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			// This test does not test when the exceptions are thrown.
		}
		if(compareToTv.compareTo(tv) < 0) {
			fail("tv should have come before compareToTv");
		}
		
		brand1 = "KROP";
		brand2 = brand1;
		channel1 = 12;
		channel2 = 11;
		tv.setBrand(brand1);
		compareToTv.setBrand(brand2);
		try {
			tv.changeChannel(channel1);
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			// This test does not test when the exceptions are thrown.
		}
		try {
			compareToTv.changeChannel(channel2);
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			// This test does not test when the exceptions are thrown.
		}
		if(tv.compareTo(compareToTv) < 0) {
			fail("tv should have come after compareToTv");
		}

		brand1 = "jonathan";
		brand2 = "kropfinger";
		channel1 = 12;
		channel2 = 11;
		tv.setBrand(brand1);
		compareToTv.setBrand(brand2);
		try {
			tv.changeChannel(channel1);
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			// This test does not test when the exceptions are thrown.
		}
		try {
			compareToTv.changeChannel(channel2);
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			// This test does not test when the exceptions are thrown.
		}
		if(tv.compareTo(compareToTv) > 0) {
			fail("tv should have come after compareToTv");
		}
		
		brand1 = "zjonathan";
		brand2 = "kropfinger";
		channel1 = 12;
		channel2 = 11;
		tv.setBrand(brand1);
		compareToTv.setBrand(brand2);
		try {
			tv.changeChannel(channel1);
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			// This test does not test when the exceptions are thrown.
		}
		try {
			compareToTv.changeChannel(channel2);
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			// This test does not test when the exceptions are thrown.
		}
		if(compareToTv.compareTo(tv) > 0) {
			fail("tv should have come before compareToTv");
		}
		
		brand1 = "zjonathan";
		brand2 = brand1;
		channel1 = 12;
		channel2 = channel1;
		tv.setBrand(brand1);
		compareToTv.setBrand(brand2);
		try {
			tv.changeChannel(channel1);
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			// This test does not test when the exceptions are thrown.
		}
		try {
			compareToTv.changeChannel(channel2);
		} catch (InvalidChannelException | ChannelDisallowedException e) {
			// This test does not test when the exceptions are thrown.
		}
		if(compareToTv.compareTo(tv) != 0) {
			fail("tv should have come before compareToTv");
		}
	}

	@Test
	public void testEqualsObject() {
		assertTrue(new Television().equals(new Television()));
		assertTrue(new Television("KROP", 10).equals(new Television("KROP", 10)));
		assertTrue(new Television("J", 11, DisplayType.CRT).equals(new Television("J", 11, DisplayType.CRT)));
	}

	@Test
	public void testSetVolume() {
		int vol = 10;
		tv.setVolume(vol);
		assertEquals(vol, tv.getVolume());
		
		vol = 99;
		tv.setVolume(vol);
		assertEquals(vol, tv.getVolume());
	}
	
	@Test
	public void testSetVolumeIllegalArgumentException() {
		int minVol = 0;
		int maxVol = 100;
		
		try {
			tv.setVolume(minVol - 1);
			fail("Expected an IllegalArgumentException to get thrown");
		} catch (IllegalArgumentException e) {
			// Test passed
		}
		
		try {
			tv.setVolume(maxVol + 1);
			fail("Expected an IllegalArgumentException to get thrown");
		} catch (IllegalArgumentException e) {
			// Test passed
		}
		tv.setVolume(maxVol - 10); 
	}

}
