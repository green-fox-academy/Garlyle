import javax.swing.*;

import java.awt.*;

public class SquareGrid {
  public static void mainDraw(Graphics graphics){
    drawFractalSquareGrid(graphics, 4, 300, 300, 200, 20);
  }

  private static void drawFractalSquareGrid(Graphics graphics, int depth, int centerX, int centerY, int size, int thickness) {
    graphics.fillRect(centerX - size / 2, centerY - size / 2, size, thickness);
    graphics.fillRect(centerX - size / 2, centerY - size / 2, thickness, size);
    graphics.fillRect(centerX - size / 2, centerY - thickness + size / 2, size, thickness);
    graphics.fillRect(centerX - thickness + size / 2, centerY - size / 2, thickness, size);

    if (depth > 1)
    {
      depth -= 1;

      drawFractalSquareGrid(graphics, depth, centerX - (size - thickness) / 2, centerY - (size - thickness) / 2, size / 2, thickness / 2);
      drawFractalSquareGrid(graphics, depth, centerX - (size - thickness) / 2, centerY + (size - thickness) / 2, size / 2, thickness / 2);
      drawFractalSquareGrid(graphics, depth, centerX + (size - thickness) / 2, centerY - (size - thickness) / 2, size / 2, thickness / 2);
      drawFractalSquareGrid(graphics, depth, centerX + (size - thickness) / 2, centerY + (size - thickness) / 2, size / 2, thickness / 2);
    }
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Square Grid");
    jFrame.setSize(new Dimension(600, 600));
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
