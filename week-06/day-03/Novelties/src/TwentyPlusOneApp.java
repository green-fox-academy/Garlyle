import TwentyPlusOne.*;

public class TwentyPlusOneApp {
  public static void main(String[] args) {
    Deck playingDeck = new Deck();
    playingDeck.shuffleDeck();
    Card drawnCard = playingDeck.pullFirst();
    System.out.println(drawnCard + ": " + drawnCard.getValue());
  }
}
