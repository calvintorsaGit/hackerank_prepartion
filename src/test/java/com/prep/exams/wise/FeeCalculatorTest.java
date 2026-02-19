package com.prep.exams.wise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeeCalculatorTest {

    @Test
    @DisplayName("Amount within first tier: 50 -> 0.25")
    void firstTier() {
        assertEquals(0.25, FeeCalculator.calculateFee(50));
    }

    @Test
    @DisplayName("Amount 1500: tiered fee = 5.60")
    void multiTier() {
        // 100*0.005 + 900*0.004 + 500*0.003 = 0.50 + 3.60 + 1.50 = 5.60
        assertEquals(5.60, FeeCalculator.calculateFee(1500));
    }

    @Test
    @DisplayName("Amount 0 -> 0 fee")
    void zeroAmount() {
        assertEquals(0, FeeCalculator.calculateFee(0));
    }

    @Test
    @DisplayName("Large amount uses all tiers")
    void largAmount() {
        // 100*0.005 + 900*0.004 + 9000*0.003 + 10000*0.002
        // = 0.50 + 3.60 + 27.00 + 20.00 = 51.10
        assertEquals(51.10, FeeCalculator.calculateFee(20000));
    }
}
