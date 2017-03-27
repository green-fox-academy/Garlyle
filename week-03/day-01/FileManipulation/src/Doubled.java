import java.nio.file.*;
import java.util.*;

public class Doubled {

  public static void main(String[] args) {
    // Create a method that decrypts the assets/duplicated_chars.txt
    Path filePath = Paths.get("assets/duplicated-chars.txt");
    ArrayList<String> decryptedLines = new ArrayList<String>();

    try {
      List<String> encryptedLines = Files.readAllLines(filePath);
      for (String line : encryptedLines)
      {
        decryptedLines.add(decryptDoubledLine(line));
      }

      for (String line : decryptedLines)
      {
        System.out.println(line);
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  public static String decryptDoubledLine(String line)
  {
    String newLine = new String();
    for (int i = 0; i < line.length(); i += 2)
    {
      newLine += line.charAt(i);
    }
    return newLine;
  }
}