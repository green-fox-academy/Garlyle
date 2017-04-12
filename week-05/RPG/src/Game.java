import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JComponent implements KeyListener {
  GameLogic game;
  public Game() {
    setPreferredSize(new Dimension(720, 720 + HUD.HEIGHT));
    setVisible(true);

    game = new GameLogic();
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

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    game.render(graphics, this.getHeight());
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {
    game.update(e);
    repaint();
  }
}
