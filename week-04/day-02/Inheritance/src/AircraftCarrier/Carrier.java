package AircraftCarrier;

import java.util.ArrayList;

public class Carrier {
  ArrayList<Aircraft> storedAircrafts;
  int ammoStorage;
  int hitPoints;

  public Carrier(int ammoStorage)
  {
    storedAircrafts = new ArrayList<>();
    this.ammoStorage = ammoStorage;
  }

  public void addAircraft(String type)
  {
    if (type.equals("F16"))
      storedAircrafts.add(new F16());
    else if (type.equals("F35"))
      storedAircrafts.add(new F35());
  }

  public void fill()
  {
    // refill F35's first
    // if no ammo, throw exception
    for (Aircraft plane : storedAircrafts)
    {
      if (plane.needsToBeRefilled())
      {
        ammoStorage = plane.refill(ammoStorage);
      }
    }
  }

  public int totalDamage()
  {
    int total = 0;
    for (Aircraft plane : storedAircrafts)
    {
      total += plane.allDamage();
    }
    return total;
  }

  public void fight(Carrier enemy)
  {
    enemy.hitPoints -= totalDamage();
    for (Aircraft plane : storedAircrafts)
    {
      plane.storedAmmo = 0;
    }
  }

  public void getStatus()
  {
    if (hitPoints <= 0)
    {
      System.out.println("It's dead Jim :(");
    }
    else
    {
      System.out.println("Aircraft count: " + storedAircrafts.size() +
          ", Ammo Storage: " + ammoStorage +
          ", Total damage: " + totalDamage());
      System.out.println("Aircrafts:");
      for (Aircraft plane : storedAircrafts)
      {
        plane.getStatus();
      }
    }
  }
}
