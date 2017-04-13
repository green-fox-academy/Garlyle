public class Ghost extends Monster{
  public Ghost(int level) {
    super("assets/ghost.png", level);
    dp += level * Dice.roll() / 2;
  }

  public void strike(Character target) {
    target.hp -= sp;
  }
}
