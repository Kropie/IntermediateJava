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

public class RadioMediaPlayer
implements MediaPlayer {
  
  private static final String[] CONTENT_TYPES = {"AM, FM"};

  public String[] getSupportedContentTypes() {
    return CONTENT_TYPES;
  }
  
  public String play() {
    return "RadioMediaPlayer playing radio media";
  }
}