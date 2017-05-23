package classes;

public class Player {
  private String name;
  private int points;

  public Player(String name) {
    this.name = name;
    points = 0;
  }

  public boolean hasName(String name) {
    return this.name.equals(name);
  }

  public void increasePoints() {
    points++;
  }

  public int getPoints() {
    return points;
  }

  public String getName() {
    return name;
  }

  public boolean isWinnning() {
    return points >= 4;
  }
}
