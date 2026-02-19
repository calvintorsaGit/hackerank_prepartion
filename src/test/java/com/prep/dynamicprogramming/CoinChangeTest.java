package com.prep.dynamicprogramming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    @DisplayName("amount=4 coins=[1,2,3] -> 4 ways")
    void sampleCase() {
        assertEquals(4, CoinChange.getWays(4, new int[] { 1, 2, 3 }));
    }

    @Test
    @DisplayName("amount=10 coins=[2,5,3,6] -> 5 ways")
    void sampleCase2() {
        assertEquals(5, CoinChange.getWays(10, new int[] { 2, 5, 3, 6 }));
    }

    @Test
    @DisplayName("amount=0 -> 1 way (use nothing)")
    void amountZero() {
        assertEquals(1, CoinChange.getWays(0, new int[] { 1, 2 }));
    }
}
