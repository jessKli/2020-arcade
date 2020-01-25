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
    // Create three boxes and select which one has the money
    Box[] boxes = new Box[3];
    for(int i = 0; i<3; i++) {
      boxes[i] = (new Box(i));
    }
    return boxes;
  }

  @Override
  public String startBoxGames(String contestantName, int numberOfGames, Box... boxes) {
    int winningNoChangeOfBox = 0;
    int winningChangeOfBox = 0;

    BoxContestant contestant = new BoxContestant(contestantName);

    for(int i = 0;i<numberOfGames;i++){

      if(play(contestant, boxes)){
        winningNoChangeOfBox++;
      }
      resetBoxes(boxes);
    }
    contestant.setChangeBox(true);
    for(int i = 0;i<numberOfGames;i++){

      if(play(contestant, boxes)){
        winningChangeOfBox++;
      }
      resetBoxes(boxes);
    }
    String result = " When {0} playing {1} times if you change box you won {2} times." +
        " When playing another {1} times and you didn''t change box you won {3} times";

    return MessageFormat.format(result,  contestantName,numberOfGames, winningChangeOfBox,
        numberOfGames, winningNoChangeOfBox);
  }

  private void resetBoxes(Box... boxes) {
    for(Box box : boxes) {
      box.setMoney(false);
      box.setTurned(false);
    }
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
    return (contestant.isChangeBox() && !contestant.getSelected().isMoney())
        || (!contestant.isChangeBox() && contestant.getSelected().isMoney());
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
}
