package com.prep.exams.bolt;

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
 *
 * HOW TO SOLVE:
 * 1. Compute ratio = requests / drivers for each zone.
 * 2. Handle edge case: drivers == 0 -> return max surge (5.0).
 * 3. Use if-else chain for each tier (like tax bracket calculation).
 * - Each tier has a base value + linear growth within its range.
 * - The base of each tier = the max of the previous tier.
 * 4. Cap the result at 5.0 (business max).
 * 5. Round to 2 decimal places using Math.round(x * 100) / 100.
 *
 * Key trick: Think of it as piecewise linear function.
 * Draw it: x-axis = ratio, y-axis = multiplier.
 * It's a series of line segments with different slopes.
 *
 * Pattern: Math / Tiered calculation (same as tax brackets)
 * Time: O(n)
 * Space: O(n)
 */
public class SurgePricing {

    public static double[] calculateSurge(int[] requests, int[] drivers) {
        double[] result = new double[requests.length];

        for (int i = 0; i < requests.length; i++) {
            if (drivers[i] == 0) {
                result[i] = 5.0; // max surge if no drivers
            } else {
                double ratio = (double) requests[i] / drivers[i];
                result[i] = computeMultiplier(ratio);
            }
        }
        return result;
    }

    private static double computeMultiplier(double ratio) {
        double multiplier;

        if (ratio <= 1.0) {
            multiplier = 1.0;
        } else if (ratio <= 2.0) {
            multiplier = 1.0 + (ratio - 1.0) * 0.5;
        } else if (ratio <= 3.0) {
            multiplier = 1.5 + (ratio - 2.0) * 0.75;
        } else {
            multiplier = 2.25 + (ratio - 3.0) * 0.25;
        }

        return Math.round(Math.min(multiplier, 5.0) * 100.0) / 100.0;
    }
}
