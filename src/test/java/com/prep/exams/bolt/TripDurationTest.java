package com.prep.exams.bolt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripDurationTest {

    @Test
    @DisplayName("Shortest path: 0 -> 3 through graph")
    void shortestPath() {
        // Graph: 0--1--3, 0--2--3
        // (2)(3) (4)(1)
        int[][] edges = { { 0, 1, 2 }, { 1, 3, 3 }, { 0, 2, 4 }, { 2, 3, 1 } };
        assertEquals(5, TripDuration.shortestTime(4, edges, 0, 3)); // 0->1->3 = 5
    }

    @Test
    @DisplayName("Unreachable destination returns -1")
    void unreachable() {
        int[][] edges = { { 0, 1, 5 } };
        assertEquals(-1, TripDuration.shortestTime(3, edges, 0, 2));
    }

    @Test
    @DisplayName("Same source and target: 0")
    void sameNode() {
        int[][] edges = { { 0, 1, 5 } };
        assertEquals(0, TripDuration.shortestTime(2, edges, 0, 0));
    }
}
