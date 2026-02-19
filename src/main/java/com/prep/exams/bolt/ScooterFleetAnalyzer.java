package com.prep.exams.bolt;

import java.util.*;

/**
 * Bolt Exam: Scooter Fleet Analyzer
 *
 * Analyze scooter trip data to find:
 * 1. Peak usage hour (0-23)
 * 2. Most popular route (start zone -> end zone)
 * 3. Average trip duration
 *
 * Input: trips as [startHour, startZone, endZone, durationMinutes]
 *
 * HOW TO SOLVE:
 * 1. Peak hour: Use int[24] frequency array.
 * - Increment hourCount[trip.startHour] for each trip.
 * - Linear scan to find max. On tie, pick earlier hour.
 * - Why array over HashMap? Fixed size (24), faster, no boxing.
 *
 * 2. Most popular route: Use HashMap<String, Integer>.
 * - Key = "startZone->endZone", value = count.
 * - Use merge() for clean counting: map.merge(key, 1, Integer::sum).
 * - Stream to find max entry, or iterate manually.
 *
 * 3. Average duration: Simple sum / count.
 * - Use long for sum to avoid overflow.
 * - Handle empty input: return 0.
 *
 * These are all O(n) single-pass aggregations — common in data
 * processing interviews for companies that handle large datasets.
 *
 * Pattern: HashMap frequency counting / Array counting
 * Time: O(n)
 * Space: O(n) for route map, O(1) for hour array
 */
public class ScooterFleetAnalyzer {

    /**
     * Find the hour (0-23) with the most trip starts.
     * If tie, return the earlier hour.
     */
    public static int peakHour(int[][] trips) {
        int[] hourCount = new int[24];
        for (int[] trip : trips) {
            hourCount[trip[0]]++;
        }

        int maxHour = 0;
        for (int h = 1; h < 24; h++) {
            if (hourCount[h] > hourCount[maxHour]) {
                maxHour = h;
            }
        }
        return maxHour;
    }

    /**
     * Find the most popular route as "startZone->endZone".
     */
    public static String mostPopularRoute(int[][] trips) {
        Map<String, Integer> routeCount = new HashMap<>();

        for (int[] trip : trips) {
            String route = trip[1] + "->" + trip[2];
            routeCount.merge(route, 1, Integer::sum);
        }

        return routeCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    /**
     * Calculate average trip duration in minutes (rounded to 1 decimal).
     */
    public static double averageDuration(int[][] trips) {
        if (trips.length == 0)
            return 0;

        long total = 0;
        for (int[] trip : trips) {
            total += trip[3];
        }
        return Math.round((double) total / trips.length * 10.0) / 10.0;
    }
}
