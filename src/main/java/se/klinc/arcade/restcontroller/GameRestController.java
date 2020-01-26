package se.klinc.arcade.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.klinc.arcade.service.BoxGame;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/arcade")
public class GameRestController {

  @Autowired
  private BoxGame boxGame;

  /**
   * Starts the game "Play boxes" which plays the games with both change your mind and not.
   * @param times number of times the game will be played.
   * @param name name of the boxContestant.
   * @return result.
   */
  @GetMapping(value = "/playBoxesBothWays/{times}/{contestantName}")
  public String playBoxesBothWays(
      @PathVariable(value = "times") @NotNull String times,
      @PathVariable(value = "contestantName") @NotNull String name) {

    int numberOfTimes;
    try {
      numberOfTimes = Integer.parseInt(times);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("You must set an integer to play");
    }
    if (numberOfTimes <= 0) {
      return "To play this game you must have a number larger than 0";
    }

    String result = boxGame.playBoxGamesWithBothChangeYourMindAndNot(name, numberOfTimes,
        boxGame.createBoxes());
    return result;
  }
}
