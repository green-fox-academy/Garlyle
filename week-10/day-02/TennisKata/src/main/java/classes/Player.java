package classes;

public class Player {
  String name;
  int points;

  public Player(String name) {
    this.name = name;
    points = 0;
  }

  public boolean hasName(String name) {
    return this.name.equals(name);
  }

  public void increaseScore(int score) {
    this.points += score;
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
