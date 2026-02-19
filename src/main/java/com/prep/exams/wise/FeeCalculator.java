package com.prep.exams.wise;

/**
 * Wise Exam: Fee Calculator
 *
 * Calculate transfer fee based on tiered pricing:
 * - First 100: 0.5% fee
 * - Next 900: 0.4% fee (101 - 1000)
 * - Next 9000: 0.3% fee (1001 - 10000)
 * - Above 10000: 0.2% fee
 *
 * Fees are cumulative (each tier applies to its range only).
 *
 * Example: amount = 1500
 * fee = 100*0.005 + 900*0.004 + 500*0.003
 * = 0.50 + 3.60 + 1.50 = 5.60
 *
 * Pattern: Tiered calculation (similar to tax bracket problems)
 *
 * Time: O(1) — fixed number of tiers
 * Space: O(1)
 */
public class FeeCalculator {

    private static final double[][] TIERS = {
            { 100, 0.005 }, // first 100 at 0.5%
            { 1000, 0.004 }, // up to 1000 at 0.4%
            { 10000, 0.003 }, // up to 10000 at 0.3%
            { Double.MAX_VALUE, 0.002 } // above 10000 at 0.2%
    };

    public static double calculateFee(double amount) {
        if (amount <= 0)
            return 0;

        double fee = 0;
        double prev = 0;

        for (double[] tier : TIERS) {
            double limit = tier[0];
            double rate = tier[1];

            if (amount <= prev)
                break;

            double taxable = Math.min(amount, limit) - prev;
            fee += taxable * rate;
            prev = limit;
        }

        // round to 2 decimal places
        return Math.round(fee * 100.0) / 100.0;
    }
}
