package com.prep.sorting;

import java.util.Arrays;

/**
 * HackerRank: Sorting - Comparator
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting
 * Difficulty: Medium
 *
 * Sort players by score descending, then by name ascending (if tied).
 *
 * Time: O(n log n)
 * Space: O(1)
 */
public class PlayerComparator {

    public static String[][] sortPlayers(String[][] players) {
        // players[i] = {name, score}
        Arrays.sort(players, (a, b) -> {
            int scoreA = Integer.parseInt(a[1]);
            int scoreB = Integer.parseInt(b[1]);
            if (scoreA != scoreB)
                return scoreB - scoreA; // descending score
            return a[0].compareTo(b[0]); // ascending name
        });
        return players;
    }
}
