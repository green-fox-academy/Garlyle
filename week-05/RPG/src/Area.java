import java.awt.*;


public class Area {
  int[][] tileset;
  Tile tileFloor, tileWall;

  final static int TILES = 10;
  final static int[][] LEVEL = {
    {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
    {0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
    {0, 1, 1, 1, 0, 1, 0, 1, 1, 0},
    {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
    {1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
    {0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
    {0, 1, 0, 1, 0, 1, 1, 0, 1, 0},
    {0, 0, 0, 0, 0, 1, 1, 0, 1, 0},
    {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
    {0, 0, 0, 1, 0, 1, 1, 0, 0, 0}
  };

  public Area() {
    tileset = LEVEL;
    tileFloor = new TileFloor();
    tileWall = new TileWall();
  }

  public void draw(Graphics g) {
    for (int i = 0; i < TILES; i++) {
      for (int j = 0; j < TILES; j++) {
        if (tileset[j][i] == 0) {
          tileFloor.draw(g, i * Tile.SIZE, j * Tile.SIZE);
        } else {
          tileWall.draw(g, i * Tile.SIZE, j * Tile.SIZE);
        }
      }
    }
  }

  public boolean getTile(int x, int y) {
    if (x < 0 || x >= TILES || y < 0 || y >= TILES) return false;
    return tileset[y][x] == 0;
  }
}
