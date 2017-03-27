import java.nio.file.*;
import java.util.*;

public class Lotto {

  public static void main(String[] args) {
    // Create a method that find the 5 most common lotto numbers assets/lotto.csv
    int[] numberOccurence = new int[90];
    Path filePath = Paths.get("assets/otos.csv");

    try
    {
      List<String> fileLines = Files.readAllLines(filePath);
      for (String line : fileLines)
      {
        // get the 5 last element from each line, and increase occurence by index
        String[] split = line.split(";");
        for (int i = 1; i <= 5; i++)
        {
          int a = Integer.parseInt(split[split.length - i]);
          numberOccurence[a - 1]++;
        }
      }
      for (int i = 0; i < numberOccurence.length; i++)
      {
        System.out.println(i + 1 + ". occurence: " + numberOccurence[i]);
      }
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }
  }
}