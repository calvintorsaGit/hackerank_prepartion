package com.prep.searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarraySumTest {

    @Test
    @DisplayName("[3,3,9,9,5] m=7 -> 6")
    void sampleCase() {
        assertEquals(6, MaximumSubarraySum.maximumSum(new long[] { 3, 3, 9, 9, 5 }, 7));
    }

    @Test
    @DisplayName("[1,2,3] m=2 -> 1")
    void smallMod() {
        assertEquals(1, MaximumSubarraySum.maximumSum(new long[] { 1, 2, 3 }, 2));
    }
}
