package com.prep.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FraudulentActivityTest {

    @Test
    @DisplayName("Sample: [2,3,4,2,3,6,8,4,5] d=5 -> 2 notifications")
    void sampleCase() {
        assertEquals(2, FraudulentActivity.activityNotifications(
                new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 5));
    }

    @Test
    @DisplayName("[1,2,3,4,4] d=4 -> 0 notifications")
    void noNotifications() {
        assertEquals(0, FraudulentActivity.activityNotifications(
                new int[] { 1, 2, 3, 4, 4 }, 4));
    }
}
