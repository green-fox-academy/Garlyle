import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {

  public static void mainDraw(Graphics graphics){
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/triangles/r5.png]
    graphics.setColor(Color.black);

    int size = 10;
    int startX = 50;
    int startY = 300;

    int height = size * 2;
    double vert_distance = height * 3 / 4;
    double horz_distance = height * Math.sqrt(3) / 2;

    for (int i = 0; i < 20; i++)
    {
      drawTriangle(graphics, startX + i * horz_distance, startY, size);
      for (int j = 0; j < 19 - i; j++)
      {
        double x = startX + j * horz_distance + horz_distance * (i + 1) / 2;
        double y = startY - (i + 1) * vert_distance;
        drawTriangle(graphics, x, y, size);
      }
    }
  }

  private static void drawTriangle(Graphics graphics, double x, double y, int size) {
    double x1 = x + size * Math.cos(Math.PI / 180 * 30);
    double y1 = y + size * Math.sin(Math.PI / 180 * 30);
    double x2 = x + size * Math.cos(Math.PI / 180 * 150);
    double y2 = y + size * Math.sin(Math.PI / 180 * 150);
    double x3 = x + size * Math.cos(Math.PI / 180 * 270);
    double y3 = y + size * Math.sin(Math.PI / 180 * 270);

    graphics.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    graphics.drawLine((int)x1, (int)y1, (int)x3, (int)y3);
    graphics.drawLine((int)x2, (int)y2, (int)x3, (int)y3);
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Triangles");
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