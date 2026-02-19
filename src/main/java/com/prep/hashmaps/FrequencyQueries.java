package com.prep.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HackerRank: Frequency Queries
 * https://www.hackerrank.com/challenges/frequency-queries
 * Difficulty: Medium
 *
 * Process queries:
 *   1 x -> insert x
 *   2 x -> delete one occurrence of x
 *   3 x -> print 1 if any value has exactly frequency x, else 0
 *
 * Key insight: Maintain two maps — value->frequency and frequency->count.
 *
 * Time:  O(q) per query O(1)
 * Space: O(n)
 */
public class FrequencyQueries {

    public static List<Integer> freqQuery(List<int[]> queries) {
        Map<Integer, Integer> valFreq = new HashMap<>();   // value -> its frequency
        Map<Integer, Integer> freqCount = new HashMap<>(); // frequency -> how many values have it
        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int op = query[0], val = query[1];
            int oldFreq = valFreq.getOrDefault(val, 0);

            switch (op) {
                case 1 -> { // insert
                    if (oldFreq > 0) freqCount.merge(oldFreq, -1, Integer::sum);
                    valFreq.put(val, oldFreq + 1);
                    freqCount.merge(oldFreq + 1, 1, Integer::sum);
                }
                case 2 -> { // delete
                    if (oldFreq > 0) {
                        freqCount.merge(oldFreq, -1, Integer::sum);
                        valFreq.put(val, oldFreq - 1);
                        if (oldFreq - 1 > 0) freqCount.merge(oldFreq - 1, 1, Integer::sum);
                    }
                }
                case 3 -> { // check frequency
                    result.add(freqCount.getOrDefault(val, 0) > 0 ? 1 : 0);
                }
            }
        }
        return result;
    }
}
