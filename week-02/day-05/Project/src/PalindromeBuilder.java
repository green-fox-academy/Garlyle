import java.util.Scanner;

/**
 * Created by Milan Kovacs on 2017. 03. 24..
 */
public class PalindromeBuilder {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter Text: ");
    String line = scanner.nextLine();

    System.out.println("Here a palindrome for it: " + createPalindrome(line));
  }

  public static String createPalindrome(String line)
  {
    int length = line.length();
    for (int i = length -1; i >= 0; i--)
    {
      line = line + line.charAt(i);
    }

    return line;
  }
}
