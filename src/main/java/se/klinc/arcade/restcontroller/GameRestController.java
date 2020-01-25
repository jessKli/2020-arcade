package se.klinc.arcade.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.klinc.arcade.domain.Box;
import se.klinc.arcade.service.BoxGame;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/arcade")
public class GameRestController {

  @Autowired
  private BoxGame boxGame;

  @GetMapping(value = "/playBoxes/{times}/{contestantName}")
  public String playBoxes(
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
    Box[] boxes = boxGame.createBoxes();

    String result = boxGame.startBoxGames(name, numberOfTimes, boxes);
    return result;
  }
}
