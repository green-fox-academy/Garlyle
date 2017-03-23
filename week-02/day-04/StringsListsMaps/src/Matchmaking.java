import java.util.*;

public class Matchmaking{
  public static void main(String... args){
    ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve","Ashley","Bözsi","Kat","Jane"));
    ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe","Fred","Béla","Todd","Neef","Jeff"));
    ArrayList<String> order = new ArrayList<String>();

    // Join the two lists by matching one girl with one boy in the order list
    // Exepected output: "Eve", "Joe", "Ashley", "Fred"...

    int shorter, longer;
    if (girls.size() > boys.size())
    {
      shorter = boys.size();
      longer = girls.size();
    }
    else
    {
      shorter = girls.size();
      longer = boys.size();
    }

    for (int i = 0; i < shorter; i++)
    {
      order.add(girls.get(i));
      order.add(boys.get(i));
    }
    for (int j = shorter; j < longer; j++)
    {
      if (girls.size() > boys.size())
      {
        order.add(girls.get(j));
      }
      else
      {
        order.add(boys.get(j));
      }
    }

    System.out.println(order);
  }
}