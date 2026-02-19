package com.prep.arrays;

/**
 * HackerRank: Minimum Swaps 2
 * https://www.hackerrank.com/challenges/minimum-swaps-2
 * Difficulty: Medium
 *
 * Given an unordered array of consecutive integers [1..n],
 * find the minimum number of swaps to sort the array.
 *
 * Key insight: Follow cycles. Each cycle of length k needs (k-1) swaps.
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class MinimumSwaps {

    public static int minimumSwaps(int[] arr) {
        int swaps = 0;
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || arr[i] == i + 1) continue;

            // count cycle length
            int cycleLength = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j] - 1; // follow to correct position
                cycleLength++;
            }
            swaps += (cycleLength - 1);
        }
        return swaps;
    }
}
