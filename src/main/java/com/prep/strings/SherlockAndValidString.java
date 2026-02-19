package com.prep.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * HackerRank: Sherlock and the Valid String
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string
 * Difficulty: Medium
 *
 * A string is valid if all characters have the same frequency,
 * or if removing exactly one character makes all frequencies equal.
 *
 * Time: O(n)
 * Space: O(1) — at most 26 characters
 */
public class SherlockAndValidString {

    public static String isValid(String s) {
        // step 1: character frequency
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.merge(c, 1, Integer::sum);
        }

        // step 2: frequency of frequencies
        Map<Integer, Integer> freqFreq = new HashMap<>();
        for (int f : charFreq.values()) {
            freqFreq.merge(f, 1, Integer::sum);
        }

        // case 1: all same frequency
        if (freqFreq.size() == 1)
            return "YES";

        // case 2: exactly 2 different frequencies
        if (freqFreq.size() == 2) {
            var entries = freqFreq.entrySet().toArray(new Map.Entry[0]);
            int f1 = (int) entries[0].getKey(), c1 = (int) entries[0].getValue();
            int f2 = (int) entries[1].getKey(), c2 = (int) entries[1].getValue();

            // remove one char from one group to match the other
            if (f1 == 1 && c1 == 1)
                return "YES"; // remove one char entirely
            if (f2 == 1 && c2 == 1)
                return "YES";
            if (f1 - 1 == f2 && c1 == 1)
                return "YES"; // reduce one group by 1
            if (f2 - 1 == f1 && c2 == 1)
                return "YES";
        }

        return "NO";
    }
}
