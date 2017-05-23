import classes.Player;

public class TennisGame1 implements TennisGame {

  private final String[] SCORE_NAMING = {"Love", "Fifteen", "Thirty", "Forty"};

  private Player firstPlayer;
  private Player secondPlayer;

  public TennisGame1(String player1Name, String player2Name) {
    firstPlayer = new Player(player1Name);
    secondPlayer = new Player(player2Name);
  }

  public void wonPoint(String playerName) {
    if (firstPlayer.hasName(playerName)) {
      firstPlayer.increaseScore(1);
    } else {
      secondPlayer.increaseScore(1);
    }
  }

  public String getScore() {
    if (scoresAreEqual()) {
      return equalScores(firstPlayer.getPoints());
    } else if (firstPlayer.isWinnning() || secondPlayer.isWinnning()) {
      return highScores(firstPlayer.getPoints(), secondPlayer.getPoints());
    } else {
      return scoreResult();
    }
  }

  private String scoreResult() {
    return SCORE_NAMING[firstPlayer.getPoints()] + "-" + SCORE_NAMING[secondPlayer.getPoints()];
  }

  private boolean scoresAreEqual() {
    return firstPlayer.getPoints() == secondPlayer.getPoints();
  }

  private String highScores(int firstScore, int secondScore) {
    int scoreDifference = firstScore - secondScore;
    String playerNameWithAdvantage;
    if (firstScore > secondScore) {
      playerNameWithAdvantage = firstPlayer.getName();
    } else {
      playerNameWithAdvantage = secondPlayer.getName();
    }
    scoreDifference = Math.abs(scoreDifference);

    if (scoreDifference == 1) {
      return "Advantage " + playerNameWithAdvantage;
    } else {
      return "Win for " + playerNameWithAdvantage;
    }
  }

  private String equalScores(int score) {
    if (score > 3) {
      return "Deuce";
    }
    return SCORE_NAMING[score] + "-All";
  }
}
