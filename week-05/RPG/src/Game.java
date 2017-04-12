import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends JComponent implements KeyListener {
  Area tilemap;
  Hero hero;
  ArrayList<Monster> enemies;
  Monster currentEnemy;
  int currentLevel;

  public Game() {
    setPreferredSize(new Dimension(720, 720 + HUD.HEIGHT));
    setVisible(true);

    tilemap = new Area();
    hero = new Hero();
    enemies = new ArrayList<>();
    currentEnemy = null;
    currentLevel = 1;

    createEnemies(3, currentLevel);
    System.out.println(hero);
    for (Monster enemy : enemies) {
      System.out.println(enemy);
    }
  }

  public static void main(String[] args) {
    createFrame();
  }

  private static void createFrame() {
    JFrame frame = new JFrame("RPG Game");
    Game game = new Game();
    frame.add(game);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
    frame.addKeyListener(game);
  }

  private void createEnemies(int num, int level) {
    enemies.clear();
    addEnemy(new Boss(level + (int)(Math.random() * 3)));
    for (int i = 0; i < num; i++) {
      addEnemy(new Skeleton(level + (int)(Math.random() * 3)));
    }
  }

  private void addEnemy(Monster enemy) {
    int x, y;
    do {
      x = (int)(Math.random() * Area.TILES);
      y = (int)(Math.random() * Area.TILES);
    } while (!isPosValid(x, y));
    enemy.move(x, y);
    enemies.add(enemy);
  }

  private void checkForEnemies() {
    for (Monster enemy : enemies) {
      if (enemy.getMapCoordX() == hero.getMapCoordX() && enemy.getMapCoordY() == hero.getMapCoordY()) {
        currentEnemy = enemy;
        return;
      }
    }
    currentEnemy = null;
  }

  private boolean isPosValid(int x, int y) {
    if (!tilemap.isPassable(x, y)) {
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

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);

    tilemap.draw(graphics);
    if (!hero.isDead()) {
      hero.draw(graphics);
    }
    for (Monster m : enemies) {
      m.draw(graphics);
    }

    if (!hero.isDead()) {
      HUD.draw(graphics, 0, this.getHeight(), hero, currentEnemy);
    } else {
      HUD.gameOver(graphics, 0, this.getHeight());
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
    if (hero.isDead()) {
      return;
    }
    int x = hero.getMapCoordX();
    int y = hero.getMapCoordY();
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      hero.turnHero(Hero.UP);
      if (tilemap.isPassable(x, y - 1)) hero.move(0, -1);
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      hero.turnHero(Hero.DOWN);
      if (tilemap.isPassable(x, y + 1)) hero.move(0, 1);
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      hero.turnHero(Hero.LEFT);
      if (tilemap.isPassable(x - 1, y)) hero.move(-1, 0);
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      hero.turnHero(Hero.RIGHT);
      if (tilemap.isPassable(x + 1, y)) hero.move(1, 0);
    } else if (e.getKeyCode() == KeyEvent.VK_SPACE && currentEnemy != null) {
      battle();
    }
    checkForEnemies();
    repaint();
  }

  private void battle() {
    hero.strike(currentEnemy);
    if (!currentEnemy.isDead()) {
      currentEnemy.strike(hero);
    } else {
      hero.levelUp();
      enemies.remove(currentEnemy);
      if (currentEnemy instanceof Boss) {
        moveToNextLevel();
      }
      currentEnemy = null;
    }
  }

  private void moveToNextLevel() {
    hero.recoverRandomHealth();
    hero.move(-hero.getMapCoordX(), -hero.getMapCoordY());
    hero.turnHero(Hero.DOWN);
    createEnemies((int)(Math.random() * 3 + 3), ++currentLevel);
  }
}
