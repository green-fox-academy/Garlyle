public class Monster extends Character {

  public Monster(String filename, int level) {
    super(filename);
    this.level = level;
    maxHp = hp = 2 * level * Dice.roll();
    dp = level * Dice.roll() / 2;
    sp = level * Dice.roll();
  }
}
