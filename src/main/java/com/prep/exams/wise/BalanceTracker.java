package com.prep.exams.wise;

import java.util.HashMap;
import java.util.Map;

/**
 * Wise Exam: Balance Tracker
 *
 * Track account balances across multiple currencies.
 * Process operations: DEPOSIT, WITHDRAW, TRANSFER.
 *
 * Operations format: [type, account, amount, currency]
 * Transfer format: [TRANSFER, from, to, amount, currency]
 *
 * Return final balances as a map: "account:currency" -> balance.
 * Withdrawals/transfers that exceed balance should be rejected.
 *
 * Pattern: HashMap for balance tracking
 *
 * Time: O(n) for n operations
 * Space: O(accounts * currencies)
 */
public class BalanceTracker {

    public static Map<String, Double> processOperations(String[][] operations) {
        Map<String, Double> balances = new HashMap<>();

        for (String[] op : operations) {
            String type = op[0];

            switch (type) {
                case "DEPOSIT" -> {
                    String account = op[1];
                    double amount = Double.parseDouble(op[2]);
                    String currency = op[3];
                    String key = account + ":" + currency;
                    balances.merge(key, amount, Double::sum);
                }
                case "WITHDRAW" -> {
                    String account = op[1];
                    double amount = Double.parseDouble(op[2]);
                    String currency = op[3];
                    String key = account + ":" + currency;
                    double current = balances.getOrDefault(key, 0.0);
                    if (current >= amount) {
                        balances.put(key, current - amount);
                    }
                    // else: rejected (insufficient funds)
                }
                case "TRANSFER" -> {
                    String from = op[1];
                    String to = op[2];
                    double amount = Double.parseDouble(op[3]);
                    String currency = op[4];
                    String fromKey = from + ":" + currency;
                    String toKey = to + ":" + currency;
                    double current = balances.getOrDefault(fromKey, 0.0);
                    if (current >= amount) {
                        balances.put(fromKey, current - amount);
                        balances.merge(toKey, amount, Double::sum);
                    }
                }
            }
        }
        return balances;
    }
}
