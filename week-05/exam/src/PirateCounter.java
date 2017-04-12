import java.util.*;

public class PirateCounter{

  static final int PLENTY_GOLD = 15;

  public static void main(String... args){
    ArrayList<Pirate> pirates = new ArrayList<>();

    // Given this list...

    pirates.add(new Pirate("Olaf", false, 12));
    pirates.add(new Pirate("Uwe", true, 9));
    pirates.add(new Pirate("Jack", true, 16));
    pirates.add(new Pirate("Morgan", false, 17));
    pirates.add(new Pirate("Hook", true, 20));

    // Write a function that takes any list that contains pirates as in the example,
    // And returns a list of names containing the pirates that
    // - have wooden leg and
    // - have more than 15 gold
    System.out.println("Pirates with wooden legs: " + getPiratesWithWoodenLeg(pirates));
    System.out.println("Pirates with more than " + PLENTY_GOLD + " gold: " + getPiratesWithPlentyGold(pirates));

  }

  private static ArrayList<String> getPiratesWithWoodenLeg(ArrayList<Pirate> pirates) {
    ArrayList<String> names = new ArrayList<>();
    for (Pirate pirate : pirates) {
      if (pirate.hasWoodenLeg) {
        names.add(pirate.name);
      }
    }
    return names;
  }

  private static ArrayList<String> getPiratesWithPlentyGold(ArrayList<Pirate> pirates) {
    ArrayList<String> names = new ArrayList<>();
    for (Pirate pirate : pirates) {
      if (pirate.gold > PLENTY_GOLD) {
        names.add(pirate.name);
      }
    }
    return names;
  }
}
