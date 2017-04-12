import java.awt.*;

public class HUD {
  final static int HEIGHT = 80;
  final static int FONT_SIZE = 25;

  public static void draw(Graphics g, int x, int y, Character hero, Character enemy) {
    fillBackGround(g, x, y);
    g.setColor(Color.white);
    g.setFont(g.getFont().deriveFont((float)FONT_SIZE));
    if (hero != null) {
      g.drawString(hero.toString(), 10, y - (HEIGHT - FONT_SIZE));
    }
    if (enemy != null) {
      g.drawString(enemy.toString(), 10, y - FONT_SIZE);
    }
  }

  public static void gameOver(Graphics g, int x, int y) {
    fillBackGround(g, x, y);
    g.setColor(Color.white);
    g.setFont(g.getFont().deriveFont((float)FONT_SIZE));
    g.drawString("Game Over", 300, y - HEIGHT / 2);
  }

  private static void fillBackGround(Graphics g, int x, int y) {
    g.setColor(Color.black);
    g.fillRect(x, y - HEIGHT, 720, HEIGHT);
  }
}
