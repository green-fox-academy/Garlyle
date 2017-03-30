import javax.swing.*;

import java.awt.*;

public class FractalHexagon {
  public static void mainDraw(Graphics graphics){
    int size = 200;
    drawFractalHexagon(graphics, 5, size, size, size);
  }

  private static void drawFractalHexagon(Graphics graphics, int depth, double x, double y, int size) {
    drawHexagon(graphics, x, y, size);
    if (depth > 1)
    {
      depth -= 1;
      size /= 2;
      double nextWidth = size * 2;
      double nextHeight = Math.sqrt(3) / 2 * nextWidth;

      drawFractalHexagon(graphics, depth, x - nextWidth / 4, y - nextHeight / 2, size);
      drawFractalHexagon(graphics, depth, x - nextWidth / 4, y + nextHeight / 2, size);
      drawFractalHexagon(graphics, depth, x + nextWidth / 2, y, size);
    }
  }

  private static void drawHexagon(Graphics graphics, double x, double y, int size) {
    double [][] corners = new double[6][2];
    for (int i = 0; i < 6; i++)
    {
      corners[i][0] = x + size * Math.cos(Math.toRadians(i * 60));
      corners[i][1] = y + size * Math.sin(Math.toRadians(i * 60));
    }
    for (int i = 0; i < 5; i++)
    {
      graphics.drawLine((int)corners[i][0], (int)corners[i][1], (int)corners[i+1][0], (int)corners[i+1][1]);
    }
    graphics.drawLine((int)corners[0][0], (int)corners[0][1], (int)corners[5][0], (int)corners[5][1]);
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Fractal Hexagon");
    jFrame.setSize(new Dimension(400, 400));
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
