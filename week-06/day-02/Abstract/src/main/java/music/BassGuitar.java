package main.java.music;

public class BassGuitar extends StringedInstrument {
  public BassGuitar() {
    this(4);
  }

  public BassGuitar(int strings) {
    name = "Bass Guitar";
    numberOfStrings = strings;
    sound = "Duum-duum-duum";
  }
}
