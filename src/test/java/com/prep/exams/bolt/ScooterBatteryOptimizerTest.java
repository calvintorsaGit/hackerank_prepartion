package com.prep.exams.bolt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScooterBatteryOptimizerTest {

    @Test
    @DisplayName("3 scooters, 4 trips -> max completable")
    void sampleCase() {
        // batteries: [50, 80, 30] -> available km: [10, 16, 6]
        // trips sorted: [2, 3, 5, 8]
        // trip 2km: scooter[2](6km) -> 4km left
        // trip 3km: scooter[2](4km) -> 1km left
        // trip 5km: scooter[0](10km) -> 5km left
        // trip 8km: scooter[1](16km) -> 8km left
        assertEquals(4, ScooterBatteryOptimizer.maxTripsCompleted(
                new int[] { 50, 80, 30 }, new int[] { 5, 3, 8, 2 }));
    }

    @Test
    @DisplayName("All scooters dead -> 0 trips")
    void noCharge() {
        assertEquals(0, ScooterBatteryOptimizer.maxTripsCompleted(
                new int[] { 0, 0 }, new int[] { 1, 2 }));
    }

    @Test
    @DisplayName("Trips too long for any scooter")
    void tripsToLong() {
        // batteries: [20, 30] -> available km: [4, 6]
        // trips: [10, 15] -> neither scooter can handle
        assertEquals(0, ScooterBatteryOptimizer.maxTripsCompleted(
                new int[] { 20, 30 }, new int[] { 10, 15 }));
    }
}
