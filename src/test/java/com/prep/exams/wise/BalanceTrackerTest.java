package com.prep.exams.wise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTrackerTest {

    @Test
    @DisplayName("Deposit and withdraw")
    void depositWithdraw() {
        String[][] ops = {
                { "DEPOSIT", "Alice", "1000", "USD" },
                { "WITHDRAW", "Alice", "300", "USD" },
        };
        Map<String, Double> balances = BalanceTracker.processOperations(ops);
        assertEquals(700.0, balances.get("Alice:USD"));
    }

    @Test
    @DisplayName("Transfer between accounts")
    void transfer() {
        String[][] ops = {
                { "DEPOSIT", "Alice", "500", "EUR" },
                { "TRANSFER", "Alice", "Bob", "200", "EUR" },
        };
        Map<String, Double> balances = BalanceTracker.processOperations(ops);
        assertEquals(300.0, balances.get("Alice:EUR"));
        assertEquals(200.0, balances.get("Bob:EUR"));
    }

    @Test
    @DisplayName("Reject withdrawal exceeding balance")
    void insufficientFunds() {
        String[][] ops = {
                { "DEPOSIT", "Alice", "100", "USD" },
                { "WITHDRAW", "Alice", "200", "USD" }, // rejected
        };
        Map<String, Double> balances = BalanceTracker.processOperations(ops);
        assertEquals(100.0, balances.get("Alice:USD"));
    }
}
