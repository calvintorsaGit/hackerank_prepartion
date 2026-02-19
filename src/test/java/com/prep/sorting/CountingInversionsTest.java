package com.prep.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingInversionsTest {

    @Test
    @DisplayName("[2,1,3,1,2] -> 4 inversions")
    void sampleCase() {
        assertEquals(4, CountingInversions.countInversions(new int[] { 2, 1, 3, 1, 2 }));
    }

    @Test
    @DisplayName("[1,1,1,2,2] -> 0 inversions")
    void alreadySorted() {
        assertEquals(0, CountingInversions.countInversions(new int[] { 1, 1, 1, 2, 2 }));
    }

    @Test
    @DisplayName("[5,4,3,2,1] -> 10 inversions (reverse sorted)")
    void reverseSorted() {
        assertEquals(10, CountingInversions.countInversions(new int[] { 5, 4, 3, 2, 1 }));
    }
}
