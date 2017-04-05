package Sum;

import java.util.ArrayList;

public class Sum {
  public int sum(ArrayList<Integer> list) {
    if (list == null) return 0;

    int sum = 0;
    for (Integer i : list)
    {
      sum += i;
    }
    return sum;
  }
}
