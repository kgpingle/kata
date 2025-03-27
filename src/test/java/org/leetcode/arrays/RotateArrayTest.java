package org.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class RotateArrayTest {

  @Test
  void rotate() {
    assertArrayEquals(new int[]{-1}, RotateArray.rotate(new int[]{-1}, 2));
    assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4},
        RotateArray.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));

  }
}