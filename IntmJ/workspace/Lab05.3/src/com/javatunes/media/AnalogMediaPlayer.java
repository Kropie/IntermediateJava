package com.javatunes.media;

import org.media.standard.MediaPlayer;

public class AnalogMediaPlayer implements MediaPlayer {

	private static final String[] CONTENT_TYPES = { "cassette" , "vhs"};

	@Override
	public String[] getSupportedContentTypes() {
		// TODO Auto-generated method stub
		return CONTENT_TYPES;
	}

	@Override
	public String play() {
	    return "AnalogMediaPlayer playing analog media";

	}

}
