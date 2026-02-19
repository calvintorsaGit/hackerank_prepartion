package com.prep.sorting;

/**
 * HackerRank: Merge Sort - Counting Inversions
 * https://www.hackerrank.com/challenges/ctci-merge-sort
 * Difficulty: Hard
 *
 * Count the number of inversions (i < j but arr[i] > arr[j]).
 * Use merge sort: during merge, when right element is smaller,
 * it's inverted with all remaining left elements.
 *
 * Time: O(n log n)
 * Space: O(n)
 */
public class CountingInversions {

    public static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;
        long count = 0;
        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid + 1, right);
        count += merge(arr, left, mid, right);
        return count;
    }

    private static long merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        long inversions = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // arr[i..mid] are all greater than arr[j] -> inversions
                inversions += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
        return inversions;
    }
}
