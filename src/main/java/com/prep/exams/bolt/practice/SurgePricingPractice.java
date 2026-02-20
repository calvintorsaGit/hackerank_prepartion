package com.prep.exams.bolt.practice;

/**
 * Bolt Exam: Surge Pricing
 *
 * Calculate surge multiplier based on supply and demand in a zone.
 *
 * Rules:
 * - ratio = requests / availableDrivers
 * - ratio <= 1.0: multiplier = 1.0 (no surge)
 * - ratio <= 2.0: multiplier = 1.0 + (ratio - 1.0) * 0.5
 * - ratio <= 3.0: multiplier = 1.5 + (ratio - 2.0) * 0.75
 * - ratio > 3.0: multiplier = min(2.25 + (ratio - 3.0) * 0.25, 5.0)
 * - If drivers == 0, return 5.0 (max surge)
 *
 * Return surge multiplier for each zone, rounded to 2 decimals.
 *
 * Example:
 * requests = [5, 20, 30], drivers = [10, 10, 10]
 * Output: [1.0, 1.5, 2.25]
 */
public class SurgePricingPractice {

    public static double[] calculateSurge(int[] requests, int[] drivers) {
        // YOUR SOLUTION HERE
        return new double[] {};
    }
}
