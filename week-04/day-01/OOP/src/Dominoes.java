import java.util.ArrayList;
import java.util.List;

public class Dominoes {
  public static void main(String[] args) {
    List<Domino> dominoes = initializeDominoes();
    // You have the list of Dominoes
    // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
    // eg: [2, 4], [4, 3], [3, 5] ...
    dominoes = orderDominoes(dominoes);

    System.out.println(dominoes);
  }

  static List<Domino> initializeDominoes() {
    List<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(5, 2));
    dominoes.add(new Domino(4, 6));
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(6, 7));
    dominoes.add(new Domino(2, 4));
    dominoes.add(new Domino(7, 1));
    return dominoes;
  }

  static List<Domino> orderDominoes(List<Domino> dominoes)
  {
    int i = 0;
    int j = 1;

    while (j < dominoes.size())
    {
      if (dominoes.get(i).getValues()[1] == dominoes.get(j).getValues()[0])
      {
        dominoes.add(i + 1, dominoes.remove(j));
        i++;
        j = i + 1;
      }
      else
      {
        j++;
      }
    }
    return dominoes;
  }
}