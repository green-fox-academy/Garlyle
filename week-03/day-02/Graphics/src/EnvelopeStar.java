import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {

  public static void mainDraw(Graphics graphics){
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/envelope-star/r2.png]
    graphics.setColor(Color.green);
    for (int i = 1; i < 15; i++)
    {
      graphics.drawLine(i * 10, 150, 150, 150 - i * 10);
      graphics.drawLine(150, i * 10, 150 + i * 10, 150);
      graphics.drawLine(i * 10, 150, 150, 150 + i * 10);
      graphics.drawLine(150, 300 - i * 10, 150 + i * 10, 150);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Envelope Star");
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