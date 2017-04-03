public class Pirate {
  final String THIRSTY_LINE = "Pour me anudder!";
  final String TOXIC_LINE = "Arghh, I'ma Pirate. How d'ya d'ink its goin?";

  int intoxication = 0;
  boolean isAlive = true;
  Parrot pet = new Parrot();

  public void drinkSomeRum(int rums)
  {
    intoxication += rums;
  }

  public void passOut()
  {
    intoxication = 0;
  }

  public void howsItGoingMate()
  {
    if (!isAlive)
      System.out.println("he's dead");
    else if (intoxication <= 4)
    {
      System.out.println("Pirate: " + THIRSTY_LINE);
      pet.repeat(THIRSTY_LINE);
    }
    else
    {
      System.out.println("Pirate: " + TOXIC_LINE);
      pet.repeat(TOXIC_LINE);
      passOut();
    }
  }

  public void die()
  {
    isAlive = false;
  }

  public void brawl(Pirate enemy)
  {
    int fightResult = (int)(Math.random() * 3);
    if (fightResult == 0)
    {
      this.die();
    }
    else if (fightResult == 1)
    {
      enemy.die();
    }
    else
    {
      this.passOut();
      enemy.passOut();
    }
  }
}
