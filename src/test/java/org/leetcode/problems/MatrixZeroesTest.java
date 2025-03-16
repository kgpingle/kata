package org.leetcode.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatrixZeroesTest {

  @Test
  @DisplayName("should mark matrix zero")
  public void shouldMarkMatrixZero() {
    int[][] expectedArray = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
    int[][] imageArray = MatrixZeroes.matrixZero(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    for (int row = 0; row < expectedArray.length; row++) {
      for (int column = 0; column < expectedArray[row].length; column++) {
        assertEquals(expectedArray[row][column], imageArray[row][column]);
      }
    }
  }
}