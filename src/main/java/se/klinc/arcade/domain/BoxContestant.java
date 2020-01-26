package se.klinc.arcade.domain;

public class BoxContestant extends Contestant {

  private Box selected;

  private boolean changeYourMind;

  public BoxContestant(String name, boolean changeYourMind) {
    super(name);
    this.changeYourMind = changeYourMind;
  }

  public Box getSelected() {
    return selected;
  }

  public void setSelected(Box selected) {
    this.selected = selected;
  }

  public boolean isChangeYourMind() {
    return changeYourMind;
  }

  public void setChangeYourMind(boolean changeYourMind) {
    this.changeYourMind = changeYourMind;
  }

  @Override
  public String toString() {
    return "BoxContestant{"
        + "selected=" + selected
        + ", changeYourMind=" + changeYourMind
        + '}';
  }
}
