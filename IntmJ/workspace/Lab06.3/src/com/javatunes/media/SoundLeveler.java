package com.javatunes.media;

public class SoundLeveler extends PlayerEffect {

	public SoundLeveler(Player player) {
		super(player);
	}

	@Override
	public void play() {
		super.play();
		System.out.println("Sound has been leveled!");
	}

}
