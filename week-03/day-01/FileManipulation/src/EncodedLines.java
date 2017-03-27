import java.nio.file.*;
import java.util.*;

public class EncodedLines {

  public static void main(String[] args) {
    // Create a method that decrypts assets/reversed_zen_lines.txt
    Path filePath = Paths.get("assets/encoded-lines.txt");
    ArrayList<String> decryptedLines = new ArrayList<String>();

    try {
      List<String> encryptedLines = Files.readAllLines(filePath);
      for (String line : encryptedLines)
      {
        decryptedLines.add(decryptEncodedLine(line));
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

  private static String decryptEncodedLine(String line) {
    String newLine = new String();
    for (int i = 0; i < line.length(); i++)
    {
      char encodedChar = line.charAt(i);
      if (encodedChar != ' ') encodedChar -= 1;
      newLine += encodedChar;
    }
    return newLine;
  }
}