package dsa.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Category C · Coding Assignment
 * Problem 4: Exam Score Band Counter
 *
 * TASK:
 * A university stores the marks of all students in an exam as an array sorted in ascending order; marks can repeat.
 * Faculty members frequently ask how many students scored within a band [low, high], inclusive of both ends.
 * Implement a function countInBand(scores, low, high) that returns the number of scores s such that low <= s <= high.
 * The array is large and queried very often, so your solution must not scan the scores one by one.
 *
 * CONSTRAINTS:
 * • 1 <= length of scores <= 10^6
 * • scores is sorted in ascending order
 * • 0 <= low <= high <= 100
 *
 * COMPLEXITY REQUIREMENTS:
 * • Linear Scan:
 *     - Time Complexity: O(N) because every element must be inspected.
 *     - Space Complexity: O(1).
 * • Optimized Binary Search Solution:
 *     - Time Complexity: O(log N) via two binary searches (lower bound and upper bound).
 *     - Space Complexity: O(1) auxiliary space.
 * • Duplicates at Edges:
 *     - Because duplicate values can exist at both ends of the band, a standard binary search that stops
 *       at any match is insufficient.
 *     - We use a lower bound search to locate the first index where score >= low.
 *     - We use an upper bound search to locate the first index where score > high.
 *     - The number of elements within [low, high] is simply (upperIndex - lowerIndex).
 */
public class ExamScoreBandCounter {

    /**
     * Counts the number of scores in the inclusive range [low, high] using O(log N) binary search.
     *
     * @param scores sorted array of exam scores in ascending order
     * @param low    inclusive lower threshold
     * @param high   inclusive upper threshold
     * @return the number of scores s such that low <= s <= high
     */
    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int lowerIndex = findFirstGreaterOrEqual(scores, low);
        int upperIndex = findFirstStrictlyGreater(scores, high);

        return upperIndex - lowerIndex;
    }

    /**
     * Finds the first index i such that scores[i] >= target (lower bound).
     * If all elements are < target, returns scores.length.
     */
    public static int findFirstGreaterOrEqual(int[] scores, int target) {
        int left = 0;
        int right = scores.length - 1;
        int result = scores.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                result = mid;
                right = mid - 1; // look left to find the first occurrence
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    /**
     * Finds the first index i such that scores[i] > target (upper bound).
     * If all elements are <= target, returns scores.length.
     */
    public static int findFirstStrictlyGreater(int[] scores, int target) {
        int left = 0;
        int right = scores.length - 1;
        int result = scores.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                result = mid;
                right = mid - 1; // look left to find the first occurrence
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Exam Score Band Counter Demo ===");

        // Sample 1 from assignment
        int[] scores1 = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        int low1 = 42;
        int high1 = 58;
        int output1 = countInBand(scores1, low1, high1);
        System.out.println("Sample 1:");
        System.out.println("Scores: " + Arrays.toString(scores1));
        System.out.println("Range: [" + low1 + ", " + high1 + "]");
        System.out.println("Output: " + output1 + " (Expected: 6)");

        // Sample 2 from assignment
        int[] scores2 = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        int low2 = 90;
        int high2 = 100;
        int output2 = countInBand(scores2, low2, high2);
        System.out.println("\nSample 2:");
        System.out.println("Scores: " + Arrays.toString(scores2));
        System.out.println("Range: [" + low2 + ", " + high2 + "]");
        System.out.println("Output: " + output2 + " (Expected: 0)");

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    int[] scores = new int[n];
                    for (int i = 0; i < n; i++) {
                        scores[i] = scanner.nextInt();
                    }
                    int low = scanner.nextInt();
                    int high = scanner.nextInt();
                    System.out.println(countInBand(scores, low, high));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
