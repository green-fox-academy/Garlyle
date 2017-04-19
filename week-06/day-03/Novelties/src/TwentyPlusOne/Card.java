package TwentyPlusOne;

public class Card {
  private int value;

  public enum Color { RED, BLACK }
  public enum Suit { CLUBS, HEARTS, SPADES, DIAMONDS }
  public enum Rank {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(10), QUEEN(10), KING(10), ACE(11);

    private int value;

    Rank(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  Color color;
  Suit suit;
  Rank rank;

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
    color = (suit == Suit.DIAMONDS || suit == Suit.HEARTS)? Color.RED : Color.BLACK;
  }

  public int getValue() {
    return rank.getValue();
  }

  private String toCapital(String name) {
    return name.charAt(0) + name.substring(1, name.length()).toLowerCase();
  }

  public String toString() {
    return toCapital(rank.name()) + " of " + toCapital(suit.name());
  }

}
