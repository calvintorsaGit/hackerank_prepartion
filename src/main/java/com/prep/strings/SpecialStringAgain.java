package com.prep.strings;

/**
 * HackerRank: Special String Again
 * https://www.hackerrank.com/challenges/special-palindrome-again
 * Difficulty: Medium
 *
 * Count special palindromic substrings. A string is special if:
 * - All characters are the same (e.g., "aaa"), OR
 * - All characters except the middle are the same (e.g., "aadaa")
 *
 * Key insight: Compress into runs, then count:
 * 1. Each run of length k contributes k*(k+1)/2 single-char palindromes
 * 2. Adjacent same-char runs separated by a single different char
 *
 * Time: O(n)
 * Space: O(n)
 */
public class SpecialStringAgain {

    public static long substrCount(int n, String s) {
        // compress into runs: (char, count)
        char[] chars = new char[n];
        int[] counts = new int[n];
        int runs = 0;

        for (int i = 0; i < n; i++) {
            if (runs == 0 || s.charAt(i) != chars[runs - 1]) {
                chars[runs] = s.charAt(i);
                counts[runs] = 1;
                runs++;
            } else {
                counts[runs - 1]++;
            }
        }

        long result = 0;

        for (int i = 0; i < runs; i++) {
            // type 1: all same chars — k*(k+1)/2
            result += (long) counts[i] * (counts[i] + 1) / 2;

            // type 2: "aba" pattern — single char middle between same-char runs
            if (i > 0 && i < runs - 1
                    && counts[i] == 1
                    && chars[i - 1] == chars[i + 1]) {
                result += Math.min(counts[i - 1], counts[i + 1]);
            }
        }
        return result;
    }
}
