package org.leetcode.problems;

import java.util.Arrays;

public class BestTimeToBuyStocks {

  // v1
  public static int maxProfitV1(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else {
        maxProfit = Math.max(prices[i] - minPrice, maxProfit);
      }
    }
    return maxProfit;
  }

  //V2
  public static int maxProfitMultipleSell(int[] prices) {
    // DP approach.
//    int cash = 0, hold = -prices[0];
//    for (int i = 1; i < prices.length; i++) {
//      cash = Math.max(cash, hold + prices[i]);  // If we sell today
//      hold = Math.max(hold, cash - prices[i]);  // If we buy today
//    }
    //return cash;

    // Greedy approach
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit += prices[i] - prices[i - 1];
      }
    }
    return maxProfit;
  }

  // V3
  public static int maxProfitFor2Sell(int[] prices) {
    int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
    for (int price : prices) {
      buy1 = Math.max(buy1, -price);
      sell1 = Math.max(sell1, buy1 + price);
      buy2 = Math.max(buy2, sell1 - price);
      sell2 = Math.max(sell2, buy2 + price);
    }
    return sell2;
  }

  // V4
  public static int maxProfitForKSell(int[] prices, int k) {
    int n = prices.length;
    if (k > n / 2) {
      return maxProfitMultipleSell(prices);
    }
    int[] buy = new int[k + 1];
    int[] sell = new int[k + 1];
    Arrays.fill(buy, Integer.MIN_VALUE);
    for (int price : prices) {
      for (int j = 1; j <= k; j++) {
        buy[j] = Math.max(buy[j], sell[j - 1] - price);
        sell[j] = Math.max(sell[j], buy[j] + price);
      }
    }
    return sell[k];
  }


}
