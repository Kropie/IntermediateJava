/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.media;

public abstract class PlayerEffect
implements Player {
  // the decorated object - protected so subclasses have direct access to it
  protected Player decoratedPlayer;
  
  public PlayerEffect(Player player) {
    this.decoratedPlayer = player;
  }
  
  // pass-thru to decorated Player
  public void play() {
    decoratedPlayer.play();
  }
}