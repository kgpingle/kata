package org.leetcode.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RotateImageTest {

  @Test
  @DisplayName("should transpose array")
  public void shouldTransposeArray() {
    int[][] rotatedArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
    int[][] imageArray = RotateImage.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    for (int row = 0; row < rotatedArray.length; row++) {
      for (int column = 0; column < rotatedArray[row].length; column++) {
        assertEquals(rotatedArray[row][column], imageArray[row][column]);
      }
    }
  }

}