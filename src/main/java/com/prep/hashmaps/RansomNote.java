package com.prep.hashmaps;

import java.util.HashMap;
import java.util.Map;

/**
 * HackerRank: Hash Tables - Ransom Note
 * https://www.hackerrank.com/challenges/ctci-ransom-note
 * Difficulty: Easy
 *
 * Check if a ransom note can be formed using words from a magazine.
 * Each word in the magazine can only be used once.
 *
 * Time:  O(m + n)
 * Space: O(m) where m = magazine words
 */
public class RansomNote {

    public static boolean checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : magazine) {
            freq.merge(word, 1, Integer::sum);
        }

        for (String word : note) {
            int count = freq.getOrDefault(word, 0);
            if (count == 0) return false;
            freq.put(word, count - 1);
        }
        return true;
    }
}
