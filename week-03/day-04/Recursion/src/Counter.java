public class Counter {
  // Write a recursive function that takes one parameter: n and counts down from n.
  public static void main(String[] args) {
    recursive_countdown(10);
  }

  public static void recursive_countdown(int n) {
    if (n > 0)
    {
      System.out.println(n);
      recursive_countdown(n - 1);
    }
  }

}
