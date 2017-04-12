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

  @Override
  public String toString() {
    String s = getClass().getName() + " (LEVEL " + level + ") HP: " + hp + "/" + maxHp +
        " | DP: " + dp + " | SP: " + sp;
    return s;
  }
}
