package main.java.music;

public class ElectricGuitar extends StringedInstrument{
  public ElectricGuitar() {
    this(6);
  }

  public ElectricGuitar(int strings) {
    name = "Electric Guitar";
    numberOfStrings = strings;
    sound = "Twang";
  }
}
