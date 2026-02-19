package com.prep.dynamicprogramming;

/**
 * HackerRank: Abbreviation
 * https://www.hackerrank.com/challenges/abbr
 * Difficulty: Medium
 *
 * Can string a be transformed to string b by:
 * 1. Capitalizing some lowercase letters in a
 * 2. Deleting all remaining lowercase letters in a
 *
 * dp[i][j] = can a[0..i-1] be transformed to match b[0..j-1]?
 *
 * Time: O(n * m)
 * Space: O(n * m)
 */
public class Abbreviation {

    public static String abbreviation(String a, String b) {
        int n = a.length(), m = b.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // if a has leading lowercase chars, they can be deleted
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && Character.isLowerCase(a.charAt(i - 1));
        }

        for (int i = 1; i <= n; i++) {
            char ca = a.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char cb = b.charAt(j - 1);

                if (Character.toUpperCase(ca) == cb) {
                    // capitalize and match, or delete if lowercase
                    dp[i][j] = dp[i - 1][j - 1];
                    if (Character.isLowerCase(ca)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // or delete
                    }
                } else if (Character.isLowerCase(ca)) {
                    dp[i][j] = dp[i - 1][j]; // must delete
                }
                // else: uppercase mismatch -> false (default)
            }
        }
        return dp[n][m] ? "YES" : "NO";
    }
}
