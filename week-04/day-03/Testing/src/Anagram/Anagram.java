package Anagram;

import java.util.Arrays;

public class Anagram {
  public char[] getCharacters(String line) {
    line = line.replaceAll("\\s+", "");
    line = line.toLowerCase();
    char[] result = line.toCharArray();
    Arrays.sort(result);

    return result;
  }

  public boolean areAnagrams(String s1, String s2) {
    return Arrays.equals(getCharacters(s1), getCharacters(s2));
  }
}
