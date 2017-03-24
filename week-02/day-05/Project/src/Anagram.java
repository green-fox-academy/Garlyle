import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Milan Kovacs on 2017. 03. 24..
 */
public class Anagram {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Give me the first line: ");
    String s1 = scanner.nextLine();
    System.out.println("Give me the second line: ");
    String s2 = scanner.nextLine();

    if (isAnagram(s1, s2))
    {
      System.out.println("These lines are anagrams");
    }
    else
    {
      System.out.println("These lines are not anagrams");
    }
  }

  public static boolean isAnagram(String s1, String s2)
  {
    char[] sortedA, sortedB;

    sortedA = s1.toCharArray();
    Arrays.sort(sortedA);

    sortedB = s2.toCharArray();
    Arrays.sort(sortedB);

    return Arrays.equals(sortedA, sortedB);
  }
}
