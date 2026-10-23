package dsa.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 3: Even and Odd Numbers in a List
 *
 * TASK:
 * Given a list of integers, write a program to count how many numbers in the list are even and how many
 * are odd. Print the counts for both categories.
 *
 * EXAMPLE:
 * Sample Input: [3, 8, 12, 5, 7, 10]
 * Expected Output: Even: 3
 *                  Odd: 3
 */
public class EvenAndOddNumbersInList {

    public static class ParityResult {
        public final int even;
        public final int odd;

        public ParityResult(int even, int odd) {
            this.even = even;
            this.odd = odd;
        }

        @Override
        public String toString() {
            return "Even: " + even + "\nOdd: " + odd;
        }
    }

    public static ParityResult countEvenAndOdd(int[] numbers) {
        if (numbers == null) return new ParityResult(0, 0);
        int even = 0;
        int odd = 0;
        for (int n : numbers) {
            if (n % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return new ParityResult(even, odd);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Even and Odd Numbers in a List Demo ===");
        int[] sample = {3, 8, 12, 5, 7, 10};
        System.out.println("Input: " + Arrays.toString(sample));
        System.out.println(countEvenAndOdd(sample));

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    int[] arr = new int[n];
                    for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
                    System.out.println(countEvenAndOdd(arr));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
