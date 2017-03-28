import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {

  public static void mainDraw(Graphics graphics){
    // fill the canvas with a checkerboard pattern.
    for (int i = 0; i < 10; i++)
      for (int j = 0; j < 10; j++)
      {
        if ((i + j) % 2 == 0)
          graphics.setColor(Color.white);
        else
          graphics.setColor(Color.black);
        graphics.fillRect(i * 30, j * 30, 30, 30);
      }


  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Checkerboard");
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