package com.prep.exams.bolt.practice;

/**
 * Bolt Exam: Scooter Parking Zones
 *
 * Given N scooter pickup/dropoff coordinates on a 2D plane,
 * group them into grid cells of size gridSize, and return
 * the top K cells (by point count) as parking zone candidates.
 *
 * A grid cell is defined by: cellX = x / gridSize, cellY = y / gridSize.
 *
 * Return: int[k][2] with [cellX, cellY], sorted by count descending.
 *
 * Example:
 * points = [[1,2],[1,3],[5,5],[5,6],[9,1]], gridSize=3, k=2
 * Cells: (0,0)->2, (1,1)->2, (3,0)->1
 * Output: [[0,0], [1,1]] (top 2)
 */
public class ScooterParkingZonesPractice {

    public static int[][] topKZones(int[][] points, int gridSize, int k) {
        // YOUR SOLUTION HERE
        return new int[][] {};
    }
}
