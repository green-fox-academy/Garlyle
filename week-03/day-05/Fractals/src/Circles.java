import javax.swing.*;

import java.awt.*;

public class Circles {
  public static void mainDraw(Graphics graphics){
    drawFractalCircles(graphics, 5, 50, 50, 400);
  }

  private static void drawFractalCircles(Graphics graphics, int depth, double x, double y, int radius) {
    graphics.drawOval((int)x, (int)y, radius, radius);
    if (depth > 1)
    {
      depth -= 1;
      radius /= 2;

      x += radius / 2;

      drawFractalCircles(graphics, depth, x, y, radius);

      double newX = x + radius * Math.sqrt(3) / 2 * Math.sin(Math.toRadians(30));
      double newY = y + radius * Math.sqrt(3) / 2 * Math.cos(Math.toRadians(30));
      drawFractalCircles(graphics, depth, newX, newY, radius);

      newX = x + radius * Math.sqrt(3) / 2 * Math.sin(Math.toRadians(-30));
      newY = y + radius * Math.sqrt(3) / 2 * Math.cos(Math.toRadians(-30));
      drawFractalCircles(graphics, depth, newX, newY, radius);
    }
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Circles");
    jFrame.setSize(new Dimension(500, 500));
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
