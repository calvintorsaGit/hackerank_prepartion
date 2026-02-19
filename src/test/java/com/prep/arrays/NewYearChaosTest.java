package com.prep.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewYearChaosTest {

    @Test
    @DisplayName("Sample: [2,1,5,3,4] -> 3 bribes")
    void sampleCase() {
        assertEquals("3", NewYearChaos.minimumBribes(new int[] { 2, 1, 5, 3, 4 }));
    }

    @Test
    @DisplayName("Too chaotic: [2,5,1,3,4]")
    void tooChaotic() {
        assertEquals("Too chaotic", NewYearChaos.minimumBribes(new int[] { 2, 5, 1, 3, 4 }));
    }

    @Test
    @DisplayName("Already sorted: 0 bribes")
    void alreadySorted() {
        assertEquals("0", NewYearChaos.minimumBribes(new int[] { 1, 2, 3, 4, 5 }));
    }
}
