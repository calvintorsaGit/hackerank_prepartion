package com.prep.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    @DisplayName("[6,4,1] -> 3 swaps")
    void sampleCase() {
        assertEquals(3, BubbleSort.bubbleSort(new int[] { 6, 4, 1 }));
    }

    @Test
    @DisplayName("Already sorted -> 0 swaps")
    void alreadySorted() {
        assertEquals(0, BubbleSort.bubbleSort(new int[] { 1, 2, 3 }));
    }
}
