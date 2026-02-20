package com.prep.exams.wise.practice;

/**
 * Wise Exam: Rate Limiter
 *
 * Implement a rate limiter: allow at most maxRequests
 * within a sliding window of windowSeconds.
 *
 * processRequests takes a batch of request timestamps and returns
 * boolean[] where true = allowed, false = rate limited.
 *
 * Timestamps are in seconds, non-decreasing order.
 *
 * Example:
 * maxReq=3, windowSec=10, requests=[1, 2, 3, 4, 5]
 * Output: [true, true, true, false, false]
 * (3 requests in window, 4th and 5th blocked)
 *
 * maxReq=2, windowSec=5, requests=[1, 2, 3, 7, 8]
 * Output: [true, true, false, true, true]
 * (t=7: window [3,7], old requests expired)
 */
public class RateLimiterPractice {

    public static boolean[] processRequests(int maxReq, int windowSec, int[] requestTimes) {
        // YOUR SOLUTION HERE
        return new boolean[] {};
    }
}
