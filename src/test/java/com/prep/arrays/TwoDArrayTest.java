package com.prep.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoDArrayTest {

    @Test
    @DisplayName("Sample: max hourglass sum = 19")
    void sampleCase() {
        int[][] arr = {
                { 1, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0 },
                { 0, 0, 2, 4, 4, 0 },
                { 0, 0, 0, 2, 0, 0 },
                { 0, 0, 1, 2, 4, 0 }
        };
        assertEquals(19, TwoDArray.hourglassSum(arr));
    }

    @Test
    @DisplayName("All negatives: max hourglass sum = -6")
    void allNegatives() {
        int[][] arr = {
                { -1, -1, 0, -9, -2, -2 },
                { -2, -1, -6, -8, -2, -5 },
                { -1, -1, -1, -2, -3, -4 },
                { -1, -9, -2, -4, -4, -5 },
                { -7, -3, -3, -2, -9, -9 },
                { -1, -3, -1, -2, -4, -5 }
        };
        assertEquals(-6, TwoDArray.hourglassSum(arr));
    }
}
