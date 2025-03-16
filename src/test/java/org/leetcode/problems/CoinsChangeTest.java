package org.leetcode.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinsChangeTest {

  @Test
  @DisplayName("coins change test")
  public void shouldChangeCoins() {
    assertEquals(3, CoinsChange.findChange(new int[]{1, 2, 5}, 11));
  }
}
