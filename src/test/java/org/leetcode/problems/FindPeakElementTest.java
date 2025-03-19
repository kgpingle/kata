package org.leetcode.problems;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FindPeakElementTest {

  @Test
  @DisplayName("should find peak")
  public void shouldFindPeak() {
    assertEquals(1, FindPeakElement.findPeakElement(new int[]{1, 2}));
    assertEquals(0, FindPeakElement.findPeakElement(new int[]{-2147483647, -2147483648}));
    assertEquals(5, FindPeakElement.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    assertEquals(2, FindPeakElement.findPeakElement(new int[]{1, 2, 3, 1}));
    assertEquals(0, FindPeakElement.findPeakElement(new int[]{2, 1}));
  }

}