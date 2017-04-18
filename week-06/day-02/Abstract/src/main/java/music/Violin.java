package main.java.music;

public class Violin extends StringedInstrument{
  public Violin() {
    this(4);
  }

  public Violin(int strings) {
    name = "Violin";
    numberOfStrings = strings;
    sound = "Screech";
  }
}
