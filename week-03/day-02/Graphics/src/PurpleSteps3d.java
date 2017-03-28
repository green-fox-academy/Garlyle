import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps3d {

  public static void mainDraw(Graphics graphics){
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/purple-steps-3d/r4.png]
    int pos = 10;
    for (int i = 1; i <= 6; i++)
    {
      drawFancyRectangle(graphics, pos, pos, i * 10);
      pos += i * 10;
    }


  }

  private static void drawFancyRectangle(Graphics graphics, int x, int y, int size) {
    graphics.setColor(new Color(177, 70, 244));
    graphics.fillRect(x, y, size, size);
    graphics.setColor(Color.black);
    graphics.drawRect(x, y, size, size);
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Purple Steps in 3D");
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