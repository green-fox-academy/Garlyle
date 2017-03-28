import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LineInTheMiddle {

  public static void mainDraw(Graphics graphics){
    //  draw a red horizontal line to the canvas' middle.
    //  draw a green vertical line to the canvas' middle.
    graphics.setColor(Color.red);
    graphics.drawLine(0, 300, 600, 300);

    graphics.setColor(Color.green);
    graphics.drawLine(300, 0, 300, 600);
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Line in the middle");
    jFrame.setSize(new Dimension(600, 600));
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