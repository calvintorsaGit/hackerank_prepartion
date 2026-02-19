package com.prep.hashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * HackerRank: Sherlock and Anagrams
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 * Difficulty: Medium
 *
 * Find the number of anagrammatic pairs of substrings in a string.
 * Two substrings are anagrammatic if one can be rearranged to form the other.
 *
 * Key insight: Two substrings are anagrams if their sorted versions are equal.
 * For each substring length, sort and count duplicates. Pairs = C(count, 2).
 *
 * Time:  O(n^3 * log n) — n^2 substrings, each sorted in O(n log n)
 * Space: O(n^2)
 */
public class SherlockAndAnagrams {

    public static int sherlockAndAnagrams(String s) {
        int count = 0;
        int n = s.length();

        for (int len = 1; len < n; len++) {
            Map<String, Integer> freq = new HashMap<>();

            for (int i = 0; i <= n - len; i++) {
                char[] sub = s.substring(i, i + len).toCharArray();
                Arrays.sort(sub);
                String key = new String(sub);
                freq.merge(key, 1, Integer::sum);
            }

            // for each group of k matching substrings, pairs = k*(k-1)/2
            for (int v : freq.values()) {
                count += v * (v - 1) / 2;
            }
        }
        return count;
    }
}
