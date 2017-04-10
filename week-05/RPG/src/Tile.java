import java.awt.*;

public class Tile extends Model {
  final static int SIZE = 72;

  public Tile(String filename, int posX, int posY) {
    super(filename, posX, posY);
  }

  public void draw(Graphics g, int x, int y) {
    setPosition(x, y);
    draw(g);
  }
}
