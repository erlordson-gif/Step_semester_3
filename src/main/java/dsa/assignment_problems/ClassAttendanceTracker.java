package dsa.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Category C · Coding Assignment
 * Problem 6: Class Attendance Tracker
 *
 * TASK:
 * A teacher records attendance for one student as an array of 1s (present) and 0s (absent), one value per day.
 * The teacher wants to know how many days the student was present and the longest run of days the student attended
 * without a break.
 * Implement a function attendanceSummary(days) that returns the number of present days and the length of the
 * longest unbroken run of present days.
 *
 * CONSTRAINTS:
 * • 1 <= length of days <= 100
 * • Each value is 0 or 1
 *
 * EXAMPLES:
 * Sample 1:
 * days = [1, 1, 0, 1, 1, 1, 0, 1]
 * Expected Output: Present: 6, Longest streak: 3
 *
 * Sample 2:
 * days = [0, 0, 0]
 * Expected Output: Present: 0, Longest streak: 0
 *
 * COMPLEXITY REQUIREMENTS:
 * • Single Pass:
 *     - Yes, both answers can be computed in a single linear pass over the array.
 * • Time Complexity:
 *     - O(N) where N is the length of the array, since each element is processed exactly once.
 * • Space Complexity:
 *     - O(1) auxiliary space, requiring only a few integer variables (presentCount, currentStreak, maxStreak).
 *
 * HINT:
 * Keep a running count that grows on every 1 and resets to 0 on every 0; remember the largest value it reaches.
 */
public class ClassAttendanceTracker {

    /**
     * Data structure to encapsulate attendance summary metrics.
     */
    public static class AttendanceResult {
        public final int presentDays;
        public final int longestStreak;

        public AttendanceResult(int presentDays, int longestStreak) {
            this.presentDays = presentDays;
            this.longestStreak = longestStreak;
        }

        @Override
        public String toString() {
            return "Present: " + presentDays + ", Longest streak: " + longestStreak;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof AttendanceResult)) return false;
            AttendanceResult other = (AttendanceResult) obj;
            return this.presentDays == other.presentDays && this.longestStreak == other.longestStreak;
        }

        @Override
        public int hashCode() {
            return 31 * presentDays + longestStreak;
        }
    }

    /**
     * Computes the number of present days and the longest unbroken run of present days.
     *
     * @param days array of integers containing only 1s (present) and 0s (absent)
     * @return AttendanceResult object containing presentDays and longestStreak
     */
    public static AttendanceResult attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return new AttendanceResult(0, 0);
        }

        int presentCount = 0;
        int currentStreak = 0;
        int maxStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new AttendanceResult(presentCount, maxStreak);
    }

    /**
     * Alternative signature returning an int array [presentDays, longestStreak]
     * for compatibility with simple numeric test harnesses.
     */
    public static int[] attendanceSummaryAsArray(int[] days) {
        AttendanceResult res = attendanceSummary(days);
        return new int[]{res.presentDays, res.longestStreak};
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 6: Class Attendance Tracker Demo ===");

        // Sample 1
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        AttendanceResult result1 = attendanceSummary(days1);
        System.out.println("Sample 1:");
        System.out.println("Days: " + Arrays.toString(days1));
        System.out.println("Output: " + result1);
        System.out.println("Expected: Present: 6, Longest streak: 3");

        // Sample 2
        int[] days2 = {0, 0, 0};
        AttendanceResult result2 = attendanceSummary(days2);
        System.out.println("\nSample 2:");
        System.out.println("Days: " + Arrays.toString(days2));
        System.out.println("Output: " + result2);
        System.out.println("Expected: Present: 0, Longest streak: 0");

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    int[] days = new int[n];
                    for (int i = 0; i < n; i++) {
                        days[i] = scanner.nextInt();
                    }
                    AttendanceResult res = attendanceSummary(days);
                    System.out.println(res);
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
