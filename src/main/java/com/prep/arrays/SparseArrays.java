package com.prep.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HackerRank: Sparse Arrays
 * https://www.hackerrank.com/challenges/sparse-arrays
 * Difficulty: Medium
 *
 * Given a list of strings and a list of queries, for each query
 * count how many times it appears in the strings list.
 *
 * Time:  O(n + q) where n = strings count, q = queries count
 * Space: O(n)
 */
public class SparseArrays {

    public static int[] matchingStrings(List<String> strings, List<String> queries) {
        Map<String, Integer> freq = new HashMap<>();
        for (String s : strings) {
            freq.merge(s, 1, Integer::sum);
        }

        int[] result = new int[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = freq.getOrDefault(queries.get(i), 0);
        }
        return result;
    }
}
