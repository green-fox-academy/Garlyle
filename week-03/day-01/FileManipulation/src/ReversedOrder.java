import java.nio.file.*;
import java.util.*;

public class ReversedOrder {

  public static void main(String[] args) {
    // Create a method that decrypts assets/reversed_zen_order.txt
    Path filePath = Paths.get("assets/reversed-order.txt");
    ArrayList<String> decryptedLines = new ArrayList<String>();

    try {
      List<String> encryptedLines = Files.readAllLines(filePath);
      for (String line : encryptedLines) {
        decryptedLines.add(0, line);
      }

      for (String line : decryptedLines) {
        System.out.println(line);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}