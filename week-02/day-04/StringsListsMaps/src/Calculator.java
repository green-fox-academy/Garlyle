import java.util.*;

// Create a simple calculator application which reads the parameters from the prompt
// and prints the result to the prompt.
// It should support the following operations:
// +, -, *, /, % and it should support two operands.
// The format of the expressions must be: {operation} {operand} {operand}.
// Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

// You can use the Scanner class
// It should work like this:

// Start the program
// It prints: "Please type in the expression:"
// Waits for the user input
// Print the result to the prompt
// Exit

public class Calculator {
  public static void main(String... args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please type in the expression:");
    String input = scanner.nextLine();

    String[] list = input.split(" ");

    // Checking parameters
    if (list.length != 3)
    {
      System.out.println("Calculator only work with 3 parameters: {operation} {operand} {operand}");
      System.exit(0);
    }

    for (int i = 0; i < list[1].length(); i++)
    {
      if (!Character.isDigit(list[1].charAt(i)))
      {
        System.out.println("Second parameter must be a number");
        System.exit(0);
      }
    }
    for (int i = 0; i < list[2].length(); i++)
    {
      if (!Character.isDigit(list[2].charAt(i)))
      {
        System.out.println("Third parameter must be a number");
        System.exit(0);
      }
    }

    int a = Integer.parseInt(list[1]);
    int b = Integer.parseInt(list[2]);
    int result = 0;

    // Calculations
    if (list[0].equals("+"))
    {
      result = a + b;
    }
    else if (list[0].equals("-"))
    {
      result = a - b;
    }
    else if (list[0].equals("*"))
    {
      result = a * b;
    }
    else if (list[0].equals("/"))
    {
      if (b == 0)
      {
        System.out.println("Division by Zero is not included yet");
        System.exit(0);
      }
      result = a / b;
    }
    else if (list[0].equals("%"))
    {
      result = a % b;
    }
    else
    {
      System.out.println("Invalid Operation");
      System.exit(0);
    }
    System.out.println(" = " + result);
  }
}
