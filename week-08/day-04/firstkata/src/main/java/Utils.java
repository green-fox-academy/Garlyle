import java.util.Arrays;

public class Utils {
  public static boolean areAnagrams(String first, String second) {
    if (second == null || first == null) {
      return false;
    }
    char[] sortedA, sortedB;
    sortedA = first.replaceAll(" ", "").toLowerCase().toCharArray();
    sortedB = second.replaceAll(" ", "").toLowerCase().toCharArray();
    if (sortedA.length != sortedB.length) {
      return false;
    }
    Arrays.sort(sortedA);
    Arrays.sort(sortedB);

    for (int i = 0; i < sortedA.length; i++) {
      if (sortedA[i] != sortedB[i]) {
        return false;
      }
    }
    return true;
  }
}
