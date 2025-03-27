package org.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FindMajorityTest {

  @Test
  void majorityElement() {
    assertEquals(3, FindMajority.majorityElement(new int[]{3, 2, 3}));
  }
}