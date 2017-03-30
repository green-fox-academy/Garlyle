/**
 * Created by Milan Kovacs on 2017. 03. 30..
 */
public class String3 {
  // Given a string, compute recursively a new string where all the
  // adjacent chars are now separated by a "*".
  public static void main(String[] args) {
    String line = starSeparator("Green Fox Academy");
    System.out.println(line);
  }

  private static String starSeparator(String s) {
    String recursiveString = s.substring(0, s.length() - 1);
    String lastCharacter = s.substring(s.length() - 1);

    if (s.length() > 1)
    {
      return starSeparator(recursiveString) + "*" + lastCharacter;
    }
    else
    {
      return lastCharacter;
    }
  }
}
