package com.prep.searching;

import java.util.TreeSet;

/**
 * HackerRank: Triple Sum
 * https://www.hackerrank.com/challenges/triple-sum
 * Difficulty: Medium
 *
 * Given 3 arrays a, b, c, find distinct triplets (p, q, r)
 * where p is from a, q is from b, r is from c,
 * and p <= q and r <= q.
 *
 * Key insight: Sort and deduplicate. For each q in b,
 * count elements <= q in a and c, multiply counts.
 *
 * Time: O(n log n)
 * Space: O(n)
 */
public class TripleSum {

    public static long triplets(int[] a, int[] b, int[] c) {
        long[] da = dedupSort(a);
        long[] db = dedupSort(b);
        long[] dc = dedupSort(c);

        long count = 0;
        int ai = 0, ci = 0;

        for (long q : db) {
            while (ai < da.length && da[ai] <= q)
                ai++;
            while (ci < dc.length && dc[ci] <= q)
                ci++;
            count += (long) ai * ci;
        }
        return count;
    }

    private static long[] dedupSort(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int v : arr)
            set.add(v);
        return set.stream().mapToLong(Integer::longValue).toArray();
    }
}
