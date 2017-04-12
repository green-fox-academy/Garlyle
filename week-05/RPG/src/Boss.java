public class Boss extends Monster {
  public Boss(int level) {
    super("assets/boss.png", level);
    maxHp = hp += Dice.roll();
    dp += Dice.roll() / 2;
    sp += level;
  }
}
