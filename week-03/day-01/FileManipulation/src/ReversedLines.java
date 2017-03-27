import java.nio.file.*;
import java.util.*;

public class ReversedLines {

  public static void main(String[] args) {
    // Create a method that decrypts assets/reversed_zen_lines.txt
    Path filePath = Paths.get("assets/reversed-lines.txt");
    ArrayList<String> decryptedLines = new ArrayList<String>();

    try {
      List<String> encryptedLines = Files.readAllLines(filePath);
      for (String line : encryptedLines)
      {
        decryptedLines.add(decryptReversedLine(line));
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

  private static String decryptReversedLine(String line) {
    String newLine = new String();
    for (int i = 1; i <= line.length(); i++)
    {
      newLine += line.charAt(line.length() - i);
    }
    return newLine;
  }
}