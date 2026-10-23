package dsa.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Category C · Coding Assignment
 * Problem 8: Duty Roster Rotation
 *
 * TASK:
 * A hostel rotates its cleaning duty roster every week by moving each name k places to the right; names
 * that go past the end wrap around to the front.
 * Implement a function rotateRoster(names, k) that returns the roster after rotating it to the right
 * by k places. k may be larger than the number of names.
 *
 * CONSTRAINTS:
 * • 1 <= length of names <= 100
 * • 0 <= k <= 10^9
 *
 * EXAMPLES:
 * Sample 1:
 * names = [A, B, C, D, E], k = 2
 * Expected Output: [D, E, A, B, C]
 *
 * Sample 2:
 * names = [A, B, C, D, E], k = 7
 * Expected Output: [D, E, A, B, C] // 7 places is the same as 2
 *
 * COMPLEXITY REQUIREMENTS:
 * • Naive 1-step Rotation Approach:
 *     - If we rotate 1 position at a time k times, the time complexity is O(k * n).
 *     - With k up to 10^9 and n up to 100, this requires up to 10^11 operations, leading to extreme Time Limit Exceeded (TLE).
 * • Optimized Modulo Index Mapping Solution:
 *     - By computing effective rotation: k_eff = k % n, all redundant full rotations are eliminated in O(1).
 *     - Time Complexity: O(n) to place each element into its calculated index: (i + k_eff) % n.
 *     - Space Complexity: O(n) to construct the rotated array (or O(1) auxiliary space using 3-reversal algorithm in-place).
 *
 * HINT:
 * Use k % n to remove full turns. Each name at index i moves to index (i + k) % n.
 */
public class DutyRosterRotation {

    /**
     * Rotates the array of roster names to the right by k places.
     *
     * @param names array of names representing the duty roster
     * @param k     number of places to rotate to the right (can be up to 10^9)
     * @return new array containing the rotated roster
     */
    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length <= 1) {
            return names == null ? null : names.clone();
        }

        int n = names.length;
        int effectiveK = (int) (k % n);
        if (effectiveK < 0) {
            effectiveK += n;
        }

        if (effectiveK == 0) {
            return names.clone();
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + effectiveK) % n] = names[i];
        }

        return rotated;
    }

    /**
     * Overloaded method for integer k.
     */
    public static String[] rotateRoster(String[] names, int k) {
        return rotateRoster(names, (long) k);
    }

    /**
     * Performs an in-place rotation using the 3-step reversal algorithm in O(n) time and O(1) space.
     * 1. Reverse entire array.
     * 2. Reverse first k elements.
     * 3. Reverse remaining n - k elements.
     */
    public static void rotateRosterInPlace(String[] names, long k) {
        if (names == null || names.length <= 1) return;
        int n = names.length;
        int effK = (int) (k % n);
        if (effK < 0) effK += n;
        if (effK == 0) return;

        reverse(names, 0, n - 1);
        reverse(names, 0, effK - 1);
        reverse(names, effK, n - 1);
    }

    private static void reverse(String[] arr, int start, int end) {
        while (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 8: Duty Roster Rotation Demo ===");

        // Sample 1
        String[] names1 = {"A", "B", "C", "D", "E"};
        int k1 = 2;
        String[] result1 = rotateRoster(names1, k1);
        System.out.println("Sample 1:");
        System.out.println("Names: " + Arrays.toString(names1) + ", k = " + k1);
        System.out.println("Output:   " + Arrays.toString(result1));
        System.out.println("Expected: [D, E, A, B, C]");

        // Sample 2
        String[] names2 = {"A", "B", "C", "D", "E"};
        int k2 = 7;
        String[] result2 = rotateRoster(names2, k2);
        System.out.println("\nSample 2:");
        System.out.println("Names: " + Arrays.toString(names2) + ", k = " + k2);
        System.out.println("Output:   " + Arrays.toString(result2));
        System.out.println("Expected: [D, E, A, B, C] // 7 places is the same as 2");

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    String[] names = new String[n];
                    for (int i = 0; i < n; i++) {
                        names[i] = scanner.next();
                    }
                    long k = scanner.nextLong();
                    System.out.println(Arrays.toString(rotateRoster(names, k)));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
