package com.prep.exams.bolt;

/**
 * Bolt Exam: Fare Calculator
 *
 * Calculate ride fare based on:
 * - Base fare: 2.50
 * - Per km: 1.20
 * - Per minute: 0.30
 * - Minimum fare: 5.00
 * - Surge multiplier applies to distance and time charges only (not base)
 * - Long trip discount: 10% off for trips > 20 km (applied after surge)
 *
 * HOW TO SOLVE:
 * 1. Validate inputs (no negatives, surge >= 1.0).
 * 2. Calculate each component separately:
 * - distCharge = km * perKmRate * surge
 * - timeCharge = min * perMinRate * surge
 * - fare = baseFare + distCharge + timeCharge
 * 3. Apply discounts IN ORDER (order matters!):
 * - Long trip discount AFTER surge (discount the surged price).
 * 4. Enforce minimum fare LAST (even after discounts).
 * 5. Round to 2 decimal places.
 *
 * Key pitfall: Order of operations matters.
 * surge -> discount -> minimum fare (not the other way around).
 *
 * Pattern: Math with business rules and edge cases
 * Time: O(1)
 * Space: O(1)
 */
public class FareCalculator {

    private static final double BASE_FARE = 2.50;
    private static final double PER_KM = 1.20;
    private static final double PER_MINUTE = 0.30;
    private static final double MIN_FARE = 5.00;
    private static final double LONG_TRIP_KM = 20.0;
    private static final double LONG_TRIP_DISCOUNT = 0.10;

    public static double calculateFare(double distanceKm, double durationMin, double surgeMultiplier) {
        if (distanceKm < 0 || durationMin < 0 || surgeMultiplier < 1.0) {
            throw new IllegalArgumentException("Invalid input");
        }

        double distCharge = distanceKm * PER_KM * surgeMultiplier;
        double timeCharge = durationMin * PER_MINUTE * surgeMultiplier;
        double fare = BASE_FARE + distCharge + timeCharge;

        // long trip discount
        if (distanceKm > LONG_TRIP_KM) {
            fare *= (1 - LONG_TRIP_DISCOUNT);
        }

        // enforce minimum
        fare = Math.max(fare, MIN_FARE);

        return Math.round(fare * 100.0) / 100.0;
    }
}
