package com.javatunes.media;

import org.media.standard.MediaPlayer;
import org.media.standard.MediaPlayerFactory;

public class AnalogMediaPlayerFactory implements MediaPlayerFactory {

	@Override
	public MediaPlayer newPlayer() {
		return new AnalogMediaPlayer();
	}

}
