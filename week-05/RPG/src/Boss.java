public class Boss extends Monster {
  public Boss(int level) {
    super("assets/boss.png", level);
    maxHp = hp += Dice.roll() * level;
    dp += Dice.roll();
    sp += level * level;
  }
}
