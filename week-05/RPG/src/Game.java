import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JComponent implements KeyListener {
  Area tilemap;
  Hero hero;
  public Game() {
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);

    tilemap = new Area();
    hero = new Hero();
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
