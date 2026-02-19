package com.prep.exams.bolt;

/**
 * Bolt Exam: Scooter Battery Optimizer
 *
 * Given N scooters with battery levels (0-100%) and a list of
 * trip distances (km), assign trips to scooters to maximize
 * the number of trips completed.
 *
 * Rules:
 * - Each scooter drains 5% battery per km
 * - A scooter can only take a trip if it has enough battery
 * - Each scooter can take multiple trips (battery keeps draining)
 *
 * HOW TO SOLVE:
 * 1. Convert battery % to available km: availableKm = battery / 5.
 * 2. Sort both arrays (trips ascending, scooters ascending).
 * - Why? Shortest trips are easiest to complete.
 * - Assign easy trips first to maximize count.
 * 3. For each trip (shortest first), scan scooters:
 * - Find the first scooter with enough range.
 * - Deduct the trip distance from that scooter's range.
 * - That scooter can still serve more trips with remaining range.
 * 4. Count how many trips were successfully assigned.
 *
 * Greedy insight: Always use the weakest capable scooter.
 * Save high-battery scooters for longer trips.
 *
 * Pattern: Greedy / Sort both arrays
 * Time: O(n log n + m log m + n*m) where n = scooters, m = trips
 * Space: O(n)
 */
public class ScooterBatteryOptimizer {

    private static final double DRAIN_PER_KM = 5.0;

    public static int maxTripsCompleted(int[] batteryLevels, int[] tripDistances) {
        // sort both: assign shortest trips first, to any scooter that can handle it
        java.util.Arrays.sort(batteryLevels);
        java.util.Arrays.sort(tripDistances);

        int completed = 0;
        // for each trip (shortest first), find a scooter that can take it
        // since trips are sorted ascending, greedily use the lowest-battery scooter
        // that works

        // convert battery to available km
        double[] availableKm = new double[batteryLevels.length];
        for (int i = 0; i < batteryLevels.length; i++) {
            availableKm[i] = batteryLevels[i] / DRAIN_PER_KM;
        }

        for (int tripDist : tripDistances) {
            // find first scooter with enough range
            for (int j = 0; j < availableKm.length; j++) {
                if (availableKm[j] >= tripDist) {
                    availableKm[j] -= tripDist;
                    completed++;
                    break;
                }
            }
        }
        return completed;
    }
}
