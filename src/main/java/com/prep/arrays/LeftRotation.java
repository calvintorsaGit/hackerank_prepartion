package com.prep.arrays;

/**
 * HackerRank: Arrays - Left Rotation
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 * Difficulty: Easy
 *
 * Rotate array left by d positions.
 * [1,2,3,4,5] rotated by 2 -> [3,4,5,1,2]
 * 
 * solution
 * newArr[0] = oldArr[(0 + d ) % arr.length]
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class LeftRotation {

    public static int[] rotateLeft(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = arr[(i + d) % n];
        }
        return result;
    }
}
