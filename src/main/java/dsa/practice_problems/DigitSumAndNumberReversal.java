package dsa.practice_problems;

import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 5: Digit Sum and Number Reversal
 *
 * TASK:
 * Write a program that reads a positive integer and performs two operations: it calculates and prints the
 * sum of its digits, and it prints the number with its digits reversed.
 *
 * EXAMPLE:
 * Sample Input: 4721
 * Expected Output: Sum of digits: 14
 *                  Reverse: 1274
 *
 * HINT:
 * To extract digits, repeatedly use the modulo operator (%) by 10 to get the last digit and integer
 * division (/) by 10 to remove the last digit. Build the reversed number by multiplying the current
 * reversed number by 10 and adding the extracted digit.
 */
public class DigitSumAndNumberReversal {

    public static class DigitResult {
        public final int sum;
        public final int reversed;

        public DigitResult(int sum, int reversed) {
            this.sum = sum;
            this.reversed = reversed;
        }

        @Override
        public String toString() {
            return "Sum of digits: " + sum + "\nReverse: " + reversed;
        }
    }

    public static DigitResult processNumber(int number) {
        int sum = 0;
        int reversed = 0;
        int temp = Math.abs(number);

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return new DigitResult(sum, reversed);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Digit Sum and Number Reversal Demo ===");
        int sample = 4721;
        System.out.println("Sample Input: " + sample);
        System.out.println(processNumber(sample));

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    System.out.println(processNumber(num));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
