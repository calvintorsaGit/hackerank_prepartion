package com.prep.searching;

import java.util.HashSet;
import java.util.Set;

/**
 * HackerRank: Pairs
 * https://www.hackerrank.com/challenges/pairs
 * Difficulty: Medium
 *
 * Count pairs with difference equal to k.
 * For each element, check if (element + k) exists in the set.
 *
 * Time: O(n)
 * Space: O(n)
 */
public class Pairs {

    public static int pairs(int k, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int val : arr)
            set.add(val);

        int count = 0;
        for (int val : arr) {
            if (set.contains(val + k))
                count++;
        }
        return count;
    }
}
