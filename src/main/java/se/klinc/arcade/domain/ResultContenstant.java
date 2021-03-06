package se.klinc.arcade.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "results")
public class ResultContenstant extends Contestant {

  private int numberOfGames;

  private int winningChangedOfBox;

  private int winningNoChangedBox;

  public ResultContenstant(String firstName, int numberOfGames, int winningChangedOfBox,
      int winningNoChangedBox) {
    super(firstName);
    this.numberOfGames = numberOfGames;
    this.winningChangedOfBox = winningChangedOfBox;
    this.winningNoChangedBox = winningNoChangedBox;
  }

  public int getNumberOfGames() {
    return numberOfGames;
  }

  public void setNumberOfGames(int numberOfGames) {
    this.numberOfGames = numberOfGames;
  }

  public int getWinningChangedOfBox() {
    return winningChangedOfBox;
  }

  public void setWinningChangedOfBox(int winningChangedOfBox) {
    this.winningChangedOfBox = winningChangedOfBox;
  }

  public int getWinningNoChangedBox() {
    return winningNoChangedBox;
  }

  public void setWinningNoChangedBox(int winningNoChangedBox) {
    this.winningNoChangedBox = winningNoChangedBox;
  }
}
