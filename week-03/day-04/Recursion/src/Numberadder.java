/**
 * Created by Milan Kovacs on 2017. 03. 30..
 */
public class Numberadder {
  // Write a recursive function that takes one parameter: n and adds numbers from 1 to n.
  public static void main(String[] args) {
    int total = recursiveAdder(6);
    System.out.println(total);
  }

  private static int recursiveAdder(int n) {
    if (n == 1)
      return 1;
    else
      return n + recursiveAdder(n - 1);
  }
}
