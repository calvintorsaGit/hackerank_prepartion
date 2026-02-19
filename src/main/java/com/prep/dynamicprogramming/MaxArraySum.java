package com.prep.dynamicprogramming;

/**
 * HackerRank: Max Array Sum
 * https://www.hackerrank.com/challenges/max-array-sum
 * Difficulty: Medium
 *
 * Find maximum sum of non-adjacent elements in an array.
 *
 * dp[i] = max(dp[i-1], dp[i-2] + arr[i], arr[i])
 * At each step: skip current element or take it (adding to best from 2 back).
 *
 * Time: O(n)
 * Space: O(1)
 */
public class MaxArraySum {

    public static int maxSubsetSum(int[] arr) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return Math.max(0, arr[0]);

        int prev2 = Math.max(0, arr[0]);
        int prev1 = Math.max(prev2, arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int curr = Math.max(prev1, Math.max(prev2 + arr[i], arr[i]));
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
