package com.prep.exams.bolt;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Bolt Exam: Scooter Maintenance Scheduler
 *
 * Each scooter has a mileage and a maintenance threshold.
 * When mileage >= threshold, the scooter needs servicing.
 * Only one technician is available, servicing takes fixTime minutes.
 *
 * Given scooter arrival times (when they hit threshold) and fixTime,
 * find the average wait time for all scooters.
 *
 * HOW TO SOLVE (Single technician):
 * 1. Sort arrival times (process in chronological order).
 * 2. Track currentTime = when technician finishes current job.
 * 3. For each scooter:
 * - startService = max(currentTime, arrival) // wait if tech busy
 * - endService = startService + fixTime
 * - waitTime = endService - arrival // total time scooter waited
 * - Update currentTime = endService
 * 4. Average = totalWait / n.
 *
 * HOW TO SOLVE (K technicians):
 * 1. Use a min-heap of size K, tracking when each tech is free.
 * 2. For each arriving scooter, poll the earliest-free tech.
 * 3. Same calculation as above, then push endService back.
 * 4. The heap always gives the next-available technician.
 *
 * This is a classic "single/multi server queue" simulation.
 *
 * Pattern: Sorting + Simulation (single), Heap (multi)
 * Time: O(n log n)
 * Space: O(k) for K technicians
 */
public class ScooterMaintenanceScheduler {

    /**
     * @param arrivalTimes when each scooter needs maintenance (sorted or unsorted)
     * @param fixTime      minutes to fix one scooter
     * @return average wait time (rounded to 2 decimals)
     */
    public static double averageWaitTime(int[] arrivalTimes, int fixTime) {
        Arrays.sort(arrivalTimes);

        long totalWait = 0;
        int currentTime = 0;

        for (int arrival : arrivalTimes) {
            // technician becomes available at currentTime
            int startService = Math.max(currentTime, arrival);
            int endService = startService + fixTime;
            int waitTime = endService - arrival;

            totalWait += waitTime;
            currentTime = endService;
        }

        return Math.round((double) totalWait / arrivalTimes.length * 100.0) / 100.0;
    }

    /**
     * With K technicians available.
     * Use a min-heap to track when each technician becomes free.
     */
    public static double averageWaitTimeKTechs(int[] arrivalTimes, int fixTime, int k) {
        Arrays.sort(arrivalTimes);

        // min-heap: tracks when each technician becomes free
        PriorityQueue<Integer> techFree = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            techFree.offer(0);

        long totalWait = 0;

        for (int arrival : arrivalTimes) {
            int earliest = techFree.poll();
            int startService = Math.max(earliest, arrival);
            int endService = startService + fixTime;

            totalWait += (endService - arrival);
            techFree.offer(endService);
        }

        return Math.round((double) totalWait / arrivalTimes.length * 100.0) / 100.0;
    }
}
