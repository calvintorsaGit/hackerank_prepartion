package com.prep.exams.bolt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NearestDriverTest {

    @Test
    @DisplayName("Find 2 nearest drivers out of 4")
    void findTwoNearest() {
        int[] passenger = { 0, 0 };
        int[][] drivers = { { 3, 3 }, { 1, 1 }, { 5, 5 }, { 2, 2 } };
        int[] result = NearestDriver.findNearest(passenger, drivers, 2);
        assertArrayEquals(new int[] { 1, 3 }, result); // indices of [1,1] and [2,2]
    }

    @Test
    @DisplayName("K equals number of drivers")
    void allDrivers() {
        int[] passenger = { 0, 0 };
        int[][] drivers = { { 1, 1 }, { 2, 2 } };
        int[] result = NearestDriver.findNearest(passenger, drivers, 2);
        assertArrayEquals(new int[] { 0, 1 }, result);
    }
}
