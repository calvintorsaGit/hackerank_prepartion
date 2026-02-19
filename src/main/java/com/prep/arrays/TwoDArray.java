package com.prep.arrays;

/**
 * HackerRank: 2D Array - DS
 * https://www.hackerrank.com/challenges/2d-array
 * Difficulty: Easy
 *
 * Given a 6x6 2D array, calculate the hourglass sum for every hourglass
 * and return the maximum hourglass sum.
 *
 * Hourglass shape:
 *   a b c
 *     d
 *   e f g
 *
 * Time:  O(1) - fixed 6x6 grid, always 16 hourglasses
 * Space: O(1)
 */
public class TwoDArray {

    public static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]   // top
                        + arr[i + 1][j + 1]                            // middle
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]; // bottom
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
