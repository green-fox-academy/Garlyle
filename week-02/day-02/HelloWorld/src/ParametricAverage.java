import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] args) {
        // Write a program that asks for a number.
        // It would ask this many times to enter an integer,
        // if all the integers are entered, it should print the sum and average of these
        // integers like:
        //
        // Sum: 22, Average: 4.4
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        int count = 0;
        int total = 0;

        do {
            System.out.println("Enter a number(0 to finish): ");
            num = scanner.nextInt();
            if (num != 0)
            {
                total += num;
                count++;
            }
        } while (num != 0);
        System.out.println("Sum: " + total + ", Average: " + total / count);
    }
}
