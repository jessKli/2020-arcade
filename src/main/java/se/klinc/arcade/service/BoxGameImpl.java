package se.klinc.arcade.service;

import org.springframework.stereotype.Component;
import se.klinc.arcade.domain.Box;
import se.klinc.arcade.domain.BoxContestant;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BoxGameImpl implements BoxGame {

  @Override
  public Box[] createBoxes() {
    // Create three boxes
    Box[] boxes = new Box[3];
    for(int i = 0; i<3; i++) {
      boxes[i] = (new Box(i));
    }
    return boxes;
  }

  @Override
  public String playBoxGamesWithBothChangeYourMindAndNot(String contestantName,
      int numberOfGames, Box ... boxes) {
    // Create the contestant, and he will not change his mind about change box
    BoxContestant boxContestant = new BoxContestant(contestantName, false);

    int winningNoChangeOfBox = playGameOverAndOverAgain(boxContestant, numberOfGames, boxes);

    // Now the contestant will change the box
    boxContestant.setChangeYourMind(true);
    int winningChangeOfBox = playGameOverAndOverAgain(boxContestant, numberOfGames, boxes);

    String result = " When {0} played {1} times and changed box {0} won {2} times."
        + " When played another {1} times and didn''t change box {0} won {3} times";
    return MessageFormat.format(result, contestantName, numberOfGames, winningChangeOfBox,
        winningNoChangeOfBox);
  }

  private int playGameOverAndOverAgain(BoxContestant boxContestant, int numberOfGames, Box ... boxes) {
    int result = 0;
    for (int i = 0; i < numberOfGames; i++) {

      if (play(boxContestant, boxes)) {
        result++;
      }
      resetBoxes(boxes);
    }
    return result;
  }

  private boolean play(BoxContestant contestant, Box... boxes) {
    setBoxHasMoney(boxes);

    // Choose which box he thinks the money are in
    contestant.setSelected(boxes[selectBox(boxes)]);

    // Turn one box that isn't selected by contestant and not has money
    turnBox(contestant.getSelected(), boxes);

    return isAWinner(contestant);
  }

  private boolean isAWinner(BoxContestant contestant) {
    return (contestant.isChangeYourMind() && !contestant.getSelected().isMoney())
        || (!contestant.isChangeYourMind() && contestant.getSelected().isMoney());
  }

  private void turnBox(Box selectedByContestant, Box... boxes) {
    List<Box> possibleToTurn = new ArrayList<>();
    for(Box box : boxes) {
      if(!box.equals(selectedByContestant) && !box.isMoney()) {
        possibleToTurn.add(box);
      }
    }
    int i = selectBox(possibleToTurn.toArray(new Box[possibleToTurn.size()]));
    possibleToTurn.get(i).setTurned(true);
  }

  private void setBoxHasMoney(Box... boxes) {
    int boxHasMoney = selectBox(boxes);
    boxes[boxHasMoney].setMoney(true);
  }

  public static int selectBox(Box... boxes) {
    return new Random().nextInt(boxes.length);
  }

  private void resetBoxes(Box... boxes) {
    for(Box box : boxes) {
      box.setMoney(false);
      box.setTurned(false);
    }
  }
}
