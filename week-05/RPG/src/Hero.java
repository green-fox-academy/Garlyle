import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Hero extends Character {
  final static int LEFT = 0;
  final static int RIGHT = 1;
  final static int UP = 2;
  final static int DOWN = 3;

  public Hero() {
    super("assets/hero-down.png");
    maxHp = hp = 20 + 3 * Dice.roll();
    dp = 2 * Dice.roll();
    sp = 5 + Dice.roll();
  }

  public void turnHero(int direction) {
    try {
      if (direction == LEFT) {
        image = ImageIO.read(new File("assets/hero-left.png"));
      } else if (direction == RIGHT) {
        image = ImageIO.read(new File("assets/hero-right.png"));
      } else if (direction == UP) {
        image = ImageIO.read(new File("assets/hero-up.png"));
      } else if (direction == DOWN) {
        image = ImageIO.read(new File("assets/hero-down.png"));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void levelUp() {
    maxHp += Dice.roll();
    dp += Dice.roll();
    sp += Dice.roll();
    level++;
  }

  public void recoverRandomHealth() {
    int regenRoll = (int)(Math.random() * 10);
    if (regenRoll == 1) {
      recoverHealth(100);
    } else if (regenRoll <= 5) {
      recoverHealth(30);
    } else {
      recoverHealth(10);
    }
  }

  private void recoverHealth(int percent) {
    hp += maxHp * percent / 100;
    if (hp > maxHp) hp = maxHp;
  }
}
