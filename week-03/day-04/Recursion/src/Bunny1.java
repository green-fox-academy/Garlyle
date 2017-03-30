public class Bunny1 {
  // We have a number of bunnies and each bunny has two big floppy ears.
  // We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
  public static void main(String[] args) {
    int ears = bunnyEars(42);
    System.out.println(ears);
  }

  private static int bunnyEars(int bunnies) {
    if (bunnies > 1)
    {
      return 2 + bunnyEars(bunnies - 1);
    }
    else
    {
      return 2;
    }
  }
}
