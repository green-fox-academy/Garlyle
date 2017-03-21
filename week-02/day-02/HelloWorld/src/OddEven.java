import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args)
    {
        // Write a program that reads a number from the standard input,
        // Than prints "Odd" if the number is odd, or "Even" it it is even.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        if(num % 2 == 0)
        {
            System.out.println("This is even!");
        }
        else
        {
            System.out.println("This is odd! o.O");
        }
    }
}
