package org.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BestTimeToBuySellStockTest {

  @Test
  void maxProfit() {
    assertEquals(5, BestTimeToBuySellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }

  @Test
  void maxProfitII() {
    assertEquals(7, BestTimeToBuySellStock.maxProfitII(new int[]{7, 1, 5, 3, 6, 4}));
  }
}