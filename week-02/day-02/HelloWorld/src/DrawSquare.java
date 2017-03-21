import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // square like this:
        //
        //
        // %%%%%
        // %   %
        // %   %
        // %   %
        // %   %
        // %%%%%
        //
        // The square should have as many lines as the number was
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number!: ");
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++)
        {
            for (int j = 1; j <= num; j++)
            {
                if (i == 1 || i == num || j == 1 || j == num)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
