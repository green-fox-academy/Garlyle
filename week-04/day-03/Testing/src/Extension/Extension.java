package Extension;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aze on 2017.04.04..
 */
public class Extension {
  int add(int a, int b) {
    return a + b;
  }

  int maxOfThree(int a, int b, int c) {
    if (a >= b && a >= c)
    {
      return a;
    }
    else if (b >= c)
    {
      return b;
    }
    else
    {
      return c;
    }
  }

  int median(List<Integer> pool) {
    Integer[] sortedPool = (Integer[])pool.toArray();
    Arrays.sort(sortedPool);

    int middle = sortedPool.length/2;
    if (sortedPool.length % 2 == 1) {
      return sortedPool[middle];
    } else {
      return (sortedPool[middle-1] + sortedPool[middle]) / 2;
    }
  }

  boolean isVowel(char c) {
    return Arrays.asList('a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű').contains(c);
  }

  String translate(String hungarian) {
    String teve = new String();
    for (char c : hungarian.toCharArray()) {
      if (isVowel(c)) {
        teve = teve + c + 'v' + c;
      } else {
        teve = teve + c;
      }
    }
    return teve;
  }
}