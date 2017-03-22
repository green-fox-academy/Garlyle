// - Create a function called `printer`
//   which prints the input String parameters
//   (can have multiple number of arguments)
public class Printer {
  public static void main(String[] args) {
    String[] lines = {"Have", "a", "nice", "day!"};

    printer(lines);
  }

  public static void printer(String[] params)
  {
    for (String currentLine : params)
    {
      System.out.println(currentLine);
    }
  }
}
