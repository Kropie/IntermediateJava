/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public interface Volume {
	public static final int SILENT_VOLUME = 0;
	
	public void setVolume(int volume);

	public int getVolume();

	public void mute();

	public boolean isMuted();

	public default void silence() {
		setVolume(SILENT_VOLUME);
	}

	public static void silenceAll(Volume... volumes) {
		for (Volume volume : volumes) {
			volume.silence();
		}
	}
}