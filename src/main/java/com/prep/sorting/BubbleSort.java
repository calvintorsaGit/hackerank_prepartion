package com.prep.sorting;

/**
 * HackerRank: Sorting - Bubble Sort
 * https://www.hackerrank.com/challenges/ctci-bubble-sort
 * Difficulty: Easy
 *
 * Perform bubble sort and print the number of swaps,
 * the first element, and the last element of the sorted array.
 *
 * Time: O(n^2)
 * Space: O(1)
 */
public class BubbleSort {

    public static int bubbleSort(int[] a) {
        int n = a.length;
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
            int swaps = 0;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swaps++;
                }
            }
            totalSwaps += swaps;
            if (swaps == 0)
                break; // already sorted
        }
        return totalSwaps;
    }
}
