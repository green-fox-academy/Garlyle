import java.util.ArrayList;
import java.util.Arrays;

public class Seconds {
  public static void main(String[] args) {
    // Create a function that takes a list as a parameter,
    // and returns a new list with every second element from the orignal list
    // example: [1, 2, 3, 4, 5] should produce [2, 4] - print this result
    ArrayList<Integer> list = new ArrayList<>();
    list.addAll(Arrays.asList(1, 2, 3, 4, 5));
    System.out.println(list);
    list = secondElements(list);
    System.out.println(list);
  }

  private static ArrayList<Integer> secondElements(ArrayList<Integer> list) {
    if (list.size() < 2) {
      return null;
    } else {
      ArrayList<Integer> returnElements = new ArrayList<>();
      for (int i = 1; i < list.size(); i += 2) {
        returnElements.add(list.get(i));
      }
      return returnElements;
    }
  }
}
