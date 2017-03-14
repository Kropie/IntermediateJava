/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.media;

import org.media.standard.MediaPlayer;
import org.media.standard.MediaPlayerFactory;

public class InternetMediaPlayerFactory
implements MediaPlayerFactory {

  public MediaPlayer newPlayer() {
    return new InternetMediaPlayer();
  }
}