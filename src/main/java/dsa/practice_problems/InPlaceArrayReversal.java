package dsa.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 4: In-Place Array Reversal
 *
 * TASK:
 * Write a program that reverses the order of token numbers stored in a list. The reversal must be done
 * 'in-place', meaning you should modify the original list directly without creating a second list.
 *
 * EXAMPLE:
 * Sample Input: [11, 22, 33, 44]
 * Expected Output: [44, 33, 22, 11]
 *
 * HINT:
 * Use two pointers, one starting from the beginning and one from the end of the array. Swap the
 * elements at these pointers and move them towards the center until they meet or cross.
 */
public class InPlaceArrayReversal {

    public static void reverseInPlace(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: In-Place Array Reversal Demo ===");
        int[] sample = {11, 22, 33, 44};
        System.out.println("Original: " + Arrays.toString(sample));
        reverseInPlace(sample);
        System.out.println("Reversed: " + Arrays.toString(sample));

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    int[] arr = new int[n];
                    for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
                    reverseInPlace(arr);
                    System.out.println(Arrays.toString(arr));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
