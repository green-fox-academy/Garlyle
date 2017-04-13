import java.awt.*;

public class Area {
  int[][] tileset;
  int width, height;
  Tile tileFloor, tileWall;

  public Area(int width, int height) {
    tileFloor = new TileFloor();
    tileWall = new TileWall();
    this.width = width;
    this.height = height;
    randomize();
  }

  public void draw(Graphics g) {
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if (tileset[i][j] == 0) {
          tileFloor.draw(g, i, j);
        } else {
          tileWall.draw(g, i, j);
        }
      }
    }
  }

  public boolean isPassable(int x, int y) {
    if (x < 0 || x >= width || y < 0 || y >= height) return false;
    return tileset[x][y] == 0;
  }

  public void randomize() {
    tileset = new RandomMapGenerator().generateMap(width, height);
  }
}
