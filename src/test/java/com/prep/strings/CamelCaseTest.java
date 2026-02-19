package com.prep.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CamelCaseTest {

    @Test
    @DisplayName("saveChangesInTheEditor -> 5 words")
    void sampleCase() {
        assertEquals(5, CamelCase.camelcase("saveChangesInTheEditor"));
    }

    @Test
    @DisplayName("single word")
    void singleWord() {
        assertEquals(1, CamelCase.camelcase("hello"));
    }
}
