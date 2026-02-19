package com.prep.dynamicprogramming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxArraySumTest {

    @Test
    @DisplayName("[3,7,4,6,5] -> 13 (7+6)")
    void sampleCase() {
        assertEquals(13, MaxArraySum.maxSubsetSum(new int[] { 3, 7, 4, 6, 5 }));
    }

    @Test
    @DisplayName("[2,1,5,8,4] -> 11 (2+5+4)")
    void sampleCase2() {
        assertEquals(11, MaxArraySum.maxSubsetSum(new int[] { 2, 1, 5, 8, 4 }));
    }

    @Test
    @DisplayName("[-2,1,3,-4,5] -> 8 (3+5)")
    void withNegatives() {
        assertEquals(8, MaxArraySum.maxSubsetSum(new int[] { -2, 1, 3, -4, 5 }));
    }
}
