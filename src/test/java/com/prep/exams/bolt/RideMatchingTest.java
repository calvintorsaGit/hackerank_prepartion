package com.prep.exams.bolt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RideMatchingTest {

    @Test
    @DisplayName("Match 3 riders to 3 drivers: min total distance")
    void basicMatching() {
        int[] riders = { 1, 5, 10 };
        int[] drivers = { 2, 6, 9 };
        assertEquals(3, RideMatching.minimumTotalDistance(riders, drivers));
    }

    @Test
    @DisplayName("Unsorted input still gives optimal match")
    void unsortedInput() {
        int[] riders = { 10, 1, 5 };
        int[] drivers = { 9, 6, 2 };
        assertEquals(3, RideMatching.minimumTotalDistance(riders, drivers));
    }

    @Test
    @DisplayName("Same positions: 0 total distance")
    void samePositions() {
        int[] riders = { 3, 7 };
        int[] drivers = { 3, 7 };
        assertEquals(0, RideMatching.minimumTotalDistance(riders, drivers));
    }
}
