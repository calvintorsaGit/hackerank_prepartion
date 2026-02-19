package com.prep.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerComparatorTest {

    @Test
    @DisplayName("Sort by score desc, then name asc")
    void sampleCase() {
        String[][] players = { { "amy", "100" }, { "david", "100" }, { "heraldo", "50" } };
        String[][] result = PlayerComparator.sortPlayers(players);
        assertEquals("amy", result[0][0]);
        assertEquals("david", result[1][0]);
        assertEquals("heraldo", result[2][0]);
    }
}
