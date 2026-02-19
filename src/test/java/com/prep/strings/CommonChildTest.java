package com.prep.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonChildTest {

    @Test
    @DisplayName("HARRY and SALLY -> LCS = 2 (AY)")
    void sampleCase() {
        assertEquals(2, CommonChild.commonChild("HARRY", "SALLY"));
    }

    @Test
    @DisplayName("SHINCHAN and NOHARAAA -> LCS = 3 (NHA)")
    void sampleCase2() {
        assertEquals(3, CommonChild.commonChild("SHINCHAN", "NOHARAAA"));
    }

    @Test
    @DisplayName("AA and BB -> LCS = 0")
    void noCommon() {
        assertEquals(0, CommonChild.commonChild("AA", "BB"));
    }
}
