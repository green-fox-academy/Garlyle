import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountAs {
  public static void main(String[] args) {
    // Create a function that takes a filename as string parameter,
    // counts the occurances of the letter "a", and returns it as a number.
    // If the file does not exist, the function should return 0 and not break.

    // example: on the input "afile.txt" the function should return 28 - print this result
    // example: on the input "not-a-file" the function should return 0 - print this result
    int count = countLetterA("afile.txt");
    System.out.println(count);
    count = countLetterA("not-a-file.txt");
    System.out.println(count);
  }

  private static int countLetterA(String filename) {
    Path filePath = Paths.get(filename);
    int count = 0;

    try {
      for (String line : Files.readAllLines(filePath)) {
        for (int i = 0; i < line.length(); i++) {
          if (line.toLowerCase().charAt(i) == 'a') {
            count++;
          }
        }
      }
    } catch (IOException e) {
    }
    return count;
  }
}
