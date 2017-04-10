import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JComponent implements KeyListener {
  Tile tileFloor, tileWall;
  public Game() {
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);

    tileFloor = new TileFloor();
    tileWall = new TileWall();
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
    tileFloor.draw(graphics, 0, 0);
    tileWall.draw(graphics, Tile.SIZE, Tile.SIZE);
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