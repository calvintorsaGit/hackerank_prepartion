package com.prep.strings;

/**
 * HackerRank: Common Child
 * https://www.hackerrank.com/challenges/common-child
 * Difficulty: Medium
 *
 * Find the longest common subsequence (LCS) of two strings.
 * This is the classic LCS dynamic programming problem.
 *
 * Time: O(n * m)
 * Space: O(m) — optimized to single row
 */
public class CommonChild {

    public static int commonChild(String s1, String s2) {
        int m = s2.length();
        int[] dp = new int[m + 1];

        for (int i = 0; i < s1.length(); i++) {
            int prev = 0;
            for (int j = 0; j < m; j++) {
                int temp = dp[j + 1];
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[j + 1] = prev + 1;
                } else {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j]);
                }
                prev = temp;
            }
        }
        return dp[m];
    }
}
