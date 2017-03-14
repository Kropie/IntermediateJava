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
import org.junit.Test;
import com.javatunes.media.Player;
import com.javatunes.media.Radio;
import com.javatunes.media.Television;

public class PlayerTest {

  @Test
  public void testUndecoratedPlayer() {
    Player p1 = new Television();
    p1.play();
    
    Player p2 = new Radio();
    p2.play();
  }
  
  /**
   * Example: Television with sound leveling and noise reduction applied.
   * Uncomment below after SoundLeveler and NoiseReducer have been written.
   */
  @Test
  public void testSoundLevelerNoiseReducerTelevision() {
    // Player p = new SoundLeveler(new NoiseReducer(new Television()));
    // p.play();
  }
}