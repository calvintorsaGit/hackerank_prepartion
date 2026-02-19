package com.prep.hashmaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyQueriesTest {

    @Test
    @DisplayName("Sample: insert, delete, check frequency")
    void sampleCase() {
        List<int[]> queries = List.of(
                new int[] { 1, 1 }, // insert 1
                new int[] { 2, 2 }, // delete 2 (not present)
                new int[] { 3, 2 }, // check freq 2 -> 0
                new int[] { 1, 1 }, // insert 1 (freq=2)
                new int[] { 1, 1 }, // insert 1 (freq=3)
                new int[] { 2, 1 }, // delete 1 (freq=2)
                new int[] { 3, 2 } // check freq 2 -> 1
        );
        assertEquals(List.of(0, 1), FrequencyQueries.freqQuery(queries));
    }

    @Test
    @DisplayName("All inserts then check")
    void allInserts() {
        List<int[]> queries = List.of(
                new int[] { 1, 5 },
                new int[] { 1, 6 },
                new int[] { 3, 1 } // both 5 and 6 have freq 1
        );
        assertEquals(List.of(1), FrequencyQueries.freqQuery(queries));
    }
}
