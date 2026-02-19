package com.prep.searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumTimeRequiredTest {

    @Test
    @DisplayName("machines=[2,3] goal=5 -> 6 days")
    void sampleCase() {
        assertEquals(6, MinimumTimeRequired.minTime(new long[] { 2, 3 }, 5));
    }

    @Test
    @DisplayName("machines=[1,3,4] goal=10 -> 7 days")
    void sampleCase2() {
        assertEquals(7, MinimumTimeRequired.minTime(new long[] { 1, 3, 4 }, 10));
    }
}
