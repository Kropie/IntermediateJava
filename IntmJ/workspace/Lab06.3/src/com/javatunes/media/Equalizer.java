package com.javatunes.media;

public class Equalizer extends PlayerEffect {
	
	private EqualizerMode equalizerMode;
	private static final EqualizerMode DEFAULT_EQUALIZER_MODE = EqualizerMode.NORMAL;

	public Equalizer(Player player) {
		super(player);
		setEqualizerMode(DEFAULT_EQUALIZER_MODE);
	}
	
	public Equalizer(Player player, EqualizerMode equalizerMode) {
		super(player);
		setEqualizerMode(equalizerMode);
	}

	@Override
	public void play() {
		System.out.println("Equalizer has been applied with a mode of " + equalizerMode);
		super.play();
	}

	public EqualizerMode getEqualizerMode() {
		return equalizerMode;
	}

	public void setEqualizerMode(EqualizerMode equalizerMode) {
		this.equalizerMode = equalizerMode;
	}
}
