package org.leetcode.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.leetcode.problems.ClimbStairs.climbStairs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClimbingStairsTest {

  @Test
  @DisplayName("climbing stairs test")
  public void shouldClimbStairs() {
    assertEquals(3, climbStairs(3));
    assertEquals(2, climbStairs(2));
    assertEquals(5, climbStairs(4));
  }

}
