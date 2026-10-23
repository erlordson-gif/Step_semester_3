package dsa.practice_problems;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 7: Factorial Calculation
 *
 * TASK:
 * Write a program that reads a non-negative integer and calculates its factorial. The factorial of a
 * non-negative integer 'n', denoted by 'n!', is the product of all positive integers less than or equal to 'n'.
 * The factorial of 0 is defined as 1.
 *
 * EXAMPLE:
 * Sample Input: 5
 *               0
 * Expected Output: 120
 *                  1
 *
 * HINT:
 * Use a loop to multiply numbers from 1 up to the input number. Handle the special case for 0 factorial.
 */
public class FactorialCalculation {

    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger calculateFactorialBig(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 7: Factorial Calculation Demo ===");
        int[] samples = {5, 0};
        for (int s : samples) {
            System.out.println("Input: " + s + " -> Output: " + calculateFactorial(s));
        }

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    System.out.println(calculateFactorial(n));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
