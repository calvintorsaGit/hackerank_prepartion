package com.prep.searching;

import java.util.HashMap;
import java.util.Map;

/**
 * HackerRank: Hash Tables - Ice Cream Parlor
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
 * Difficulty: Easy
 *
 * Find two ice cream flavors that cost exactly the given money.
 * Return their 1-indexed positions.
 *
 * Time: O(n)
 * Space: O(n)
 */
public class IceCreamParlor {

    public static int[] icecreamParlor(int money, int[] cost) {
        Map<Integer, Integer> seen = new HashMap<>(); // cost -> index

        for (int i = 0; i < cost.length; i++) {
            int complement = money - cost[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement) + 1, i + 1 };
            }
            seen.put(cost[i], i);
        }
        return new int[] {};
    }
}
