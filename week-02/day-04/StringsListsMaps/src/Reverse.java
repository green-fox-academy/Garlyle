public class Reverse {
  public static void main(String... args){
    String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

    // Create a function that can reverse a String, which is passed as the parameter
    // Use it on this reversed string to check it!
    // Try to solve this using charAt() first, and optionally anything else after.
    reversed = reverse(reversed);

    System.out.println(reversed);
  }

  public static String reverse(String line)
  {
    char[] list = new char[line.length()];
    for (int i = 0; i < line.length(); i++)
    {
      list[i] = line.charAt(line.length() - i - 1);
    }
    line = new String(list);

    return line;
  }
}