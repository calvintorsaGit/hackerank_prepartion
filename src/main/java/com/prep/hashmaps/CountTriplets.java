package com.prep.hashmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HackerRank: Count Triplets
 * https://www.hackerrank.com/challenges/count-triplets-1
 * Difficulty: Medium
 *
 * Given an array and a ratio r, count triplets (i,j,k) where
 * i < j < k and arr[j]/arr[i] = arr[k]/arr[j] = r.
 *
 * Key insight: For each element arr[j], count how many arr[j]/r
 * appeared before it and how many arr[j]*r appear after it.
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class CountTriplets {

    public static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> leftMap = new HashMap<>();  // count of values seen so far
        Map<Long, Long> rightMap = new HashMap<>();  // count of values yet to come

        for (long val : arr) {
            rightMap.merge(val, 1L, Long::sum);
        }

        long count = 0;
        for (long val : arr) {
            rightMap.merge(val, -1L, Long::sum);

            if (val % r == 0) {
                long left = leftMap.getOrDefault(val / r, 0L);
                long right = rightMap.getOrDefault(val * r, 0L);
                count += left * right;
            }

            leftMap.merge(val, 1L, Long::sum);
        }
        return count;
    }
}
