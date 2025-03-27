package org.leetcode.arrays;

public class BestTimeToBuySellStock {

  public static int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int minPrice = prices[0];
    int maxProfit = 0;
    for (int price : prices) {
      minPrice = Math.min(minPrice, price); // Update minPrice
      maxProfit = Math.max(maxProfit, price - minPrice); // Calculate profit
    }
    return maxProfit;
  }

  //122. Best Time to Buy and Sell Stock II
  public static int maxProfitII(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit += Math.subtractExact(prices[i], prices[i - 1]);
      }
    }
    return maxProfit;
  }

}
