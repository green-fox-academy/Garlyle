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
      firstPlayer.increasePoints();
    } else {
      secondPlayer.increasePoints();
    }
  }

  public String getScore() {
    if (scoresAreEqual()) {
      return equalScoreResults(firstPlayer.getPoints());
    } else if (firstPlayer.isWinnning() || secondPlayer.isWinnning()) {
      return highScoreResults(firstPlayer.getPoints(), secondPlayer.getPoints());
    } else {
      return scoreResults();
    }
  }

  private String equalScoreResults(int score) {
    if (score > 3) {
      return "Deuce";
    }
    return SCORE_NAMING[score] + "-All";
  }

  private String highScoreResults(int firstScore, int secondScore) {
    if (getDifference(firstScore, secondScore) == 1) {
      return "Advantage " + getWinnerPlayerName();
    } else {
      return "Win for " + getWinnerPlayerName();
    }
  }

  private String scoreResults() {
    return SCORE_NAMING[firstPlayer.getPoints()] + "-" + SCORE_NAMING[secondPlayer.getPoints()];
  }

  private boolean scoresAreEqual() {
    return firstPlayer.getPoints() == secondPlayer.getPoints();
  }

  private int getDifference(int first, int second) {
    int difference = first - second;

    return Math.abs(difference);
  }

  private String getWinnerPlayerName() {
    if (firstPlayer.getPoints() > secondPlayer.getPoints()) {
      return firstPlayer.getName();
    } else {
      return secondPlayer.getName();
    }
  }

}
