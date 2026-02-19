package com.prep.searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripleSumTest {

    @Test
    @DisplayName("a=[1,3,5] b=[2,3] c=[1,2,3] -> 8 triplets")
    void sampleCase() {
        assertEquals(8, TripleSum.triplets(new int[] { 1, 3, 5 }, new int[] { 2, 3 }, new int[] { 1, 2, 3 }));
    }
}
