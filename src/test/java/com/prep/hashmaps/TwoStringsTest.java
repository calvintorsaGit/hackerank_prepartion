package com.prep.hashmaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoStringsTest {

    @Test
    @DisplayName("Share common character")
    void shareCommon() {
        assertEquals("YES", TwoStrings.twoStrings("hello", "world"));
    }

    @Test
    @DisplayName("No common character")
    void noCommon() {
        assertEquals("NO", TwoStrings.twoStrings("hi", "world"));
    }
}
