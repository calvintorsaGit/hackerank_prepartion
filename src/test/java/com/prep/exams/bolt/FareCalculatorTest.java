package com.prep.exams.bolt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FareCalculatorTest {

    @Test
    @DisplayName("Normal ride: 10km, 15min, no surge")
    void normalRide() {
        // 2.50 + 10*1.20 + 15*0.30 = 2.50 + 12.00 + 4.50 = 19.00
        assertEquals(19.0, FareCalculator.calculateFare(10, 15, 1.0));
    }

    @Test
    @DisplayName("Surge ride: 10km, 15min, 2x surge")
    void surgeRide() {
        // 2.50 + 10*1.20*2 + 15*0.30*2 = 2.50 + 24.00 + 9.00 = 35.50
        assertEquals(35.5, FareCalculator.calculateFare(10, 15, 2.0));
    }

    @Test
    @DisplayName("Long trip discount: 25km")
    void longTripDiscount() {
        // 2.50 + 25*1.20 + 30*0.30 = 2.50 + 30.00 + 9.00 = 41.50
        // discount: 41.50 * 0.90 = 37.35
        assertEquals(37.35, FareCalculator.calculateFare(25, 30, 1.0));
    }

    @Test
    @DisplayName("Minimum fare: very short trip")
    void minimumFare() {
        // 2.50 + 0.5*1.20 + 1*0.30 = 2.50 + 0.60 + 0.30 = 3.40 -> min 5.00
        assertEquals(5.0, FareCalculator.calculateFare(0.5, 1, 1.0));
    }
}
