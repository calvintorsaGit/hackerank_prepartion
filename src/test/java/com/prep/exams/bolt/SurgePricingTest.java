package com.prep.exams.bolt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurgePricingTest {

    @Test
    @DisplayName("No surge when supply meets demand")
    void noSurge() {
        double[] result = SurgePricing.calculateSurge(new int[] { 10 }, new int[] { 10 });
        assertEquals(1.0, result[0]);
    }

    @Test
    @DisplayName("Moderate surge: 2x demand")
    void moderateSurge() {
        double[] result = SurgePricing.calculateSurge(new int[] { 20 }, new int[] { 10 });
        assertEquals(1.5, result[0]); // ratio=2 -> 1.0 + 1.0*0.5 = 1.5
    }

    @Test
    @DisplayName("Max surge when no drivers")
    void maxSurge() {
        double[] result = SurgePricing.calculateSurge(new int[] { 50 }, new int[] { 0 });
        assertEquals(5.0, result[0]);
    }

    @Test
    @DisplayName("Multiple zones")
    void multipleZones() {
        double[] result = SurgePricing.calculateSurge(
                new int[] { 5, 20, 30 }, new int[] { 10, 10, 10 });
        assertEquals(1.0, result[0]); // ratio 0.5
        assertEquals(1.5, result[1]); // ratio 2.0
        assertEquals(2.25, result[2]); // ratio 3.0
    }
}
