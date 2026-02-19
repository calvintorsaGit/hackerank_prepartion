package com.prep.searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairsTest {

    @Test
    @DisplayName("k=2, [1,5,3,4,2] -> 3 pairs")
    void sampleCase() {
        assertEquals(3, Pairs.pairs(2, new int[] { 1, 5, 3, 4, 2 }));
    }

    @Test
    @DisplayName("k=1, [1,2,3] -> 2 pairs")
    void consecutive() {
        assertEquals(2, Pairs.pairs(1, new int[] { 1, 2, 3 }));
    }
}
