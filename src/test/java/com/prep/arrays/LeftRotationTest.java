package com.prep.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftRotationTest {

    @Test
    @DisplayName("Rotate [1,2,3,4,5] left by 4 = [5,1,2,3,4]")
    void sampleCase() {
        int[] arr = { 1, 2, 3, 4, 5 };
        assertArrayEquals(new int[] { 5, 1, 2, 3, 4 }, LeftRotation.rotateLeft(arr, 4));
    }

    @Test
    @DisplayName("Rotate by 0 = same array")
    void rotateByZero() {
        int[] arr = { 1, 2, 3 };
        assertArrayEquals(new int[] { 1, 2, 3 }, LeftRotation.rotateLeft(arr, 0));
    }

    @Test
    @DisplayName("Rotate by array length = same array")
    void rotateByLength() {
        int[] arr = { 1, 2, 3 };
        assertArrayEquals(new int[] { 1, 2, 3 }, LeftRotation.rotateLeft(arr, 3));
    }
}
