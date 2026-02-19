package com.prep.exams.bolt;

import java.util.*;

/**
 * Bolt Exam: Scooter Parking Zones
 *
 * Given scooter pickup/dropoff coordinates, find the top K
 * hotspot clusters where parking docks should be placed.
 *
 * Simplified: given N points on a 2D grid, group points
 * into grid cells of size S, return the top K cells by count.
 *
 * Example:
 * points: [(1,2),(1,3),(5,5),(5,6),(9,1)], gridSize=3, k=2
 * cells: (0,0)->2 points, (1,1)->2 points, (3,0)->1 point
 * top 2: [(0,0), (1,1)]
 *
 * HOW TO SOLVE:
 * 1. Map each point to a grid cell: cellX = x / gridSize, cellY = y / gridSize.
 * This is spatial hashing — turns a clustering problem into counting.
 * 2. Use HashMap<String, count> to count points per cell.
 * Key = "cellX,cellY" (or encode as long: cellX * BIG + cellY).
 * 3. Find top K cells using a MIN-heap of size K.
 * - Why min-heap? We evict the smallest count when heap > K.
 * - After processing all cells, the heap contains K largest.
 * 4. Extract and sort results by count descending.
 *
 * This combines two classic patterns:
 * - HashMap counting (like word frequency)
 * - Top K elements (like K most frequent)
 *
 * Pattern: HashMap counting + Min-Heap for top K
 * Time: O(n + m log k) where m = unique cells
 * Space: O(m)
 */
public class ScooterParkingZones {

    public static int[][] topKZones(int[][] points, int gridSize, int k) {
        // count points per grid cell
        Map<String, int[]> cellCount = new HashMap<>();

        for (int[] p : points) {
            int cellX = p[0] / gridSize;
            int cellY = p[1] / gridSize;
            String key = cellX + "," + cellY;
            cellCount.computeIfAbsent(key, x -> new int[] { cellX, cellY, 0 });
            cellCount.get(key)[2]++;
        }

        // min-heap of size k to find top K zones
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int[] cell : cellCount.values()) {
            minHeap.offer(cell);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // extract results sorted by count descending
        int[][] result = new int[minHeap.size()][2];
        int idx = minHeap.size() - 1;
        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            result[idx--] = new int[] { cell[0], cell[1] };
        }
        return result;
    }
}
