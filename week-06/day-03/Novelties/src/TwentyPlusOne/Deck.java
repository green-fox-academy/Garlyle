package TwentyPlusOne;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  ArrayList<Card> deckOfCards;

  public Deck() {
    deckOfCards = new ArrayList<>();
    for (Card.Suit suit : Card.Suit.values()) {
      for (Card.Rank rank : Card.Rank.values()) {
        deckOfCards.add(new Card(suit, rank));
      }
    }
  }

  public void shuffleDeck() {
    Collections.shuffle(deckOfCards);
  }

  private Card pull(int index) {
    Card drawnCard = deckOfCards.get(index);
    deckOfCards.remove(index);
    return drawnCard;
  }

  public Card pullFirst() {
    return pull(0);
  }

  public Card pullLast() {
    return pull(deckOfCards.size() - 1);
  }

  public Card pullRandom() {
    return pull((int)(Math.random() * deckOfCards.size()));
  }
}
