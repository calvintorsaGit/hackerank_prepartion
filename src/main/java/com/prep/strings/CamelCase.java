package com.prep.strings;

/**
 * HackerRank: CamelCase
 * https://www.hackerrank.com/challenges/camelcase
 * Difficulty: Easy
 *
 * Count the number of words in a camelCase string.
 * Each uppercase letter starts a new word. First word is lowercase.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class CamelCase {

    public static int camelcase(String s) {
        int count = 1; // first word is always lowercase
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) count++;
        }
        return count;
    }
}
