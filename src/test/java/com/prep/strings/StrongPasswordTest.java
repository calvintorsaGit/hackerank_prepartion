package com.prep.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrongPasswordTest {

    @Test
    @DisplayName("Ab1 -> need 3 (special + length)")
    void sampleCase() {
        assertEquals(3, StrongPassword.minimumNumber(3, "Ab1"));
    }

    @Test
    @DisplayName("Already strong password")
    void alreadyStrong() {
        assertEquals(0, StrongPassword.minimumNumber(11, "#HackerRank1"));
    }

    @Test
    @DisplayName("Only digits, short")
    void onlyDigits() {
        assertEquals(3, StrongPassword.minimumNumber(3, "123"));
    }
}
