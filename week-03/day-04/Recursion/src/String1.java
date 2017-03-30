public class String1 {
  // Given a string, compute recursively (no loops) a new string where all the
  // lowercase 'x' chars have been changed to 'y' chars.
  public static void main(String[] args) {
    String line = replaceXY("xXx_BoxOfJava_xXx");
    System.out.println(line);
  }

  private static String replaceXY(String s) {
    String recursiveString = s.substring(0, s.length() - 1);
    char xChecker = s.charAt(s.length() - 1);
    if (xChecker == 'x') xChecker = 'y';

    if (s.length() > 1)
    {
      return replaceXY(recursiveString) + xChecker;
    }
    else
    {
      return Character.toString(xChecker);
    }
  }
}
