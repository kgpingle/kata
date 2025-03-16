package org.leetcode.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BestTimeToBuyStocksTest {

  @Test
  @DisplayName("maximize profits for once sell")
  public void shouldMaximizeProfits() {
    assertEquals(0, BestTimeToBuyStocks.maxProfitV1(new int[]{}));
    assertEquals(0, BestTimeToBuyStocks.maxProfitV1(new int[]{7, 6, 4, 3, 1}));
    assertEquals(5, BestTimeToBuyStocks.maxProfitV1(new int[]{7, 1, 5, 3, 6, 4}));
    assertEquals(31, BestTimeToBuyStocks.maxProfitV1(new int[]{1, 2, 4, 8, 16, 32}));
  }

  @Test
  @DisplayName("maximize profits for multiple sell")
  public void shouldMaximizeProfitsForMultipleSell() {
    assertEquals(7, BestTimeToBuyStocks.maxProfitMultipleSell(new int[]{7, 1, 5, 3, 6, 4}));
    assertEquals(31, BestTimeToBuyStocks.maxProfitMultipleSell(new int[]{1, 2, 4, 8, 16, 32}));
  }

  @Test
  @DisplayName("maximize profits for atmost 2 sell")
  public void shouldMaximizeProfitsForAtMost2Sell() {
    assertEquals(7, BestTimeToBuyStocks.maxProfitFor2Sell(new int[]{7, 1, 5, 3, 6, 4}));
    assertEquals(31, BestTimeToBuyStocks.maxProfitFor2Sell(new int[]{1, 2, 4, 8, 16, 32}));
  }

  @Test
  @DisplayName("maximize profits for atmost K sell")
  public void shouldMaximizeProfitsForAtMostKSell() {
    assertEquals(2, BestTimeToBuyStocks.maxProfitForKSell(new int[]{2, 4, 1}, 2));
    assertEquals(7, BestTimeToBuyStocks.maxProfitForKSell(new int[]{3, 2, 6, 5, 0, 3}, 2));
  }
}
