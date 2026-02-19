package com.prep.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SparseArraysTest {

    @Test
    @DisplayName("Sample: count occurrences of each query")
    void sampleCase() {
        List<String> strings = List.of("aba", "baba", "aba", "xzxb");
        List<String> queries = List.of("aba", "xzxb", "ab");
        assertArrayEquals(new int[] { 2, 1, 0 }, SparseArrays.matchingStrings(strings, queries));
    }

    @Test
    @DisplayName("No matches")
    void noMatches() {
        List<String> strings = List.of("a", "b", "c");
        List<String> queries = List.of("d", "e");
        assertArrayEquals(new int[] { 0, 0 }, SparseArrays.matchingStrings(strings, queries));
    }
}
