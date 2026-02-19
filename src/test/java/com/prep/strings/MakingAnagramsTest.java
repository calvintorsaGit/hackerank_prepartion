package com.prep.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakingAnagramsTest {

    @Test
    @DisplayName("cde and abc -> 4 deletions")
    void sampleCase() {
        assertEquals(4, MakingAnagrams.makeAnagram("cde", "abc"));
    }

    @Test
    @DisplayName("Same strings -> 0 deletions")
    void sameStrings() {
        assertEquals(0, MakingAnagrams.makeAnagram("abc", "abc"));
    }

    @Test
    @DisplayName("No common chars -> delete all")
    void noCommon() {
        assertEquals(6, MakingAnagrams.makeAnagram("abc", "xyz"));
    }
}
