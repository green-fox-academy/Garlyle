import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {

  public static void mainDraw(Graphics graphics){
    // create a square drawing function that takes 2 parameters:
    // the square size, and the fill color,
    // and draws a square of that size and color to the center of the canvas.
    // create a loop that fills the canvas with rainbow colored squares.
    drawCenteredBox(graphics, 150, Color.red);
    drawCenteredBox(graphics, 130, Color.orange);
    drawCenteredBox(graphics, 110, Color.yellow);
    drawCenteredBox(graphics, 90, Color.green);
    drawCenteredBox(graphics, 70, Color.blue);
    drawCenteredBox(graphics, 50, new Color(75, 0, 130));
    drawCenteredBox(graphics, 30, new Color(127,0,255));
  }

  private static void drawCenteredBox(Graphics graphics, int size, Color color) {
    int startAt = 150 - size / 2;
    graphics.setColor(color);
    graphics.fillRect(startAt, startAt, size, size);
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Rainbow Box Function");
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