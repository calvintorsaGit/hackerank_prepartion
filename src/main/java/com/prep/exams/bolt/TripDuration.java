package com.prep.exams.bolt;

import java.util.*;

/**
 * Bolt Exam: Trip Duration
 *
 * Given a city road network as a weighted graph, find the shortest
 * travel time from pickup to dropoff location.
 *
 * Input: n nodes, edges [[from, to, weight], ...], source, target
 * Output: shortest travel time, or -1 if unreachable
 *
 * HOW TO SOLVE:
 * 1. Build adjacency list: for each node, store [(neighbor, weight)].
 * Roads are bidirectional, so add edge in both directions.
 * 2. Use Dijkstra's algorithm (BFS won't work — edges have weights).
 * 3. Initialize dist[] = INF for all nodes, dist[source] = 0.
 * 4. Use a min-heap (PriorityQueue) sorted by distance.
 * 5. Process: poll closest unvisited node, relax all neighbors.
 * - If dist[u] + w < dist[v], update and push to heap.
 * - Skip stale entries (d > dist[u]).
 * 6. When target is popped from heap, that's the answer.
 * 7. If heap empties without reaching target, return -1.
 *
 * Why Dijkstra over BFS? BFS works for unweighted graphs.
 * Dijkstra handles weighted edges with non-negative weights.
 *
 * Pattern: Dijkstra's algorithm
 * Time: O((V + E) log V)
 * Space: O(V + E)
 */
public class TripDuration {

    public static int shortestTime(int n, int[][] edges, int source, int target) {
        // build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
            graph.get(edge[1]).add(new int[] { edge[0], edge[2] }); // bidirectional
        }

        // Dijkstra's
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // min-heap: [distance, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, source });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1];

            if (u == target)
                return d;
            if (d > dist[u])
                continue; // skip outdated entry

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[] { dist[v], v });
                }
            }
        }
        return -1; // unreachable
    }
}
