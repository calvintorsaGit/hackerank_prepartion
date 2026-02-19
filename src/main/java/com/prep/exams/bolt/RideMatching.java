package com.prep.exams.bolt;

import java.util.Arrays;

/**
 * Bolt Exam: Ride Matching
 *
 * Match N riders to N drivers to minimize total distance.
 * Each rider i is at position riders[i] and each driver j at drivers[j]
 * on a 1D line.
 *
 * HOW TO SOLVE:
 * 1. This looks like an assignment problem, but in 1D it simplifies!
 * 2. Key insight: Sort both arrays. Pair the i-th rider with i-th driver.
 * - Proof by exchange argument: if lines cross, swapping reduces total.
 * - Imagine rider A at 1, rider B at 5, driver X at 4, driver Y at 2.
 * Cross: |1-4| + |5-2| = 3+3 = 6. Uncross: |1-2| + |5-4| = 1+1 = 2.
 * 3. Sort riders[] and drivers[] independently.
 * 4. Sum |riders[i] - drivers[i]| for all i.
 *
 * If you need original indices, track them with a [value, index] array.
 *
 * Pattern: Greedy / Sort
 * Time: O(n log n)
 * Space: O(1) if in-place sort
 */
public class RideMatching {

    public static long minimumTotalDistance(int[] riders, int[] drivers) {
        Arrays.sort(riders);
        Arrays.sort(drivers);

        long totalDist = 0;
        for (int i = 0; i < riders.length; i++) {
            totalDist += Math.abs(riders[i] - drivers[i]);
        }
        return totalDist;
    }

    /**
     * Return the matched pairs as [riderOrigIndex, driverOrigIndex].
     */
    public static int[][] matchPairs(int[] riders, int[] drivers) {
        int n = riders.length;

        // create indexed arrays to track original positions
        int[][] riderIdx = new int[n][2];
        int[][] driverIdx = new int[n][2];
        for (int i = 0; i < n; i++) {
            riderIdx[i] = new int[] { riders[i], i };
            driverIdx[i] = new int[] { drivers[i], i };
        }

        Arrays.sort(riderIdx, (a, b) -> a[0] - b[0]);
        Arrays.sort(driverIdx, (a, b) -> a[0] - b[0]);

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] { riderIdx[i][1], driverIdx[i][1] };
        }
        return pairs;
    }
}
