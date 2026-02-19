package com.prep.sorting;

/**
 * HackerRank: Fraudulent Activity Notifications
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications
 * Difficulty: Medium
 *
 * Client gets a notification if day's spending >= 2 * median of trailing d
 * days.
 * 
 * Key insight: Expenditures are 0..200, so use counting sort for O(1) median.
 * Slide the window: add new day, remove oldest day from counts.
 *
 * Time: O(n * 200) -> O(n)
 * Space: O(200) -> O(1)
 */
public class FraudulentActivity {

    public static int activityNotifications(int[] expenditure, int d) {
        int[] counts = new int[201]; // values 0..200
        int notifications = 0;

        // initialize window
        for (int i = 0; i < d; i++) {
            counts[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {
            double median = getMedian(counts, d);
            if (expenditure[i] >= 2 * median) {
                notifications++;
            }
            // slide window
            counts[expenditure[i]]++;
            counts[expenditure[i - d]]--;
        }
        return notifications;
    }

    private static double getMedian(int[] counts, int d) {
        if (d % 2 == 1) {
            // odd: find the (d/2 + 1)th element
            int target = d / 2 + 1;
            int cum = 0;
            for (int i = 0; i < counts.length; i++) {
                cum += counts[i];
                if (cum >= target)
                    return i;
            }
        } else {
            // even: average of (d/2)th and (d/2 + 1)th elements
            int t1 = d / 2, t2 = d / 2 + 1;
            int cum = 0;
            int first = -1;
            for (int i = 0; i < counts.length; i++) {
                cum += counts[i];
                if (first == -1 && cum >= t1)
                    first = i;
                if (cum >= t2)
                    return (first + i) / 2.0;
            }
        }
        return 0;
    }
}
