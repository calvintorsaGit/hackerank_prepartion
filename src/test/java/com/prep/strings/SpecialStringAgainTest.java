package com.prep.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialStringAgainTest {

    @Test
    @DisplayName("mnonopoo -> 12 special substrings")
    void sampleCase() {
        assertEquals(12, SpecialStringAgain.substrCount(8, "mnonopoo"));
    }

    @Test
    @DisplayName("aaaa -> 10 special substrings")
    void allSame() {
        assertEquals(10, SpecialStringAgain.substrCount(4, "aaaa"));
    }

    @Test
    @DisplayName("asasd -> 7 special substrings")
    void sampleCase2() {
        assertEquals(7, SpecialStringAgain.substrCount(5, "asasd"));
    }
}
