import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args)
    {
        // Write a program that asks for 5 integers in a row,
        // then it should print the sum and the average of these numbers like:
        //
        // Sum: 22, Average: 4.4
        Scanner scanner = new Scanner(System.in);

        int total = 0;

        for (int i = 1; i <= 5; i++)
        {
            System.out.println(i + ". number out of 5: ");
            int val = scanner.nextInt();
            total += val;
        }

        System.out.println("Sum: " + total + ", Average: " + total / 5.);
    }
}
