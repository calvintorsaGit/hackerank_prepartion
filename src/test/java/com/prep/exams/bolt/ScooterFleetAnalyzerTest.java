package com.prep.exams.bolt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScooterFleetAnalyzerTest {

    // trips: [startHour, startZone, endZone, durationMinutes]
    private static final int[][] TRIPS = {
            { 8, 1, 2, 12 },
            { 8, 1, 3, 15 },
            { 9, 2, 1, 10 },
            { 8, 1, 2, 8 },
            { 17, 3, 1, 20 },
            { 17, 3, 1, 18 },
    };

    @Test
    @DisplayName("Peak hour is 8 (3 trips)")
    void peakHour() {
        assertEquals(8, ScooterFleetAnalyzer.peakHour(TRIPS));
    }

    @Test
    @DisplayName("Most popular route is 1->2")
    void mostPopularRoute() {
        assertEquals("1->2", ScooterFleetAnalyzer.mostPopularRoute(TRIPS));
    }

    @Test
    @DisplayName("Average duration = 13.8 min")
    void averageDuration() {
        // (12+15+10+8+20+18)/6 = 83/6 = 13.8
        assertEquals(13.8, ScooterFleetAnalyzer.averageDuration(TRIPS));
    }

    @Test
    @DisplayName("Empty trips -> 0 average")
    void emptyTrips() {
        assertEquals(0, ScooterFleetAnalyzer.averageDuration(new int[][] {}));
    }
}
