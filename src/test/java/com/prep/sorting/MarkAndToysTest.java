package com.prep.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkAndToysTest {

    @Test
    @DisplayName("Budget 50, prices [1,12,5,111,200,1000,10] -> 4 toys")
    void sampleCase() {
        assertEquals(4, MarkAndToys.maximumToys(new int[] { 1, 12, 5, 111, 200, 1000, 10 }, 50));
    }

    @Test
    @DisplayName("Budget too small for any toy")
    void noToys() {
        assertEquals(0, MarkAndToys.maximumToys(new int[] { 100, 200 }, 50));
    }
}
