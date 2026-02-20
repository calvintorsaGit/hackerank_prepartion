package com.prep.exams.wise.practice;

/**
 * Wise Exam: Transaction Validator
 *
 * Validate a batch of money transfer transactions.
 * Each transaction: [id, sender, receiver, amount, currency]
 *
 * A transaction is VALID if ALL conditions are met:
 * 1. Has exactly 5 fields
 * 2. Amount is a positive number (> 0)
 * 3. Currency code is exactly 3 uppercase letters (e.g. "USD", "EUR")
 * 4. Sender and receiver are different
 * 5. No duplicate transaction IDs in the batch
 *
 * Return the count of valid transactions.
 *
 * Example:
 * [["TX1","Alice","Bob","100.00","USD"], -> valid
 * ["TX1","Eve","Dave","50.00","EUR"], -> invalid (duplicate ID)
 * ["TX3","Alice","Alice","10.00","GBP"]] -> invalid (self-transfer)
 * Output: 1
 */
public class TransactionValidatorPractice {

    public static int countValid(String[][] transactions) {
        // YOUR SOLUTION HERE
        return 0;
    }
}
