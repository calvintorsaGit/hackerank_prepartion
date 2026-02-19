package com.prep.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SherlockAndValidStringTest {

    @Test
    @DisplayName("aabbcd -> NO")
    void notValid() {
        assertEquals("NO", SherlockAndValidString.isValid("aabbcd"));
    }

    @Test
    @DisplayName("aabbccddeefghi -> NO")
    void notValid2() {
        assertEquals("NO", SherlockAndValidString.isValid("aabbccddeefghi"));
    }

    @Test
    @DisplayName("abcdefghhgfedecba -> YES")
    void valid() {
        assertEquals("YES", SherlockAndValidString.isValid("abcdefghhgfedecba"));
    }

    @Test
    @DisplayName("aabbc -> YES (remove one c)")
    void validRemoveOne() {
        assertEquals("YES", SherlockAndValidString.isValid("aabbc"));
    }
}
