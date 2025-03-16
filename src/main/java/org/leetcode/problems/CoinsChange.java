package org.leetcode.problems;

import java.util.Arrays;

public class CoinsChange {

  public static int findChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1); // Fill with a large value (infinity equivalent)
    dp[0] = 0; // Base case: 0 coins needed to make amount 0

    // Compute the minimum coins required for each amount
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i >= coin) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    // If dp[amount] is still the large value, return -1 (not possible)
    return dp[amount] > amount ? -1 : dp[amount];
  }
}
