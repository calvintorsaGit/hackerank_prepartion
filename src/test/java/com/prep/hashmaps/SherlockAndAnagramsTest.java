package com.prep.hashmaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SherlockAndAnagramsTest {

    @Test
    @DisplayName("abba -> 4 anagrammatic pairs")
    void sampleCase1() {
        assertEquals(4, SherlockAndAnagrams.sherlockAndAnagrams("abba"));
    }

    @Test
    @DisplayName("abcd -> 0 anagrammatic pairs")
    void sampleCase2() {
        assertEquals(0, SherlockAndAnagrams.sherlockAndAnagrams("abcd"));
    }

    @Test
    @DisplayName("kkkk -> 10 anagrammatic pairs")
    void allSame() {
        assertEquals(10, SherlockAndAnagrams.sherlockAndAnagrams("kkkk"));
    }
}
