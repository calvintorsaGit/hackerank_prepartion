package com.prep.dynamicprogramming;

/**
 * HackerRank: Coin Change Problem
 * https://www.hackerrank.com/challenges/coin-change
 * Difficulty: Medium
 *
 * Given coin denominations and a target amount,
 * find the number of distinct ways to make change.
 *
 * Classic unbounded knapsack DP.
 * dp[j] = number of ways to make amount j using coins considered so far.
 *
 * Time: O(n * amount)
 * Space: O(amount)
 */
public class CoinChange {

    public static long getWays(int amount, int[] coins) {
        long[] dp = new long[amount + 1];
        dp[0] = 1; // one way to make 0: use no coins

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
