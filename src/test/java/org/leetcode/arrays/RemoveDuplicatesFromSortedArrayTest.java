package org.leetcode.arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RemoveDuplicatesFromSortedArrayTest {

  @Test
  void removeDuplicates() {
    assertEquals(2, RemoveDuplicatesFromSortedArray.removeDuplicates(new int[]{1, 1, 2}));
  }

  @Test
  void removeDuplicatesUpto2() {
    assertEquals(5,
        RemoveDuplicatesFromSortedArray.removeDuplicatesUpto2(new int[]{1, 1, 1, 2, 2, 3}));
    assertEquals(5,
        RemoveDuplicatesFromSortedArray.removeDuplicatesUpto2(new int[]{1, 1, 1, 2, 2, 3}));
  }
}