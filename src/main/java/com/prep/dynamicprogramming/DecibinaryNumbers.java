package com.prep.dynamicprogramming;

/**
 * HackerRank: Decibinary Numbers
 * https://www.hackerrank.com/challenges/decibinary-numbers
 * Difficulty: Hard
 *
 * A decibinary number uses digits 0-9 where position i has value digit * 2^i
 * (instead of 10^i). Multiple decibinary numbers can map to the same decimal.
 * Given x, find the x-th decibinary number in sorted order.
 *
 * Key insight: Precompute dp[val][digits] = number of decibinary
 * representations
 * of decimal value val using a certain number of digit positions.
 * Then use prefix sums to binary search for the answer.
 *
 * Time: O(D * V * 9) precomputation, O(D) per query
 * Space: O(D * V)
 */
public class DecibinaryNumbers {

    private static final int MAX_VAL = 300_001; // max decimal value
    private static final int MAX_DIGITS = 20;

    public static long decibinary(long x) {
        // dp[d][v] = # of d-digit decibinary numbers with decimal value v
        // This is a simplified version; full solution needs careful bounds.

        // For each query, walk digit by digit choosing 0-9
        // using precomputed counts to navigate the sorted order.

        // Precompute dp
        int safeMax = Math.min(MAX_VAL, 300_000);
        long[][] dp = new long[MAX_DIGITS][safeMax + 1];

        dp[0][0] = 1;
        for (int d = 0; d < MAX_DIGITS - 1; d++) {
            for (int v = 0; v <= safeMax; v++) {
                if (dp[d][v] == 0)
                    continue;
                int placeVal = 1 << (d + 1);
                for (int digit = 0; digit <= 9; digit++) {
                    int newVal = v + digit * placeVal;
                    if (newVal <= safeMax) {
                        dp[d + 1][newVal] += dp[d][v];
                    }
                }
            }
        }

        // count[v] = total decibinary numbers with decimal value v
        long[] count = new long[safeMax + 1];
        for (int v = 0; v <= safeMax; v++) {
            for (int d = 0; d < MAX_DIGITS; d++) {
                count[v] += dp[d][v];
            }
        }

        // prefix[v] = total decibinary numbers with decimal value <= v
        long[] prefix = new long[safeMax + 1];
        prefix[0] = count[0];
        for (int v = 1; v <= safeMax; v++) {
            prefix[v] = prefix[v - 1] + count[v];
        }

        // find which decimal value the x-th decibinary corresponds to
        int targetVal = binarySearch(prefix, x);
        long remaining = x - (targetVal > 0 ? prefix[targetVal - 1] : 0);

        // reconstruct the decibinary number
        return reconstruct(dp, targetVal, remaining);
    }

    private static int binarySearch(long[] prefix, long x) {
        int lo = 0, hi = prefix.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (prefix[mid] >= x)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    private static long reconstruct(long[][] dp, int targetVal, long rank) {
        long result = 0;

        for (int d = MAX_DIGITS - 1; d >= 0; d--) {
            for (int digit = 0; digit <= 9; digit++) {
                int remVal = targetVal - digit * (1 << d);
                if (remVal < 0)
                    break;
                long ways = 0;
                for (int dd = 0; dd < d; dd++) {
                    if (remVal < dp[dd].length)
                        ways += dp[dd][remVal];
                }
                if (d == 0)
                    ways = (remVal == 0) ? 1 : 0;

                if (rank <= ways) {
                    result += digit * (long) Math.pow(10, d);
                    targetVal = remVal;
                    break;
                }
                rank -= ways;
            }
        }
        return result;
    }
}
