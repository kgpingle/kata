package org.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MergeSortedArrayTest {

  @Test
  public void shouldMergeSortedArrays() {
    assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6},
        MergeSortedArray.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3));
  }

}