package com.prep.searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamParlorTest {

    @Test
    @DisplayName("money=4 costs=[1,4,5,3,2] -> indices [1,4]")
    void sampleCase() {
        assertArrayEquals(new int[] { 1, 4 }, IceCreamParlor.icecreamParlor(4, new int[] { 1, 4, 5, 3, 2 }));
    }

    @Test
    @DisplayName("money=4 costs=[2,2,4,3] -> indices [1,2]")
    void duplicateCosts() {
        assertArrayEquals(new int[] { 1, 2 }, IceCreamParlor.icecreamParlor(4, new int[] { 2, 2, 4, 3 }));
    }
}
