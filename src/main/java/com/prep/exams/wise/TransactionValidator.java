package com.prep.exams.wise;

import java.util.HashMap;
import java.util.Map;

/**
 * Wise Exam: Transaction Validator
 *
 * Validate a batch of money transfer transactions.
 * A transaction is valid if:
 * 1. Amount > 0
 * 2. Currency code is exactly 3 uppercase letters
 * 3. Sender and receiver are different
 * 4. No duplicate transaction IDs in the batch
 *
 * Return count of valid transactions.
 *
 * Pattern: String validation + HashMap for duplicate detection
 *
 * Time: O(n)
 * Space: O(n)
 */
public class TransactionValidator {

    public static int countValid(String[][] transactions) {
        // each transaction: [id, sender, receiver, amount, currency]
        Map<String, Boolean> seenIds = new HashMap<>();
        int valid = 0;

        for (String[] tx : transactions) {
            if (tx.length != 5)
                continue;

            String id = tx[0];
            String sender = tx[1];
            String receiver = tx[2];
            String amountStr = tx[3];
            String currency = tx[4];

            // check duplicate ID
            if (seenIds.containsKey(id))
                continue;
            seenIds.put(id, true);

            // check sender != receiver
            if (sender.equals(receiver))
                continue;

            // check amount > 0
            try {
                double amount = Double.parseDouble(amountStr);
                if (amount <= 0)
                    continue;
            } catch (NumberFormatException e) {
                continue;
            }

            // check currency: exactly 3 uppercase letters
            if (!isValidCurrency(currency))
                continue;

            valid++;
        }
        return valid;
    }

    private static boolean isValidCurrency(String currency) {
        if (currency == null || currency.length() != 3)
            return false;
        for (char c : currency.toCharArray()) {
            if (c < 'A' || c > 'Z')
                return false;
        }
        return true;
    }
}
