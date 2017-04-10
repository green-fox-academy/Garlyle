import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends JComponent implements KeyListener {
  Area tilemap;
  Hero hero;
  ArrayList<Monster> enemies;

  public Game() {
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);

    tilemap = new Area();
    hero = new Hero();
    enemies = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      int x, y;
      do {
        x = (int)(Math.random() * Area.TILES);
        y = (int)(Math.random() * Area.TILES);
      } while (!isPosValid(x, y));
      if (i == 0) {
        enemies.add(new Boss(x, y));
      } else {
        enemies.add(new Skeleton(x, y));
      }
    }
  }

  private boolean isPosValid(int x, int y) {
    if (!tilemap.getTile(x, y)) {
      // Tile is Wall
      return false;
    } else if (hero.getMapCoordX() == x || hero.getMapCoordY() == y) {
      // Hero is there
      return false;
    } else if (!enemies.isEmpty()) {
      // Check if enemy is there
      for(Character c : enemies) {
        if (c.getMapCoordX() == x && c.getMapCoordY() == y) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("RPG Game");
    Game game = new Game();
    frame.add(game);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
    frame.addKeyListener(game);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);

    tilemap.draw(graphics);
    hero.draw(graphics);
    for (Monster m : enemies) {
      m.draw(graphics);
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {
    int coordX = hero.getMapCoordX();
    int coordY = hero.getMapCoordY();
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      hero.turnHero(Hero.UP);
      if (tilemap.getTile(coordX, coordY - 1)) hero.move(0, -1);
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      hero.turnHero(Hero.DOWN);
      if (tilemap.getTile(coordX, coordY + 1)) hero.move(0, 1);
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      hero.turnHero(Hero.LEFT);
      if (tilemap.getTile(coordX - 1, coordY)) hero.move(-1, 0);
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      hero.turnHero(Hero.RIGHT);
      if (tilemap.getTile(coordX + 1, coordY)) hero.move(1, 0);
    }
    repaint();
  }
}
