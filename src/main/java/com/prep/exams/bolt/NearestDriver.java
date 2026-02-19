package com.prep.exams.bolt;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Bolt Exam: Nearest Driver
 *
 * Given a passenger location and a list of driver locations,
 * find the K nearest drivers.
 *
 * Input: passenger [x, y], drivers [[x1,y1], [x2,y2], ...], k
 * Output: indices of k nearest drivers (sorted by distance)
 *
 * HOW TO SOLVE:
 * 1. Recognize this as "K closest points" — a classic Heap problem.
 * 2. Use a MAX-heap of size K (not min-heap!). Why max?
 * - We want to keep the K smallest distances.
 * - The max-heap lets us quickly check the LARGEST of our K candidates.
 * - If a new driver is closer than the farthest in the heap, swap it.
 * 3. For each driver, compute squared distance (avoid sqrt — it's monotonic).
 * 4. If heap has < K items, add directly.
 * If heap is full and new dist < heap.peek(), poll + offer.
 * 5. Extract indices from heap and sort the result.
 *
 * Why not just sort all drivers? Sorting is O(n log n).
 * Heap approach is O(n log k) — faster when k << n.
 *
 * Pattern: Max-Heap of size K
 * Time: O(n log k)
 * Space: O(k)
 */
public class NearestDriver {

    public static int[] findNearest(int[] passenger, int[][] drivers, int k) {
        // max-heap: keep k smallest distances, evict largest
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b[1], a[1]) // compare by distance desc
        );

        for (int i = 0; i < drivers.length; i++) {
            int dist = squaredDist(passenger, drivers[i]);
            if (maxHeap.size() < k) {
                maxHeap.offer(new int[] { i, dist });
            } else if (dist < maxHeap.peek()[1]) {
                maxHeap.poll();
                maxHeap.offer(new int[] { i, dist });
            }
        }

        int[] result = new int[maxHeap.size()];
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            result[idx++] = maxHeap.poll()[0];
        }
        Arrays.sort(result);
        return result;
    }

    private static int squaredDist(int[] a, int[] b) {
        int dx = a[0] - b[0], dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}
