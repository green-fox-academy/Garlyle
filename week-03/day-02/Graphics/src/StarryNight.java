import javax.swing.*;

import java.awt.*;

public class StarryNight {

  public static void mainDraw(Graphics graphics, Dimension size){
    // draw the night sky:
    // - The background should be black
    // - The stars can be small squares
    // - The stars should have random positions on the canvas
    // - The stars should have random color (some shade of grey)
    graphics.setColor(Color.black);
    graphics.fillRect(0, 0, size.width, size.height);

    for (int i = 1; i <= size.width; i++)
    {
      int col = (int)(Math.random() * 255);
      int x = (int)(Math.random() * size.width - 20) + 10;
      int y = (int)(Math.random() * size.height - 20) + 10;
      int radius = (int)(Math.random() * 4) + 1;

      graphics.setColor(new Color(col, col, col));
      graphics.fillRect(x, y, radius, radius);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Starry Night");
    jFrame.setSize(new Dimension(300, 300));
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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