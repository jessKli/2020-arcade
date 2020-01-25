package se.klinc.arcade.service;

import se.klinc.arcade.domain.Box;

public interface BoxGame {

  /**
   * Create three boxes.
   */
  Box[] createBoxes();

  /**
   * Create the boxContestant and play the game equally many times with change the box as
   * not changeing the box.
   * @param numberOfGames number of times to play the game
   * @return result from the played rounds
   */
  String startBoxGames(String contestantName, int numberOfGames, Box... boxes);
}
