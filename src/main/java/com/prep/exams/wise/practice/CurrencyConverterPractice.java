package com.prep.exams.wise.practice;

/**
 * Wise Exam: Currency Converter
 *
 * Given exchange rates between currency pairs, find the conversion
 * rate from source to target currency. If no path exists, return -1.0.
 * If source == target, return 1.0.
 *
 * Rates are bidirectional: if USD->EUR = 0.85, then EUR->USD = 1/0.85.
 *
 * Input:
 * - rates: String[][] pairs, e.g. [["USD","EUR"], ["EUR","GBP"]]
 * - values: double[] rate for each pair, e.g. [0.85, 0.88]
 * - source, target: currency codes
 *
 * Example:
 * rates=[["USD","EUR"],["EUR","GBP"],["GBP","JPY"]]
 * values=[0.85, 0.88, 155.0]
 * convert("USD", "JPY") -> 0.85 * 0.88 * 155.0 = 115.94
 */
public class CurrencyConverterPractice {

    public static double convert(String[][] rates, double[] values,
            String source, String target) {
        // YOUR SOLUTION HERE
        return -1.0;
    }
}
