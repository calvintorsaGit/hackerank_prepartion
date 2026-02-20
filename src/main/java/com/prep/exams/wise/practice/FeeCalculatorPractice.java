package com.prep.exams.wise.practice;

/**
 * Wise Exam: Fee Calculator
 *
 * Calculate transfer fee using tiered (cumulative) pricing:
 * - First 100: 0.5% fee
 * - Next 900: 0.4% fee (101 - 1000)
 * - Next 9000: 0.3% fee (1001 - 10000)
 * - Above 10000: 0.2% fee
 *
 * Tiers are cumulative — each range uses only its own rate.
 * Return fee rounded to 2 decimal places.
 * If amount <= 0, return 0.
 *
 * Example:
 * amount = 1500
 * fee = 100*0.005 + 900*0.004 + 500*0.003
 * = 0.50 + 3.60 + 1.50 = 5.60
 */
public class FeeCalculatorPractice {

    public static double calculateFee(double amount) {
        // YOUR SOLUTION HERE
        return 0;
    }
}
