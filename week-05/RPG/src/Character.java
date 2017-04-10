import java.awt.*;

public class Character extends Model {
  int mapPosX, mapPosY;
  public Character(String filename) {
    super(filename, 0, 0);
    mapPosX = mapPosY = 0;
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
}
