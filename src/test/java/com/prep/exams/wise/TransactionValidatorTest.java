package com.prep.exams.wise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionValidatorTest {

    @Test
    @DisplayName("All valid transactions")
    void allValid() {
        String[][] txs = {
                { "TX1", "Alice", "Bob", "100.00", "USD" },
                { "TX2", "Bob", "Charlie", "50.00", "EUR" }
        };
        assertEquals(2, TransactionValidator.countValid(txs));
    }

    @Test
    @DisplayName("Reject: duplicate ID, self-transfer, bad currency, negative amount")
    void rejectInvalid() {
        String[][] txs = {
                { "TX1", "Alice", "Bob", "100.00", "USD" }, // valid
                { "TX1", "Charlie", "Dave", "50.00", "EUR" }, // duplicate ID
                { "TX3", "Alice", "Alice", "10.00", "GBP" }, // self-transfer
                { "TX4", "Alice", "Bob", "10.00", "usd" }, // bad currency
                { "TX5", "Alice", "Bob", "-5.00", "USD" }, // negative amount
        };
        assertEquals(1, TransactionValidator.countValid(txs));
    }
}
