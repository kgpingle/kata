package org.leetcode.problems;

public class SnakeGame {

  enum Move {
    UP,
    DOWN,
    LEFT,
    RIGHT
  }

  int[][] gameBoard;
  int initialSnakeSize = 2;
  int headXCordinate = 0;
  int headYCordinate = 0;

  public SnakeGame(int gameSize) {
    this.gameBoard = new int[gameSize][gameSize];
  }

  public void play(Move move) {
    if (!validMove(move)) {
      throw new IllegalArgumentException("Game Over");
    }
    
  }

  private boolean validMove(Move move) {
    return switch (move) {
      case UP -> {
        if (headXCordinate - 1 < 0 || gameBoard[headXCordinate - 1][headYCordinate] == 9) {
          yield false;
        }
        yield true;
      }
      case DOWN -> {
        if (headXCordinate + 1 > gameBoard.length
            || gameBoard[headXCordinate + 1][headYCordinate] == 9) {
          yield false;
        }
        yield true;
      }
      case LEFT -> {
        if (headYCordinate - 1 < 0 || gameBoard[headXCordinate][headYCordinate - 1] == 9) {
          yield false;
        }
        yield true;
      }
      case RIGHT -> {
        if (headYCordinate + 1 > gameBoard.length
            || gameBoard[headXCordinate][headYCordinate + 1] == 9) {
          yield false;
        }
        yield true;
      }
    };
  }
}
