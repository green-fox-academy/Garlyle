package Count;

import java.util.HashMap;

public class CountLetters {
  static HashMap<Character, Integer> Count(String line) {
    HashMap<Character, Integer> countedLetters = new HashMap<>();

    for (char letter : line.toCharArray()) {
      letter = Character.toLowerCase(letter);
      if (countedLetters.containsKey(letter)) {
        countedLetters.replace(letter, countedLetters.get(letter) + 1);
      }
      else {
        countedLetters.put(letter, 1);
      }
    }

    return countedLetters;
  }
}
