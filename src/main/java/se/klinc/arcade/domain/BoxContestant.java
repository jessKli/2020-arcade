package se.klinc.arcade.domain;

public class BoxContestant extends Contestant {

  private Box selected;

  private boolean changeBox = false;

  public BoxContestant(String name) {
    super(name);
  }

  public Box getSelected() {
    return selected;
  }

  public void setSelected(Box selected) {
    this.selected = selected;
  }

  public boolean isChangeBox() {
    return changeBox;
  }

  public void setChangeBox(boolean changeBox) {
    this.changeBox = changeBox;
  }

  @Override
  public String toString() {
    return "Contestant{"
        + "selected=" + selected
        + ", changeBox=" + changeBox
        + '}';
  }
}
