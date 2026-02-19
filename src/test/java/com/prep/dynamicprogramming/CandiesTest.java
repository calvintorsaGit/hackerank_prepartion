package com.prep.dynamicprogramming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandiesTest {

    @Test
    @DisplayName("ratings [1,2,2] -> 4 candies")
    void sampleCase() {
        assertEquals(4, Candies.candies(3, new int[] { 1, 2, 2 }));
    }

    @Test
    @DisplayName("ratings [2,4,2,6,1,7,8,9,2,1] -> 19 candies")
    void sampleCase2() {
        assertEquals(19, Candies.candies(10, new int[] { 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 }));
    }

    @Test
    @DisplayName("All equal ratings -> n candies")
    void allEqual() {
        assertEquals(4, Candies.candies(4, new int[] { 3, 3, 3, 3 }));
    }
}
