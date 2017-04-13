public class Sword extends GameObject {
  public Sword(int posX, int posY) {
    super("assets/sword.png", posX, posY);
  }

  public void upgrade(Hero hero) {
    hero.sp += Dice.roll();
  }
}
