package com.prep.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSwapsTest {

    @Test
    @DisplayName("Sample: [7,1,3,2,4,5,6] -> 5 swaps")
    void sampleCase1() {
        assertEquals(5, MinimumSwaps.minimumSwaps(new int[] { 7, 1, 3, 2, 4, 5, 6 }));
    }

    @Test
    @DisplayName("Sample: [4,3,1,2] -> 3 swaps")
    void sampleCase2() {
        assertEquals(3, MinimumSwaps.minimumSwaps(new int[] { 4, 3, 1, 2 }));
    }

    @Test
    @DisplayName("Already sorted: 0 swaps")
    void alreadySorted() {
        assertEquals(0, MinimumSwaps.minimumSwaps(new int[] { 1, 2, 3, 4 }));
    }
}
