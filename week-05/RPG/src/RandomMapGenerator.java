import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

// reference: http://pcg.wikidot.com/pcg-algorithm:maze

public class RandomMapGenerator {
  final int FLOOR = 0;
  final int WALL = 1;
  final int EXPOSED = 2;
  final int UNEXPOSED = 3;

  private int[][] randomMap;
  ArrayList<Dimension> frontier;
  int width, height;

  public int[][] generateMap(int width, int height) {
    frontier = new ArrayList<>();

    this.width = width;
    this.height = height;
    randomMap = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        randomMap[i][j] = UNEXPOSED;
      }
    }

    addFloor(0, 0);
    while (!frontier.isEmpty()) {
      int pos = (int)(Math.random() * frontier.size());
      int x = frontier.get(pos).width;
      int y = frontier.get(pos).height;
      if (check(x, y)) {
        addFloor(x, y);
      } else {
        addWall(x, y);
      }
      frontier.remove(pos);
    }
    return randomMap;
  }

  private void addFloor(int x, int y) {
    randomMap[x][y] = FLOOR;
    ArrayList<Dimension> extra = new ArrayList<>();

    if (x > 0) {
      if (randomMap[x - 1][y] == UNEXPOSED) {
        randomMap[x - 1][y] = EXPOSED;
        extra.add(new Dimension(x - 1, y));
      }
    }
    if (x < (width - 1)) {
      if (randomMap[x + 1][y] == UNEXPOSED) {
        randomMap[x + 1][y] = EXPOSED;
        extra.add(new Dimension(x + 1, y));
      }
    }
    if (y > 0) {
      if (randomMap[x][y - 1] == UNEXPOSED) {
        randomMap[x][y - 1] = EXPOSED;
        extra.add(new Dimension(x, y - 1));
      }
    }
    if (y < (height - 1)) {
      if (randomMap[x][y + 1] == UNEXPOSED) {
        randomMap[x][y + 1] = EXPOSED;
        extra.add(new Dimension(x, y + 1));
      }
    }
    Collections.shuffle(extra);
    frontier.addAll(extra);
  }

  private void addWall(int x, int y) {
    randomMap[x][y] = WALL;
  }

  private boolean check(int x, int y) {
    int edgeState = 0;
    if (x > 0) {
      if (randomMap[x - 1][y] == FLOOR) {
        edgeState++;
      }
    }
    if (x < (width - 1)) {
      if (randomMap[x + 1][y] == FLOOR) {
        edgeState++;
      }
    }
    if (y > 0) {
      if (randomMap[x][y - 1] == FLOOR) {
        edgeState++;
      }
    }
    if (y < (height - 1)) {
      if (randomMap[x][y + 1] == FLOOR) {
        edgeState++;
      }
    }
    return (edgeState == 1);
  }
}
