import java.util.ArrayList;

public class WarApp {
  public static void main(String[] args) {
    Armada armadaOfTheDamned = new Armada();
    Armada carribeanNavy = new Armada();

    armadaOfTheDamned.fillArmada();
    carribeanNavy.fillArmada();

    System.out.println("The Armada of the Damned has " + armadaOfTheDamned.shipCount() + " ships.");
    System.out.println("The Carribean Navy has " +  carribeanNavy.shipCount() + " ships.");
    System.out.println();

    boolean result = armadaOfTheDamned.war(carribeanNavy);
    if (result)
    {
      System.out.println("The Armada of the Damned won");
    }
    else
    {
      System.out.println("The Carribean Navy has won");
    }
  }
}
