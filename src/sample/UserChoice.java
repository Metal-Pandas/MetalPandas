package sample;

public enum UserChoice {
  Driver("DR"),
  Passenger("PA");

  public final String code;

  UserChoice(String code) {
    this.code = code;
  }
}
