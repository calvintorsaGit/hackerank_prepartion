package com.prep.exams.wise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    @Test
    @DisplayName("USD -> JPY through EUR and GBP")
    void multiHopConversion() {
        String[][] rates = { { "USD", "EUR" }, { "EUR", "GBP" }, { "GBP", "JPY" } };
        double[] values = { 0.85, 0.88, 155.0 };
        double result = CurrencyConverter.convert(rates, values, "USD", "JPY");
        assertEquals(115.94, result, 0.01);
    }

    @Test
    @DisplayName("Direct conversion USD -> EUR")
    void directConversion() {
        String[][] rates = { { "USD", "EUR" } };
        double[] values = { 0.85 };
        assertEquals(0.85, CurrencyConverter.convert(rates, values, "USD", "EUR"), 0.001);
    }

    @Test
    @DisplayName("Reverse conversion EUR -> USD")
    void reverseConversion() {
        String[][] rates = { { "USD", "EUR" } };
        double[] values = { 0.85 };
        assertEquals(1.0 / 0.85, CurrencyConverter.convert(rates, values, "EUR", "USD"), 0.01);
    }

    @Test
    @DisplayName("No path returns -1")
    void noPath() {
        String[][] rates = { { "USD", "EUR" }, { "GBP", "JPY" } };
        double[] values = { 0.85, 155.0 };
        assertEquals(-1.0, CurrencyConverter.convert(rates, values, "USD", "JPY"));
    }

    @Test
    @DisplayName("Same currency returns 1.0")
    void sameCurrency() {
        String[][] rates = { { "USD", "EUR" } };
        double[] values = { 0.85 };
        assertEquals(1.0, CurrencyConverter.convert(rates, values, "USD", "USD"));
    }
}
