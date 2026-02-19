package com.prep.exams.wise;

import java.util.*;

/**
 * Wise Exam: Currency Converter
 * 
 * Given a list of exchange rates between currency pairs,
 * find the best conversion rate from source to target currency.
 * If no path exists, return -1.0.
 *
 * Example:
 * rates: [["USD","EUR",0.85], ["EUR","GBP",0.88], ["GBP","JPY",155.0]]
 * query: USD -> JPY
 * answer: 0.85 * 0.88 * 155.0 = 115.94
 *
 * Pattern: BFS on currency graph (similar to evaluate division on LeetCode)
 *
 * Time: O(V + E) per query
 * Space: O(V + E)
 */
public class CurrencyConverter {

    public static double convert(String[][] rates, double[] values,
            String source, String target) {
        if (source.equals(target))
            return 1.0;

        // build adjacency list: currency -> [(neighbor, rate)]
        Map<String, List<double[]>> graph = new HashMap<>();
        Map<String, Integer> currencyIndex = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < rates.length; i++) {
            String from = rates[i][0], to = rates[i][1];
            double rate = values[i];

            if (!currencyIndex.containsKey(from))
                currencyIndex.put(from, idx++);
            if (!currencyIndex.containsKey(to))
                currencyIndex.put(to, idx++);

            graph.computeIfAbsent(from, k -> new ArrayList<>())
                    .add(new double[] { currencyIndex.get(to), rate });
            graph.computeIfAbsent(to, k -> new ArrayList<>())
                    .add(new double[] { currencyIndex.get(from), 1.0 / rate });
        }

        if (!currencyIndex.containsKey(source) || !currencyIndex.containsKey(target)) {
            return -1.0;
        }

        // BFS to find conversion path
        Queue<String> queue = new LinkedList<>();
        Map<String, Double> visited = new HashMap<>();
        queue.offer(source);
        visited.put(source, 1.0);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            double currRate = visited.get(curr);

            if (curr.equals(target))
                return currRate;

            for (double[] neighbor : graph.getOrDefault(curr, List.of())) {
                // find currency name by index
                String neighborName = null;
                for (var entry : currencyIndex.entrySet()) {
                    if (entry.getValue() == (int) neighbor[0]) {
                        neighborName = entry.getKey();
                        break;
                    }
                }

                if (neighborName != null && !visited.containsKey(neighborName)) {
                    visited.put(neighborName, currRate * neighbor[1]);
                    queue.offer(neighborName);
                }
            }
        }
        return -1.0;
    }
}
