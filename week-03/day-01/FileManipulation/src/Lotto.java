import java.nio.file.*;
import java.util.*;

public class Lotto {

  public static void main(String[] args) {
    // Create a method that find the 5 most common lotto numbers assets/lotto.csv
    int[] numberoccurrence = new int[90];
    Path filePath = Paths.get("assets/otos.csv");

    try
    {
      List<String> fileLines = Files.readAllLines(filePath);
      for (String line : fileLines)
      {
        // get the 5 last element from each line, and increase occurrence by index
        String[] split = line.split(";");
        for (int i = 1; i <= 5; i++)
        {
          int a = Integer.parseInt(split[split.length - i]);
          numberoccurrence[a - 1]++;
        }
      }
      System.out.println("Checking occurrence order");
      ArrayList<Integer> occurrenceOrder = new ArrayList<Integer>();
      occurrenceOrder.add(0);
      for (int i = 1; i < numberoccurrence.length; i++)
        for (int j = 0; j < occurrenceOrder.size(); j++)
        {
          int k = occurrenceOrder.get(j);
          if (numberoccurrence[i] >= numberoccurrence[k])
          {
            occurrenceOrder.add(j, i);
            break;
          }
        }
      System.out.println("Done!");
      for (int i = 0; i < 5; i++)
      {
        int k = occurrenceOrder.get(i);
        System.out.println("Occurence of number " + k + ": " + numberoccurrence[k]);
      }
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }
  }
}