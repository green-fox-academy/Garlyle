import java.awt.*;

public class Character extends GameObject {
  int mapPosX, mapPosY;
  int level;
  int hp, maxHp;
  int dp, sp;

  public Character(String filename) {
    super(filename, 0, 0);
    mapPosX = mapPosY = 0;
    level = 1;
    hp = maxHp = 0;
    dp = sp = 0;
  }

  public void draw(Graphics g)
  {
    setPosition(mapPosX * Tile.SIZE, mapPosY * Tile.SIZE);
    super.draw(g);
  }

  public int getMapCoordX() {
    return mapPosX;
  }

  public int getMapCoordY() {
    return mapPosY;
  }

  public void move(int x, int y) {
    mapPosX += x;
    mapPosY += y;
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
    String s = getClass().getName() + " (LEVEL " + level + ") HP: " + hp + "/" + maxHp +
        " | DP: " + dp + " | SP: " + sp;
    return s;
  }
}
