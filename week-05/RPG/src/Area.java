import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;

public class Area {
  int[][] tileset;
  Tile tileFloor, tileWall;

  final static int TILES = 10;

  public Area() {
    tileset = new int[TILES][TILES];
    tileFloor = new TileFloor();
    tileWall = new TileWall();
  }

  public void draw(Graphics g) {
    for (int i = 0; i < TILES; i++) {
      for (int j = 0; j < TILES; j++) {
        if (tileset[i][j] == 0) {
          tileFloor.draw(g, i * Tile.SIZE, j * Tile.SIZE);
        } else {
          tileWall.draw(g, i * Tile.SIZE, j * Tile.SIZE);
        }
      }
    }

  }
}
