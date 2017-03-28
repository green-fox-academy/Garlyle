import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LineInTheMiddleBANNED {

  public static void mainDraw(Graphics graphics, Dimension size){
    //  draw a red horizontal line to the canvas' middle.
    //  draw a green vertical line to the canvas' middle.
    graphics.setColor(Color.red);
    graphics.drawLine(0, size.height / 2, size.width, size.height / 2);

    graphics.setColor(Color.green);
    graphics.drawLine(size.width / 2, 0, size.width / 2, size.height);
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Line in the middle unofficial");
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
      mainDraw(graphics, this.getSize());

    }
  }
}