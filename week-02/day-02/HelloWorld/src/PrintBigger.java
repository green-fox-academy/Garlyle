import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args)
    {
        // Write a program that asks for two numbers and prints the bigger one
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1st number: ");
        int a = scanner.nextInt();
        System.out.println("Enter 2nd number: ");
        int b = scanner.nextInt();

        if (a == b)
        {
            System.out.println("The numbers are equal");
        }
        else if (a < b)
        {
            System.out.println(b);
        }
        else
        {
            System.out.println(a);
        }
    }
}
