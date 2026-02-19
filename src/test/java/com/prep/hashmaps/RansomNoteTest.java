package com.prep.hashmaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RansomNoteTest {

    @Test
    @DisplayName("Can form note from magazine")
    void canForm() {
        String[] magazine = { "give", "me", "one", "grand", "today", "night" };
        String[] note = { "give", "one", "grand", "today" };
        assertTrue(RansomNote.checkMagazine(magazine, note));
    }

    @Test
    @DisplayName("Cannot form: missing word")
    void cannotForm() {
        String[] magazine = { "two", "times", "three", "is", "not", "four" };
        String[] note = { "two", "times", "two", "is", "four" };
        assertFalse(RansomNote.checkMagazine(magazine, note));
    }
}
