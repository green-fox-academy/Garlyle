import creditcard.CreditCard;

import java.util.ArrayList;

public class CreditCardApp {
  public static void main(String[] args) {
    ArrayList<CreditCard> cards = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      cards.add(new CreditCard("ABC" + i));
    }
    for (CreditCard card : cards) {
      System.out.println(card + " (validated)");
    }
  }
}
