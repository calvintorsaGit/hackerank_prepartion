package com.prep.strings;

/**
 * HackerRank: Making Anagrams
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 * Difficulty: Easy
 *
 * Find the minimum number of character deletions to make two strings anagrams.
 *
 * Time: O(n + m)
 * Space: O(1) — fixed 26-char array
 */
public class MakingAnagrams {

    public static int makeAnagram(String a, String b) {
        int[] freq = new int[26];

        for (char c : a.toCharArray())
            freq[c - 'a']++;
        for (char c : b.toCharArray())
            freq[c - 'a']--;

        int deletions = 0;
        for (int f : freq) {
            deletions += Math.abs(f);
        }
        return deletions;
    }
}
