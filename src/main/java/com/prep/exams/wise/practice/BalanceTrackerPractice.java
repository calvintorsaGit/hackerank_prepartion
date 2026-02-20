package com.prep.exams.wise.practice;

import java.util.Map;

/**
 * Wise Exam: Balance Tracker
 *
 * Track account balances across multiple currencies.
 * Process these operations:
 *
 * DEPOSIT: ["DEPOSIT", account, amount, currency]
 * WITHDRAW: ["WITHDRAW", account, amount, currency]
 * TRANSFER: ["TRANSFER", fromAccount, toAccount, amount, currency]
 *
 * Rules:
 * - Withdrawals that exceed balance are REJECTED (balance unchanged).
 * - Transfers that exceed sender balance are REJECTED.
 *
 * Return: Map of "account:currency" -> final balance.
 *
 * Example:
 * ops = [["DEPOSIT","Alice","500","EUR"],
 * ["TRANSFER","Alice","Bob","200","EUR"]]
 * Output: {"Alice:EUR": 300.0, "Bob:EUR": 200.0}
 */
public class BalanceTrackerPractice {

    public static Map<String, Double> processOperations(String[][] operations) {
        // YOUR SOLUTION HERE
        return Map.of();
    }
}
