import javax.swing.*;

import java.awt.*;

public class Tree {
  final static int ANGLE_ADJUST = 25;
  public static void mainDraw(Graphics graphics){
    drawFractalTree(graphics, 10, 400, 500, 50, -90);
  }

  private static void drawFractalTree(Graphics graphics, int depth, double startX, double startY, int length, int angle) {
    double x = startX + length * Math.cos(Math.toRadians(angle));
    double y = startY + length * Math.sin(Math.toRadians(angle));
    int red = depth * 10;
    int green = 150 - depth * 15;
    graphics.setColor(new Color(red, green, 0));
    graphics.drawLine((int)startX, (int)startY, (int)x, (int)y);
    if (depth > 1)
    {
      depth -= 1;
      length = length * 95 / 100;
      drawFractalTree(graphics, depth, x, y, length, angle + ANGLE_ADJUST);
      drawFractalTree(graphics, depth, x, y, length, angle);
      drawFractalTree(graphics, depth, x, y, length, angle - ANGLE_ADJUST);
    }
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Tree");
    jFrame.setSize(new Dimension(800, 600));
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
