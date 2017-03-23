import java.util.*;

public class SolarSystem {
  public static void main(String... args){
    ArrayList<String> planetList = new ArrayList<String>(Arrays.asList("Mercury","Venus","Earth","Mars","Jupiter","Uranus","Neptune"));

    // Saturn is missing from the planetList
    // Insert it into the correct position
    int pos = planetList.indexOf("Uranus");
    planetList.add(pos, "Saturn");

    System.out.println(planetList);
  }
}