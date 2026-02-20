package com.prep.exams.bolt.practice;

/**
 * Bolt Exam: Fare Calculator
 *
 * Calculate ride fare with these rules:
 * - Base fare: 2.50
 * - Per km: 1.20
 * - Per minute: 0.30
 * - Minimum fare: 5.00
 * - Surge multiplier applies to distance and time only (not base fare)
 * - Long trip discount: 10% off total for trips > 20 km (after surge)
 * - Minimum fare enforced LAST
 *
 * Return fare rounded to 2 decimal places.
 * Throw IllegalArgumentException for negative inputs or surge < 1.0.
 *
 * Example:
 * distance=10, duration=15, surge=1.0
 * Output: 19.0 (2.50 + 10*1.20 + 15*0.30)
 *
 * distance=25, duration=30, surge=1.0
 * Output: 37.35 (41.50 * 0.90 = 37.35, long trip discount)
 */
public class FareCalculatorPractice {

    public static double calculateFare(double distanceKm, double durationMin, double surgeMultiplier) {
        // YOUR SOLUTION HERE
        return 0;
    }
}
