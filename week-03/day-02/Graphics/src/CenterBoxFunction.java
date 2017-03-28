import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenterBoxFunction {

  public static void mainDraw(Graphics graphics){
    // create a square drawing function that takes 1 parameter:
    // the square size
    // and draws a square of that size to the center of the canvas.
    // draw 3 squares with that function.
    graphics.setColor(Color.red);
    drawCenteredBox(graphics, 150);
    graphics.setColor(Color.green);
    drawCenteredBox(graphics, 100);
    graphics.setColor(Color.blue);
    drawCenteredBox(graphics, 50);

  }

  private static void drawCenteredBox(Graphics graphics, int size) {
    int startAt = 150 - size / 2;
    graphics.fillRect(startAt, startAt, size, size);
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Center Box Function");
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