// - Create a function called `factorio`
//   that returns it's input's factorial
public class Factorio {
  public static void main(String[] args) {
    System.out.println(factorio(5));
  }

  public static int factorio(int n)
  {
    int sum = 1;
    for (int i = 1; i <= n; i++)
    {
      sum *= i;
    }
    return sum;
  }
}
