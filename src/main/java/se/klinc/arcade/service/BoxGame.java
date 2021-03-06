package se.klinc.arcade.service;

import se.klinc.arcade.domain.Box;
import se.klinc.arcade.domain.ResultContenstant;

import java.util.List;

public interface BoxGame {

  /**
   * Create three boxes.
   */
  Box[] createBoxes();

  /**
   * Create the boxContestant and play the game equally many times with change the box as
   * not changing the box.
   * @param numberOfGames number of times to play the game.
   * @return result from the played rounds.
   */
  String playBoxGamesWithBothChangeYourMindAndNot(String contestantName, int numberOfGames,
      Box ...boxes);

  List<ResultContenstant> getAllResults();
}
