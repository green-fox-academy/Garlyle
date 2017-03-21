import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Write a program that stores a number, and the user has to figure it out.
        // The user can input guesses, after each guess the program would tell one
        // of the following:
        //
        // The stored number is higher
        // The stried number is lower
        // You found the number: 8
        int numberToGuess = 42;
        int guess = 0;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Guess a number: ");
            guess = scanner.nextInt();

            if (guess > numberToGuess)
            {
                System.out.println("Too Big");
            }
            if (guess < numberToGuess)
            {
                System.out.println("Too Small");
            }
        } while(guess != numberToGuess);
        System.out.println("You got it!");
    }
}
