package dsa.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Category C · Coding Assignment
 * Problem 7: Second-Best Score
 *
 * TASK:
 * A quiz app stores the scores of all players in an array. Prizes go to the top two different scores, so the app
 * needs the second-highest distinct score. If every player has the same score, there is no second-highest score.
 * Implement a function secondHighest(scores) that returns the second-highest distinct score, or -1 if it does not exist.
 *
 * CONSTRAINTS:
 * • 1 <= length of scores <= 1000
 * • 0 <= scores[i] <= 100
 * • Do not sort the array
 *
 * EXAMPLES:
 * Sample 1:
 * scores = [45, 78, 92, 78, 60]
 * Expected Output: 78
 *
 * Sample 2:
 * scores = [50, 50, 50]
 * Expected Output: -1
 *
 * COMPLEXITY REQUIREMENTS & COMPARISON WITH SORTING:
 * • Sorting Approach:
 *     - If we sort the array first, time complexity is O(N log N) using comparison sorts.
 *     - Sorting may also modify the original input array or require O(N) extra space.
 *     - Most importantly, the problem explicitly states: "Do not sort the array".
 * • Single-Pass Optimal Solution:
 *     - Time Complexity: O(N) since each score is inspected exactly once in a single pass.
 *     - Space Complexity: O(1) auxiliary space (using only two integer variables: highest and second).
 *     - Operates without modifying the original array order.
 *
 * HINT:
 * Keep two variables, highest and second, and update them as you visit each score once. Skip a score that equals
 * the current highest.
 */
public class SecondBestScore {

    /**
     * Finds and returns the second-highest distinct score in the given array, or -1 if none exists.
     *
     * @param scores array of player scores (0 <= scores[i] <= 100)
     * @return the second-highest distinct score, or -1 if all scores are identical or array length < 2
     */
    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
            // If score == highest, ignore because we only want distinct top scores
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 7: Second-Best Score Demo ===");

        // Sample 1
        int[] scores1 = {45, 78, 92, 78, 60};
        int result1 = secondHighest(scores1);
        System.out.println("Sample 1:");
        System.out.println("Scores: " + Arrays.toString(scores1));
        System.out.println("Second Highest: " + result1 + " (Expected: 78)");

        // Sample 2
        int[] scores2 = {50, 50, 50};
        int result2 = secondHighest(scores2);
        System.out.println("\nSample 2:");
        System.out.println("Scores: " + Arrays.toString(scores2));
        System.out.println("Second Highest: " + result2 + " (Expected: -1)");

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    int[] scores = new int[n];
                    for (int i = 0; i < n; i++) {
                        scores[i] = scanner.nextInt();
                    }
                    System.out.println(secondHighest(scores));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
