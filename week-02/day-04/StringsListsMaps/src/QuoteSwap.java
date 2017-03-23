import java.util.*;

public class QuoteSwap{
  public static void main(String... args){
    ArrayList<String> list = new ArrayList<String>(Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand."));

    // Accidentally I messed up this quote from Richard Feynman.
    // Two words are out of place
    // Your task is to fix it by swapping the right words with code
    int firstIndex = list.indexOf("cannot");
    int secondIndex = list.indexOf("do");
    
    String temp = list.get(firstIndex);
    list.set(firstIndex, list.get(secondIndex));
    list.set(secondIndex, temp);

    // Also, print the sentence to the output with spaces in between.
    for(String line : list)
    {
      System.out.print(line + " ");
    }
  }
}
