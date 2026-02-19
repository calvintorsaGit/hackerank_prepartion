package com.prep.searching;

import java.util.TreeMap;

/**
 * HackerRank: Maximum Subarray Sum
 * https://www.hackerrank.com/challenges/maximum-subarray-sum
 * Difficulty: Hard
 *
 * Find the maximum subarray sum modulo m.
 *
 * Key insight: prefix[j] - prefix[i] mod m is maximized when
 * prefix[i] is the smallest value > prefix[j] (in the mod space).
 * Use a TreeSet to find the ceiling of (prefix[j] + 1).
 *
 * Time: O(n log n)
 * Space: O(n)
 */
public class MaximumSubarraySum {

    public static long maximumSum(long[] arr, long m) {
        long maxSum = 0;
        long prefix = 0;
        TreeMap<Long, Integer> set = new TreeMap<>();

        for (long val : arr) {
            prefix = (prefix + val % m) % m;
            maxSum = Math.max(maxSum, prefix);

            // find smallest prefix > current prefix (to maximize difference mod m)
            Long higher = set.higherKey(prefix);
            if (higher != null) {
                maxSum = Math.max(maxSum, (prefix - higher + m) % m);
            }

            set.merge(prefix, 1, Integer::sum);
        }
        return maxSum;
    }
}
