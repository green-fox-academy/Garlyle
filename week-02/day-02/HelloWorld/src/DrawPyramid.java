import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // pyramid like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //
        // The pyramid should have as many lines as the number was
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number!: ");
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++)
        {
            String s = new String();
            for (int j = num; j >= 1; j--)
            {
                if (j > i)
                {
                    // Area before the pyramid
                    s += " ";
                }
                else if (j == i)
                {
                    // Reached the side, first building block
                    s += "*";
                }
                else
                {
                    // On lower level, the pyramid will be twice as wide
                    s += "**";
                }
            }
            System.out.println(s);
        }
    }
}
