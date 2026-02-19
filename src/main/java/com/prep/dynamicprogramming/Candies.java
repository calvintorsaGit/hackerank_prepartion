package com.prep.dynamicprogramming;

/**
 * HackerRank: Candies
 * https://www.hackerrank.com/challenges/candies
 * Difficulty: Medium
 *
 * Each child gets at least 1 candy. If a child has a higher rating
 * than a neighbor, they must get more candies than that neighbor.
 * Minimize total candies.
 *
 * Key insight: Two passes — left-to-right ensures right neighbor rule,
 * right-to-left ensures left neighbor rule. Take max at each position.
 *
 * Time: O(n)
 * Space: O(n)
 */
public class Candies {

    public static long candies(int n, int[] ratings) {
        int[] candies = new int[n];

        // left to right pass
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            candies[i] = (ratings[i] > ratings[i - 1]) ? candies[i - 1] + 1 : 1;
        }

        // right to left pass
        long total = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            total += candies[i];
        }
        return total;
    }
}
