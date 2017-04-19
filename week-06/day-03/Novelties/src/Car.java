import java.util.ArrayList;
import java.util.*;

public class Car {
  public enum Type {
    LADA, ZSIGULI, TRABANT, SKODA, WARTBURG, POLSKI, DACIA
  }

  public enum Color {
    RED, GREEN, BLUE, YELLOW, BLACK, WHITE
  }

  Type type;
  Color color;

  // ref: http://stackoverflow.com/questions/1972392/java-pick-a-random-value-from-an-enum
  Car() {
    int typeIndex = (int)(Math.random() * Type.values().length);
    int colorIndex = (int)(Math.random() * Color.values().length);
    type = Type.values()[typeIndex];
    color = Color.values()[colorIndex];
  }

  public String toString() {
    return color.toString() + " " + type.toString();
  }

  // ref: http://stackoverflow.com/questions/19031213/java-get-most-common-element-in-a-list
  public static Car mostCommon(ArrayList<Car> list) {
    Map<Car, Integer> map = new HashMap<>();

    for (Car car : list) {
      Integer val = map.get(car);
      map.put(car, val == null ? 1 : val + 1);
    }

    Map.Entry<Car, Integer> max = null;

    for (Map.Entry<Car, Integer> entry : map.entrySet()) {
      if (max == null || entry.getValue() > max.getValue())
        max = entry;
    }

    return max.getKey();
  }

  public static void main(String[] args) {
    ArrayList<Car> listOfCars = new ArrayList<>();
    for (int i = 0; i < 256; i++) {
      listOfCars.add(new Car());
    }

    for (Type type : Type.values()) {
      int count = 0;
      for (Car car : listOfCars) {
        if (car.type.equals(type)) {
          count++;
        }
      }
      System.out.println(type.name() + " cars: " + count);
    }
    System.out.println();

    for (Color color : Color.values()) {
      int count = 0;
      for (Car car : listOfCars) {
        if (car.color.equals(color)) {
          count++;
        }
      }
      System.out.println(color.name() + " cars: " + count);
    }
    System.out.println();
    System.out.println("Most common car is the " + mostCommon(listOfCars));
  }
}
