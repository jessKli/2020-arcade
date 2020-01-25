package se.klinc.arcade.domain;

public abstract class Contestant {

  private String firstName;

  public Contestant(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return firstName;
  }
}
