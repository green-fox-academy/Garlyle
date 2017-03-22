import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // diamond like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *
        //
        // The diamond should have as many lines as the number was
        //                         -------------
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number!: ");
        int num = scanner.nextInt();
        int mid = num - (num / 2);

        for (int i = 1; i < mid; i++)
        {
            String s = new String();
            for (int j = i; j < mid; j++)
            {
                s += " ";
            }
            s += "*";
                for (int k = 1; k < i; k++)
                {
                    s += "**";
                }
            System.out.println(s);
        }
        if (num % 2 == 0)
        {
            for (int i = 1; i < num; i++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = mid; i >= 1; i--)
        {
            String s = new String();
            for (int j = mid; j > i; j--)
            {
                s += " ";
            }
            s += "*";
            for (int k = i; k > 1; k--)
            {
                s += "**";
            }
            System.out.println(s);
        }

    }
}
