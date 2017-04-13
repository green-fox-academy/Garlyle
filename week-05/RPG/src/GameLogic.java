import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameLogic {
  final static int TILE_WIDTH = 10;
  final static int TILE_HEIGHT = 10;

  Area tilemap;
  Hero hero;
  ArrayList<Monster> enemies;
  Monster currentEnemy;
  int currentLevel;
  boolean monstersMove;

  public GameLogic() {
    tilemap = new Area(TILE_WIDTH, TILE_HEIGHT);
    hero = new Hero();
    enemies = new ArrayList<>();
    currentEnemy = null;
    currentLevel = 1;
    monstersMove = true;

    createEnemies(3, currentLevel);
  }

  public void render(Graphics graphics, int height) {
    tilemap.draw(graphics);
    if (!hero.isDead()) {
      hero.draw(graphics);
    }
    for (Monster m : enemies) {
      m.draw(graphics);
    }

    if (!hero.isDead()) {
      HUD.draw(graphics, 0, height, hero, currentEnemy);
    } else {
      HUD.gameOver(graphics, 0, height);
    }
  }

  public void update(KeyEvent e) {
    if (hero.isDead()) {
      return;
    }
    int x = hero.getPosX();
    int y = hero.getPosY();
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
    monstersMove = !monstersMove;
    if (monstersMove) {
      moveEnemies();
    }
    checkForEnemies();
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
      x = (int)(Math.random() * TILE_WIDTH);
      y = (int)(Math.random() * TILE_HEIGHT);
    } while (!isPosValid(x, y));
    enemy.move(x, y);
    enemies.add(enemy);
  }

  private void checkForEnemies() {
    for (Monster enemy : enemies) {
      if (enemy.getPosX() == hero.getPosX() && enemy.getPosY() == hero.getPosY()) {
        currentEnemy = enemy;
        return;
      }
    }
    currentEnemy = null;
  }

  private void moveEnemies() {
    for (Monster enemy : enemies) {
      int x, y;
      int count = 0;
      if (enemy.getPosX() != hero.getPosX() || enemy.getPosY() != hero.getPosY()) {
        do {
          x = enemy.getPosX();
          y = enemy.getPosY();
          int dir = (int)(Math.random() * 4);
          if (dir == 0) {
            x += 1;
          } else if (dir == 1) {
            x -= 1;
          } else if (dir == 2) {
            y += 1;
          } else if (dir == 3) {
            y -= 1;
          }
          if (++count > 5) {
            break;
          }
        } while (!isPosValid(x, y));
        if (count <= 5) {
          enemy.setPosition(x, y);
        }
      }
    }
  }

  private boolean isPosValid(int x, int y) {
    if (!tilemap.isPassable(x, y)) {
      // Tile is Wall
      return false;
    } else if (hero.getPosX() == x && hero.getPosY() == y) {
      // Hero is there
      return false;
    } else if (!enemies.isEmpty()) {
      // Check if enemy is there
      for(Character c : enemies) {
        if (c.getPosX() == x && c.getPosY() == y) {
          return false;
        }
      }
    }
    return true;
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
    tilemap.randomize();
    hero.recoverRandomHealth();
    hero.setPosition(0, 0);
    hero.turnHero(Hero.DOWN);
    createEnemies((int)(Math.random() * 3 + 3), ++currentLevel);
  }
}
