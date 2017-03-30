/**
 * Created by Milan Kovacs on 2017. 03. 30..
 */
public class Sumdigit {
  // Given a non-negative int n, return the sum of its digits recursively (no loops).
  // Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while
  // divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
  public static void main(String[] args) {
    int i = sumDigits(126);
    System.out.println(i);
  }

  private static int sumDigits(int n) {
    int next = n / 10;
    if (next > 0)
    {
      return (n % 10) + sumDigits(next);
    }
    else
    {
      return n;
    }
  }
}
