package com.prep.arrays;

/**
 * HackerRank: Array Manipulation
 * https://www.hackerrank.com/challenges/crush
 * Difficulty: Hard
 *
 * Given array of size n (1-indexed), perform m operations.
 * Each operation adds value k to all elements from index a to b.
 * Return the maximum value in the array after all operations.
 *
 * Key insight: Use difference array / prefix sum technique.
 * Instead of updating every element in range, mark +k at start and -k after end.
 * Then compute prefix sum to get actual values.
 *
 * Time:  O(n + m)
 * Space: O(n)
 */
public class ArrayManipulation {

    public static long arrayManipulation(int n, int[][] queries) {
        long[] diff = new long[n + 2]; // 1-indexed, extra space to avoid bounds check

        for (int[] query : queries) {
            int a = query[0], b = query[1], k = query[2];
            diff[a] += k;
            diff[b + 1] -= k;
        }

        long max = 0, running = 0;
        for (int i = 1; i <= n; i++) {
            running += diff[i];
            max = Math.max(max, running);
        }
        return max;
    }
}
