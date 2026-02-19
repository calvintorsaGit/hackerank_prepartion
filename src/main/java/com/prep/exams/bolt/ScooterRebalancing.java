package com.prep.exams.bolt;

import java.util.*;

/**
 * Bolt Exam: Scooter Rebalancing
 *
 * Scooters need to be redistributed across zones so each zone
 * has at least minScooters available. Given current counts per zone,
 * find the minimum number of scooter moves needed.
 *
 * A move = taking 1 scooter from a surplus zone to a deficit zone.
 *
 * Example:
 * counts = [8, 2, 1, 5], min = 4
 * deficits: zone1 needs 2, zone2 needs 3 -> total moves = 5
 *
 * HOW TO SOLVE:
 * 1. For minimum moves count: just sum all deficits.
 * - Each zone below minPerZone contributes (min - count) to moves.
 * - Total deficit always equals total surplus (conservation).
 * 2. For the rebalance plan (which zone gives to which):
 * - Separate zones into surplus list and deficit list.
 * - Use two pointers: match surplus[i] with deficit[j].
 * - Move min(surplus[i].excess, deficit[j].need) scooters.
 * - Advance pointer when a zone is fully served.
 * 3. This is greedy — any valid assignment works since we only
 * care about total moves, not which specific zones trade.
 *
 * Pattern: Greedy / Math
 * Time: O(n)
 * Space: O(1) for count, O(n) for plan
 */
public class ScooterRebalancing {

    public static int minimumMoves(int[] zoneCounts, int minPerZone) {
        int deficit = 0;

        for (int count : zoneCounts) {
            if (count < minPerZone) {
                deficit += (minPerZone - count);
            }
        }
        return deficit;
    }

    /**
     * Returns which zones to move from/to.
     * Result: list of [fromZone, toZone, count]
     */
    public static List<int[]> rebalancePlan(int[] zoneCounts, int minPerZone) {
        List<int[]> surplus = new ArrayList<>();
        List<int[]> deficitList = new ArrayList<>();

        for (int i = 0; i < zoneCounts.length; i++) {
            if (zoneCounts[i] > minPerZone) {
                surplus.add(new int[] { i, zoneCounts[i] - minPerZone });
            } else if (zoneCounts[i] < minPerZone) {
                deficitList.add(new int[] { i, minPerZone - zoneCounts[i] });
            }
        }

        List<int[]> moves = new ArrayList<>();
        int si = 0, di = 0;

        while (si < surplus.size() && di < deficitList.size()) {
            int from = surplus.get(si)[0];
            int to = deficitList.get(di)[0];
            int move = Math.min(surplus.get(si)[1], deficitList.get(di)[1]);

            moves.add(new int[] { from, to, move });
            surplus.get(si)[1] -= move;
            deficitList.get(di)[1] -= move;

            if (surplus.get(si)[1] == 0)
                si++;
            if (deficitList.get(di)[1] == 0)
                di++;
        }
        return moves;
    }
}
