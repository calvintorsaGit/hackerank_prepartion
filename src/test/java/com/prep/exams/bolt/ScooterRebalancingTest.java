package com.prep.exams.bolt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScooterRebalancingTest {

    @Test
    @DisplayName("[8,2,1,5] min=4 -> 5 moves needed")
    void sampleCase() {
        assertEquals(5, ScooterRebalancing.minimumMoves(new int[] { 8, 2, 1, 5 }, 4));
    }

    @Test
    @DisplayName("All zones already at minimum -> 0 moves")
    void noMovesNeeded() {
        assertEquals(0, ScooterRebalancing.minimumMoves(new int[] { 5, 6, 7 }, 5));
    }

    @Test
    @DisplayName("Single deficit zone")
    void singleDeficit() {
        assertEquals(3, ScooterRebalancing.minimumMoves(new int[] { 10, 2, 10 }, 5));
    }

    @Test
    @DisplayName("Rebalance plan produces correct moves")
    void rebalancePlan() {
        var plan = ScooterRebalancing.rebalancePlan(new int[] { 8, 2, 1, 5 }, 4);
        int totalMoved = plan.stream().mapToInt(m -> m[2]).sum();
        assertEquals(5, totalMoved);
    }
}
