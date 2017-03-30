public class String2 {
  // Given a string, compute recursively a new string where all the 'x' chars have been removed.
  public static void main(String[] args) {
    String line = removeX("xXx_BoxOfJava_xXx");
    System.out.println(line);
  }

  private static String removeX(String s) {
    String recursiveString = s.substring(0, s.length() - 1);
    String xChecker = s.substring(s.length() - 1);
    if (xChecker.equals("x")) xChecker = "";

    if (s.length() > 1)
    {
      return removeX(recursiveString) + xChecker;
    }
    else
    {
      return xChecker;
    }
  }
}
