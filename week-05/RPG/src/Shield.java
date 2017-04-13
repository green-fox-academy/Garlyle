/**
 * Created by Milan Kovacs on 2017. 04. 13..
 */
public class Shield extends GameObject {
  public Shield(int posX, int posY) {
    super("assets/shield.png", posX, posY);
  }

  public void upgrade(Hero hero) {
    hero.dp += Dice.roll();
  }
}
