package com.prep.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayManipulationTest {

    @Test
    @DisplayName("Sample: n=5, 3 queries -> max = 200")
    void sampleCase() {
        int[][] queries = { { 1, 2, 100 }, { 2, 5, 100 }, { 3, 4, 100 } };
        assertEquals(200, ArrayManipulation.arrayManipulation(5, queries));
    }

    @Test
    @DisplayName("Single query")
    void singleQuery() {
        int[][] queries = { { 2, 3, 50 } };
        assertEquals(50, ArrayManipulation.arrayManipulation(5, queries));
    }

    @Test
    @DisplayName("Large values: n=10, overlapping ranges")
    void overlapping() {
        int[][] queries = { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } };
        assertEquals(10, ArrayManipulation.arrayManipulation(10, queries));
    }
}
