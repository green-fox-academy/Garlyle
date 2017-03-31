import javax.swing.*;

import java.awt.*;

public class SierpinskyCarpet {
  public static void mainDraw(Graphics graphics){
    drawFractalCarpet(graphics, 5, 300, 300, 200);
  }

  private static void drawFractalCarpet(Graphics graphics, int depth, int centerX, int centerY, int size) {
    graphics.fillRect(centerX - size / 2, centerY - size / 2, size, size);
    if (depth > 1)
    {
      depth -= 1;

      for (int i = -1; i <= 1; i++)
        for (int j = -1; j <= 1; j++)
          if (i != 0 || j != 0)
          {
            drawFractalCarpet(graphics, depth,
                centerX + i * size,
                centerY + j * size,
                size / 3);
          }
    }
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Sierpinsky Carpet");
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
