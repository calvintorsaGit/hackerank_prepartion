package com.prep.arrays;

/**
 * HackerRank: New Year Chaos
 * https://www.hackerrank.com/challenges/new-year-chaos
 * Difficulty: Medium
 *
 * People in a queue can bribe the person in front (max 2 bribes each).
 * Given the final state, find total number of bribes or "Too chaotic".
 *
 * Key insight: For each person, count how many people with a higher number
 * are ahead of them. Each person can move at most 2 positions forward.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class NewYearChaos {

    public static String minimumBribes(int[] q) {
        int bribes = 0;

        for (int i = 0; i < q.length; i++) {
            // person q[i] is at position i (0-indexed), originally at q[i]-1
            if (q[i] - (i + 1) > 2) {
                return "Too chaotic";
            }

            // count how many people ahead of position i have bribed past q[i]
            // person q[i] originally at index q[i]-1, could have been pushed back
            // only need to check from max(0, q[i]-2) to i-1
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }
        return String.valueOf(bribes);
    }
}
