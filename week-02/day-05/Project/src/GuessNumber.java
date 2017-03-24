import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
  public static void main(String[] args) {
    int lives = 5;
    int startRange, endRange;
    int numberToGuess;

    Scanner scanner = new Scanner(System.in);
    System.out.print("Give me the lowest value: ");
    startRange = scanner.nextInt();
    System.out.print("Give me the highest value: ");
    endRange = scanner.nextInt();

    Random rand = new Random();
    numberToGuess = startRange + rand.nextInt(endRange - startRange);
    System.out.println("I've the number between " + startRange + "-" + endRange +
        ". You have " + lives + " lives left.");

    boolean guessing = true;
    while(guessing)
    {
      System.out.print("Take a guess: ");
      int yourGuess = scanner.nextInt();

      if (yourGuess == numberToGuess)
      {
        System.out.println("Congratulations. You won!");
        guessing = false;
      }
      else
      {
        lives--;
        if (lives == 0)
        {
          System.out.println("Too bad. My number was " + numberToGuess);
          System.out.println("GAME OVER");
          guessing = false;
        }
        else if (yourGuess < numberToGuess)
        {
          System.out.println("Too low. You have " + lives + " lives left.");
        }
        else if (yourGuess > numberToGuess)
        {
          System.out.println("Too high. You have " + lives + " lives left.");
        }
      }
    }
  }
}
