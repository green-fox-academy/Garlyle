public class SplitString {
  public static void main(String[] args) {
    String[] result = splitString("lovebarbara", 4);
    if (result != null) {
      System.out.println(result[0] + "|" + result[1]);
    }
  }

  private static String[] splitString(String line, int index) {
    String[] split = new String[2];
    try {
      split[0] = line.substring(0, index);
      split[1] = line.substring(index);

      return split;
    } catch (IndexOutOfBoundsException ex) {
      System.out.println("Index out of bound exception happened.");
      return null;
    }
  }
}
