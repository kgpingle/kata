package org.leetcode.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrappingRainWaterTest {

  @Test
  @DisplayName("should trap rain water")
  public void shouldTrapRainWater() {
    assertEquals(6, TrappingRainWater.trapRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    assertEquals(9, TrappingRainWater.trapRainWater(new int[]{4, 2, 0, 3, 2, 5}));
  }

}