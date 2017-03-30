/**
 * Created by Milan Kovacs on 2017. 03. 30..
 */
public class Power {
  // Given base and n that are both 1 or more, compute recursively (no loops)
  // the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
  public static void main(String[] args) {
    int result = powerN(2, 16);
    System.out.println(result);
  }

  private static int powerN(int base, int n) {
    if (n > 1) {
      return base * powerN(base, n - 1);
    }
    else
    {
      return base;
    }
  }
}
