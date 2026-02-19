package com.prep.hashmaps;

import java.util.HashSet;
import java.util.Set;

/**
 * HackerRank: Two Strings
 * https://www.hackerrank.com/challenges/two-strings
 * Difficulty: Easy
 *
 * Determine if two strings share a common substring.
 * A single shared character counts as a common substring.
 *
 * Time:  O(n + m)
 * Space: O(min(n, m, 26)) -> O(1) since alphabet is fixed
 */
public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
        Set<Character> chars = new HashSet<>();
        for (char c : s1.toCharArray()) {
            chars.add(c);
        }

        for (char c : s2.toCharArray()) {
            if (chars.contains(c)) return "YES";
        }
        return "NO";
    }
}
