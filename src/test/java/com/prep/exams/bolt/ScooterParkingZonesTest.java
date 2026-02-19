package com.prep.exams.bolt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScooterParkingZonesTest {

    @Test
    @DisplayName("Find top 2 hotspot zones from 5 points")
    void topTwoZones() {
        int[][] points = { { 1, 2 }, { 1, 3 }, { 5, 5 }, { 5, 6 }, { 9, 1 } };
        int[][] result = ScooterParkingZones.topKZones(points, 3, 2);
        assertEquals(2, result.length);
    }

    @Test
    @DisplayName("All points in same cell -> 1 zone")
    void singleCell() {
        int[][] points = { { 0, 0 }, { 1, 1 }, { 2, 2 } };
        int[][] result = ScooterParkingZones.topKZones(points, 5, 1);
        assertEquals(1, result.length);
        assertArrayEquals(new int[] { 0, 0 }, result[0]);
    }

    @Test
    @DisplayName("K larger than unique cells returns all cells")
    void kLargerThanCells() {
        int[][] points = { { 0, 0 }, { 10, 10 } };
        int[][] result = ScooterParkingZones.topKZones(points, 5, 5);
        assertEquals(2, result.length);
    }
}
