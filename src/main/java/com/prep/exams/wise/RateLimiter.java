package com.prep.exams.wise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Wise Exam: Rate Limiter
 *
 * Implement a rate limiter that allows at most maxRequests
 * in a sliding window of windowSeconds.
 *
 * isAllowed(timestamp) returns true if the request is allowed.
 *
 * Pattern: Sliding window with Queue
 *
 * Time: O(1) amortized per call
 * Space: O(maxRequests)
 */
public class RateLimiter {

    private final int maxRequests;
    private final int windowSeconds;
    private final Queue<Integer> timestamps;

    public RateLimiter(int maxRequests, int windowSeconds) {
        this.maxRequests = maxRequests;
        this.windowSeconds = windowSeconds;
        this.timestamps = new LinkedList<>();
    }

    public boolean isAllowed(int timestamp) {
        // remove expired timestamps
        while (!timestamps.isEmpty() && timestamps.peek() <= timestamp - windowSeconds) {
            timestamps.poll();
        }

        if (timestamps.size() < maxRequests) {
            timestamps.offer(timestamp);
            return true;
        }
        return false;
    }

    /**
     * Process a batch of request timestamps.
     * Returns array of booleans: true if allowed, false if rate limited.
     */
    public static boolean[] processRequests(int maxReq, int windowSec, int[] requestTimes) {
        RateLimiter limiter = new RateLimiter(maxReq, windowSec);
        boolean[] results = new boolean[requestTimes.length];
        for (int i = 0; i < requestTimes.length; i++) {
            results[i] = limiter.isAllowed(requestTimes[i]);
        }
        return results;
    }
}
