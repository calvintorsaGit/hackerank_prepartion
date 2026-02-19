package com.prep.sorting;

import java.util.Arrays;

/**
 * HackerRank: Mark and Toys
 * https://www.hackerrank.com/challenges/mark-and-toys
 * Difficulty: Easy
 *
 * Given toy prices and a budget, find the maximum number of toys you can buy.
 * Greedy: sort by price, buy cheapest first.
 *
 * Time: O(n log n)
 * Space: O(1)
 */
public class MarkAndToys {

    public static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int count = 0;

        for (int price : prices) {
            if (k < price)
                break;
            k -= price;
            count++;
        }
        return count;
    }
}
