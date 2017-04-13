public class Character extends GameObject {
  int level;
  int hp, maxHp;
  int dp, sp;

  public Character(String filename) {
    super(filename, 0, 0);
    level = 1;
    hp = maxHp = 0;
    dp = sp = 0;
  }

  public int getPosX() {
    return posX;
  }

  public int getPosY() {
    return posY;
  }

  public void move(int x, int y) {
    posX += x;
    posY += y;
  }

  public void strike(Character target) {
    int sv = (sp + Dice.roll() * 2);
    if (sv > target.dp) {
      target.hp -= sv - target.dp;
    }
  }

  public boolean isDead() {
    return hp <= 0;
  }

  @Override
  public String toString() {
    String s = (this instanceof Hero)? "Milan Jr." : getClass().getName();
    s = s + " (LEVEL " + level + ") HP: " + hp + "/" + maxHp +
        " | DP: " + dp + " | SP: " + sp;
    return s;
  }
}
