import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {
  final static int RADIUS = 3;

  public static void mainDraw(Graphics graphics){
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/super-hexagon/r6.gif]

    // reference found:
    // [http://www.redblobgames.com/grids/hexagons/]
    int hexagonSize = 20;
    int centerX = 150;
    int centerY = 150;

    int width = hexagonSize * 2;
    double horzDistance = width * 3 / 4;
    double vertDistance = width * Math.sqrt(3) / 2;

    graphics.setColor(Color.black);
    for (double i = -RADIUS; i <= RADIUS; i++)
      for (double j = -RADIUS; j <= RADIUS; j++)
        {
          if (i + j > RADIUS || i + j < -RADIUS) continue;
          double x = centerX + i * horzDistance;
          double y = centerY + (j + i / 2) * vertDistance;
          drawHexagon(graphics, x, y, hexagonSize);
        }
  }

  private static void drawHexagon(Graphics graphics, double x, double y, int size) {
    double [][] corners = new double[6][2];
    for (int i = 0; i < 6; i++)
    {
      corners[i][0] = x + size * Math.cos(Math.PI / 180 * i * 60);
      corners[i][1] = y + size * Math.sin(Math.PI / 180 * i * 60);
    }
    for (int i = 0; i < 5; i++)
    {
      graphics.drawLine((int)corners[i][0], (int)corners[i][1], (int)corners[i+1][0], (int)corners[i+1][1]);
    }
    graphics.drawLine((int)corners[0][0], (int)corners[0][1], (int)corners[5][0], (int)corners[5][1]);
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Super Hexagon");
    jFrame.setSize(new Dimension(300, 300));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }
  static class ImagePanel extends JPanel{
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);

    }
  }

}