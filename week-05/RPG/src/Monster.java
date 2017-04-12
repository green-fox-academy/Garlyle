public class Monster extends Character {

  public Monster(String filename, int level) {
    super(filename);
    this.level = level;
    maxHp = hp = 2 * level * Dice.roll();
    dp = level / 2 * Dice.roll();
    sp = level * Dice.roll();
  }
}
