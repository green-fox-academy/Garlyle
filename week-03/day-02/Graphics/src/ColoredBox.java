import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {

  public static void mainDraw(Graphics graphics){
    // draw a box that has different colored lines on each edge.
    
    graphics.setColor(Color.red);
    graphics.drawLine(50, 50, 250, 50);
    graphics.setColor(Color.green);
    graphics.drawLine(250, 50, 250, 250);
    graphics.setColor(Color.blue);
    graphics.drawLine(250, 250, 50, 250);
    graphics.setColor(Color.yellow);
    graphics.drawLine(50, 250, 50, 50);

  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Colored Box");
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