import javax.swing.*;

import java.awt.*;

public class Hexagon {
  public static void mainDraw(Graphics graphics){
    drawFractalHexagon(graphics, 5, 300, 300, 300);
  }

  private static void drawFractalHexagon(Graphics graphics, int depth, double x, double y, int size) {
    Polygon corners = new Polygon();
    for (int i = 0; i < 6; i++)
    {
      double newX = x + size * Math.cos(Math.toRadians(i * 60));
      double newY = y + size * Math.sin(Math.toRadians(i * 60));
      corners.addPoint((int)newX, (int)newY);
    }
    graphics.drawPolygon(corners);

    if (depth > 1)
    {
      depth -= 1;
      size /= 3;
      for (int i = 0; i < 6; i++)
      {
        double newX = (x - corners.xpoints[i]) * 2 / 3 + x;
        double newY = (y - corners.ypoints[i]) * 2 / 3 + y;
        drawFractalHexagon(graphics, depth, newX, newY, size);
      }
    }
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Hexagon");
    jFrame.setSize(new Dimension(650, 650));
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
