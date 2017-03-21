import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        // Write a program that asks for two integers
        // The first represents the number of chickens the farmer has
        // The seconf represents the number of pigs the farmer has
        // It should print how many legs all the animals have
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many chickens?: ");
        int chickens = scanner.nextInt();

        System.out.println("How many pigs?: ");
        int pigs = scanner.nextInt();

        int total = chickens * 2 + pigs * 4;
        System.out.println("The animals together have " + total + " legs");
    }
}