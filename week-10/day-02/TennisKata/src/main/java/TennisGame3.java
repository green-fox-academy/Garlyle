import classes.Player;

public class TennisGame3 implements TennisGame {
  private final String[] SCORE_NAMING = {"Love", "Fifteen", "Thirty", "Forty"};

  private Player firstPlayer;
  private Player secondPlayer;

  TennisGame3(String player1Name, String player2Name) {
    firstPlayer = new Player(player1Name);
    secondPlayer = new Player(player2Name);
  }

  public String getScore() {
    if (!firstPlayer.isWinnning() && !secondPlayer.isWinnning()) {
      if (scoresAreEqual()) {
        return getResult(firstPlayer) + "-All";
      } else {
        return getResult(firstPlayer) + "-" + getResult(secondPlayer);
      }
    } else if (scoresAreEqual()) {
      return "Deuce";
    } else {
      if (getDifference() == 1) {
        return "Advantage " + getWinnerPlayerName();
      } else {
        return "Win for " + getWinnerPlayerName();
      }
    }
  }

  private String getResult(Player player) {
    return SCORE_NAMING[player.getPoints()];
  }

  private int getDifference() {
    int difference = firstPlayer.getPoints() - secondPlayer.getPoints();

    return difference * difference;
  }

  private String getWinnerPlayerName() {
    if (firstPlayer.getPoints() > secondPlayer.getPoints()) {
      return firstPlayer.getName();
    } else {
      return secondPlayer.getName();
    }
  }

  private boolean scoresAreEqual() {
    return firstPlayer.getPoints() == secondPlayer.getPoints();
  }

  public void wonPoint(String playerName) {
    if (firstPlayer.hasName(playerName)) {
      firstPlayer.increasePoints();
    } else {
      secondPlayer.increasePoints();
    }
  }

}
