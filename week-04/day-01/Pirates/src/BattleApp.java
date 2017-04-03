/**
 * Created by Milan Kovacs on 2017. 04. 03..
 */
public class BattleApp {
  public static void main(String[] args) {
    Ship sparrowShip = new Ship();
    Ship guybrushShip = new Ship();

    sparrowShip.fillShip();
    guybrushShip.fillShip();
    sparrowShip.captain.drinkSomeRum((int)(Math.random() * 2) + 3);
    guybrushShip.captain.drinkSomeRum((int)(Math.random() * 5));

    System.out.println("Ship Sparrow: " + sparrowShip);
    System.out.println("Ship Guybrush: " + guybrushShip);
    System.out.println();

    boolean result = sparrowShip.battle(guybrushShip);
    if (result)
    {
      System.out.println("Sparrow won!");
      System.out.println(sparrowShip);
      sparrowShip.captain.howsItGoingMate();
    }
    else
    {
      System.out.println("Guybrush won!");
      System.out.println(guybrushShip);
      guybrushShip.captain.howsItGoingMate();
    }
  }
}
