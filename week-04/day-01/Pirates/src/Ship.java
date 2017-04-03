import java.util.ArrayList;

public class Ship {
  ArrayList<Pirate> crew = new ArrayList<>();
  Pirate captain;

  public void fillShip()
  {
    captain = new Pirate();
    int crewCount = (int)(Math.random() * 10) + 1;
    for (int i = 0; i < crewCount; i++)
    {
      crew.add(new Pirate());
    }
  }

  public int crewSize()
  {
    return crew.size();
  }

  public int battleScore()
  {
    int score = crewSize() - captain.intoxication;
    return score;
  }

  public void lostBattle()
  {
    int deaths = (int)(Math.random() * crewSize());
    for (int i = 0; i < deaths; i++)
    {
      crew.remove(0);
    }
  }

  public void wonBattle()
  {
    int numberOfRums = (int)(Math.random() * crewSize());
    captain.drinkSomeRum(numberOfRums);
    for (Pirate crewMember : crew)
    {
      crewMember.drinkSomeRum(numberOfRums);
    }
  }

  public boolean battle(Ship enemy)
  {
    if (this.battleScore() > enemy.battleScore())
    {
      this.wonBattle();
      enemy.lostBattle();
      return true;
    }
    else
    {
      enemy.wonBattle();
      this.lostBattle();
      return false;
    }
  }

  @Override
  public String toString()
  {
    String result = "";
    if (captain.isAlive)
    {
      result = result + "Cap'n is alive 'n gut " + captain.intoxication + " rums down. ";
    }
    else
    {
      result = result + "Cap'n is already dead. ";
    }
    result = result + crewSize() + " member of the crew is alive.";

    return result;
  }
}
