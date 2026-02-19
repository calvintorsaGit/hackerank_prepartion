package com.prep.hashmaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountTripletsTest {

    @Test
    @DisplayName("[1,2,2,4] r=2 -> 2 triplets")
    void sampleCase() {
        assertEquals(2, CountTriplets.countTriplets(List.of(1L, 2L, 2L, 4L), 2));
    }

    @Test
    @DisplayName("[1,3,9,9,27,81] r=3 -> 6 triplets")
    void sampleCase2() {
        assertEquals(6, CountTriplets.countTriplets(List.of(1L, 3L, 9L, 9L, 27L, 81L), 3));
    }

    @Test
    @DisplayName("[1,1,1,1] r=1 -> 4 triplets")
    void allOnesRatioOne() {
        assertEquals(4, CountTriplets.countTriplets(List.of(1L, 1L, 1L, 1L), 1));
    }
}
