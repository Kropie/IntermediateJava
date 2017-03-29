package com.javatunes.media;

public class NoiseReducer extends PlayerEffect {

	public NoiseReducer(Player player) {
		super(player);
	}

	@Override
	public void play() {
		System.out.println("Noise has been reduced");
		super.play();
	}

}
