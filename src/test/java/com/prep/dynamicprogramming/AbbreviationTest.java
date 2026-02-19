package com.prep.dynamicprogramming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbbreviationTest {

    @Test
    @DisplayName("daBcd and ABC -> YES")
    void sampleYes() {
        assertEquals("YES", Abbreviation.abbreviation("daBcd", "ABC"));
    }

    @Test
    @DisplayName("AbcDE and AFDE -> NO")
    void sampleNo() {
        assertEquals("NO", Abbreviation.abbreviation("AbcDE", "AFDE"));
    }

    @Test
    @DisplayName("aAbCc and ABC -> YES (capitalize a,c, delete extra)")
    void deleteLowercase() {
        assertEquals("YES", Abbreviation.abbreviation("aAbCc", "ABC"));
    }
}
