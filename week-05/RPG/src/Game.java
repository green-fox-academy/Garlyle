import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JComponent implements KeyListener {
  Model tileFloor, tileWall;
  public Game() {
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);

    tileFloor = new Model("assets/floor.png", 0, 0);
    tileWall = new Model("assets/wall.png", 0, 0);
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
    tileFloor.draw(graphics);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
