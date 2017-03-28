import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {

  public static void mainDraw(Graphics graphics){
    // divide the canvas into 4 parts
    // and repeat this pattern in each quarter:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/line-play/r1.png]
    drawLinePlay(graphics, 0, 0, 150, 10);
    drawLinePlay(graphics, 150, 0, 150, 10);
    drawLinePlay(graphics, 0, 150, 150, 10);
    drawLinePlay(graphics, 150, 150, 150, 10);

  }

  private static void drawLinePlay(Graphics graphics, int x, int y, int size, int step) {
    int i = 0;
    while (size > i)
    {
      graphics.setColor(Color.green);
      graphics.drawLine(x, y + i, x + i, y + size);
      graphics.setColor(new Color(128, 0, 128));
      graphics.drawLine(x + i, y, x + size, y + i);
      i += step;
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Line Play Quarters");
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