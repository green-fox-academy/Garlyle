import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameObject {
  BufferedImage image;
  int posX, posY;

  public GameObject(String filename, int posX, int posY) {
    this.posX = posX;
    this.posY = posY;

    try {
      image = ImageIO.read(new File(filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void draw(Graphics g) {
    if (image != null) {
      g.drawImage(image, posX, posY, null);
    }
  }

  public void setPosition(int x, int y) {
    posX = x;
    posY = y;
  }
}
