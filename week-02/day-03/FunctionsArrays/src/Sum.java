// - Write a function called `sum` that sum all the numbers
//   until the given parameter
public class Sum {
  public static void main(String[] args) {
    System.out.println(sum(6));
  }

  public static int sum(int n)
  {
    int sum = 0;
    for (int i = 1; i <= n; i++)
    {
      sum += i;
    }
    return sum;
  }
}
