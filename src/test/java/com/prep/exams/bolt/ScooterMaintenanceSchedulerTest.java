package com.prep.exams.bolt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScooterMaintenanceSchedulerTest {

    @Test
    @DisplayName("Sequential arrivals, fixTime=10")
    void sequential() {
        // arrivals: [0, 5, 10], fixTime=10
        // scooter0: start=0, end=10, wait=10
        // scooter1: start=10, end=20, wait=15 (arrived at 5, served at 10)
        // scooter2: start=20, end=30, wait=20 (arrived at 10, served at 20)
        // avg = (10+15+20)/3 = 15.0
        assertEquals(15.0, ScooterMaintenanceScheduler.averageWaitTime(
                new int[] { 0, 5, 10 }, 10));
    }

    @Test
    @DisplayName("No overlap: each finishes before next arrives")
    void noOverlap() {
        // arrivals: [0, 20, 40], fixTime=5
        // wait per scooter = fixTime = 5
        assertEquals(5.0, ScooterMaintenanceScheduler.averageWaitTime(
                new int[] { 0, 20, 40 }, 5));
    }

    @Test
    @DisplayName("K technicians reduce wait time")
    void multipleTechs() {
        // arrivals: [0, 0, 0], fixTime=10, k=3
        // all 3 served immediately, wait = 10 each
        assertEquals(10.0, ScooterMaintenanceScheduler.averageWaitTimeKTechs(
                new int[] { 0, 0, 0 }, 10, 3));
    }

    @Test
    @DisplayName("K=1 same as single tech")
    void singleTech() {
        double single = ScooterMaintenanceScheduler.averageWaitTime(new int[] { 0, 5, 10 }, 10);
        double kOne = ScooterMaintenanceScheduler.averageWaitTimeKTechs(new int[] { 0, 5, 10 }, 10, 1);
        assertEquals(single, kOne);
    }
}
