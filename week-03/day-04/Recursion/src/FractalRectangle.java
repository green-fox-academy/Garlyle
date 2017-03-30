import javax.swing.*;

import java.awt.*;

public class FractalRectangle {
  public static void mainDraw(Graphics graphics, Dimension size){
    graphics.setColor(Color.yellow);
    graphics.fillRect(0, 0, size.width, size.height);
    graphics.setColor(Color.black);
    drawFractalRectangle(graphics, 4, 0, 0, size.width, size.height);
  }

  private static void drawFractalRectangle(Graphics graphics, int depth, int x, int y, int width, int height)
  {
    graphics.drawRect(x, y, width, height);
    if (depth > 0)
    {
      depth -= 1;
      width /= 3;
      height /= 3;

      drawFractalRectangle(graphics, depth, x + width, y, width, height);
      drawFractalRectangle(graphics, depth, x, y + height, width, height);
      drawFractalRectangle(graphics, depth, x + 2 * width, y + height, width, height);
      drawFractalRectangle(graphics, depth, x + width, y + 2 * height, width, height);
    }
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Fractal Rectangle");
    jFrame.setSize(new Dimension(300, 300));
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }
  static class ImagePanel extends JPanel{
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics, this.getSize());

    }
  }
}
