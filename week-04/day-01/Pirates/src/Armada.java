import java.util.ArrayList;

public class Armada {
  ArrayList<Ship> fleet = new ArrayList<>();

  public void fillArmada()
  {
    int count = (int)(Math.random() * 7) + 3;
    for (int i = 0; i < count; i++)
    {
      Ship newBoat = new Ship();
      newBoat.fillShip();
      fleet.add(newBoat);
    }
  }

  public int shipCount()
  {
    return fleet.size();
  }

  public boolean war(Armada enemy)
  {
    int fleetIndex = 0;
    int enemyIndex = 0;

    System.out.println("War is ahead of us!");

    while(fleetIndex != this.shipCount() && enemyIndex != enemy.shipCount())
    {
      Ship myShip = this.fleet.get(fleetIndex);
      Ship enemyShip = enemy.fleet.get(enemyIndex);
      if (myShip.battle(enemyShip))
      {
        enemyIndex++;
        System.out.println("We defeated one of their ships!");
      }
      else
      {
        fleetIndex++;
        System.out.println("The enemy defeated one of our ships!");
      }
    }
    return fleetIndex != this.shipCount();
  }
}
