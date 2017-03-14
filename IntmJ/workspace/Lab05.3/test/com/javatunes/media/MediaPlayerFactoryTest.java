/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.media;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import org.media.standard.MediaPlayer;
import org.media.standard.MediaPlayerFactory;

public class MediaPlayerFactoryTest {
  
  private static final String RADIO_FACTORY_CLASS_NAME = "com.javatunes.media.RadioMediaPlayerFactory";
  private static final String INTERNET_FACTORY_CLASS_NAME = "com.javatunes.media.InternetMediaPlayerFactory";

  @Test
  public void testRadioPlayer() {
    MediaPlayerFactory factory = MediaPlayerFactory.newInstance(RADIO_FACTORY_CLASS_NAME);
    MediaPlayer player = factory.newPlayer();
    assertEquals(RadioMediaPlayer.class, player.getClass());
    assertEquals("[AM, FM]", Arrays.toString(player.getSupportedContentTypes()));
    assertEquals("RadioMediaPlayer playing radio media", player.play());
    System.out.println(player.play());
  }

  @Test
  public void testInternetPlayer() {
    MediaPlayerFactory factory = MediaPlayerFactory.newInstance(INTERNET_FACTORY_CLASS_NAME);
    MediaPlayer player = factory.newPlayer();
    assertEquals(InternetMediaPlayer.class, player.getClass());
    assertEquals("[http, https, ftp]", Arrays.toString(player.getSupportedContentTypes()));
    assertEquals("InternetMediaPlayer playing internet media", player.play());
    System.out.println(player.play());
  }
}