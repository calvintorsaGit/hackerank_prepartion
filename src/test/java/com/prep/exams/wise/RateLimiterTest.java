package com.prep.exams.wise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateLimiterTest {

    @Test
    @DisplayName("Allow up to max, then reject")
    void basicLimit() {
        boolean[] results = RateLimiter.processRequests(3, 10,
                new int[] { 1, 2, 3, 4, 5 });
        assertArrayEquals(new boolean[] { true, true, true, false, false }, results);
    }

    @Test
    @DisplayName("Window expires, new requests allowed")
    void windowExpiry() {
        boolean[] results = RateLimiter.processRequests(2, 5,
                new int[] { 1, 2, 3, 7, 8 });
        // t=1,2: allowed. t=3: blocked. t=7: window [3,7], t=1,2 expired -> allowed.
        // t=8: allowed
        assertArrayEquals(new boolean[] { true, true, false, true, true }, results);
    }
}
