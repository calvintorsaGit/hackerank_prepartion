package com.prep.searching;

/**
 * HackerRank: Minimum Time Required
 * https://www.hackerrank.com/challenges/minimum-time-required
 * Difficulty: Medium
 *
 * n machines, each takes machines[i] days to produce one item.
 * Find minimum days to produce goal items.
 *
 * Key insight: Binary search on the answer (number of days).
 * For a given number of days d, total items = sum(d / machines[i]).
 *
 * Time: O(n * log(maxDays))
 * Space: O(1)
 */
public class MinimumTimeRequired {

    public static long minTime(long[] machines, long goal) {
        long low = 1;
        long high = Long.MAX_VALUE / 2;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long produced = 0;

            for (long m : machines) {
                produced += mid / m;
                if (produced >= goal)
                    break; // early exit
            }

            if (produced >= goal) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
