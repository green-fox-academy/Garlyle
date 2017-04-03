public class Pirate {
  int intoxication = 0;
  boolean isAlive = true;

  public void drinkSomeRum()
  {
    intoxication++;
  }

  public void howsItGoingMate()
  {
    if (intoxication <= 4)
      System.out.println("Pour me anudder!");
    else
    {
      System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
      intoxication = 0;
    }
  }
}
