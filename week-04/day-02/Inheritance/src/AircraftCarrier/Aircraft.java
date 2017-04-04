package AircraftCarrier;

public class Aircraft {
  int maxAmmo;
  int baseDamage;
  int storedAmmo;

  public Aircraft(int maxAmmo, int baseDamage)
  {
    this.maxAmmo = maxAmmo;
    this.baseDamage = baseDamage;
    this.storedAmmo = 0;
  }

  public int allDamage()
  {
    return baseDamage * storedAmmo;
  }

  public boolean needsToBeRefilled()
  {
    return maxAmmo > storedAmmo;
  }

  public int fight()
  {
    int damage = allDamage();
    storedAmmo = 0;
    return damage;
  }

  public int refill(int value)
  {
    if (storedAmmo + value > maxAmmo)
    {
      int ammoDifference = value - (maxAmmo - storedAmmo);
      storedAmmo = maxAmmo;
      return ammoDifference;
    }
    else
    {
      storedAmmo += value;
      return 0;
    }
  }

  public String getType()
  {
    return "";
  }

  public String getStatus()
  {
    String s = "Type " + getType() +
        ", Ammo: " + storedAmmo +
        ", Base Damage: " + baseDamage +
        ", All Damage: " + allDamage();
    return s;
  }
}
